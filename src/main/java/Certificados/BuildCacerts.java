package Certificados;

import javax.net.ssl.*;
import java.io.*;
import java.net.SocketException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class BuildCacerts {

    private static final int TIMEOUT_WS = 30;

    public static byte[] gerarCacerts(String url, int port) throws FileNotFoundException, KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException, Exception {
        char[] password = "changeit".toCharArray();
        char SEP = File.separatorChar;
        File dir = new File(System.getProperty("java.home") + SEP + "lib" + SEP + "security");
        File file = new File(dir, "Cacerts");
        if (file.isFile() == false) {
            file = new File(dir, "cacerts");
        }

        info("| Loading KeyStore " + file.getAbsolutePath() + "...");
        KeyStore ks;
        try (InputStream in = new FileInputStream(file)) {
            ks = KeyStore.getInstance(KeyStore.getDefaultType());
            ks.load(in, password);

            try {
                get(url, port, ks);
            } catch (Exception ex) {
                System.out.println("Erro na cadeia de certificados: "+url);
            }            
            
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ks.store(baos, password);
            baos.close();
            return baos.toByteArray();
        }
    }

    public static void get(String host, int port, KeyStore ks) throws Exception {
        SSLContext context = SSLContext.getInstance("TLS");
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(
                TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(ks);
        X509TrustManager defaultTrustManager = (X509TrustManager) tmf.getTrustManagers()[0];
        SavingTrustManager tm = new SavingTrustManager(defaultTrustManager);
        context.init(null, new TrustManager[]{tm}, null);
        SSLSocketFactory factory = context.getSocketFactory();

        info("| Opening connection to " + host + ":" + port + "...");
        SSLSocket socket = (SSLSocket) factory.createSocket(host, port);
        socket.setSoTimeout(TIMEOUT_WS * 1000);
        try {
            info("| Starting SSL handshake...");
            socket.startHandshake();
            socket.close();
            info("| No errors, certificate is already trusted");
        } catch (SSLHandshakeException e) {
            error("| " + e.toString());
            /**
             * PKIX path building failed:
             * sun.security.provider.certpath.SunCertPathBuilderException:
             * unable to find valid certification path to requested target Não
             * tratado, pois sempre ocorre essa exceo quando o cacerts nao esta
             * gerado.
             */
        } catch (SSLException | SocketException e) {
            error("| " + e.toString());
        } 

        X509Certificate[] chain = tm.chain;
        if (chain == null) {
            info("| Could not obtain server certificate chain");
        } else {
            info("| Server sent " + chain.length + " certificate(s):");
            MessageDigest sha1 = MessageDigest.getInstance("SHA1");
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            for (int i = 0; i < chain.length; i++) {
                X509Certificate cert = chain[i];
                sha1.update(cert.getEncoded());
                md5.update(cert.getEncoded());

                String alias = host + "-" + (i);
                ks.setCertificateEntry(alias, cert);
                info("| Added certificate to keystore using alias '" + alias + "'");
            }
        }
    }

    private static class SavingTrustManager implements X509TrustManager {

        private final X509TrustManager tm;
        private X509Certificate[] chain;

        SavingTrustManager(X509TrustManager tm) {
            this.tm = tm;
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
            // throw new UnsupportedOperationException();
        }

        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
            throw new UnsupportedOperationException();
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
            this.chain = chain;
            this.tm.checkServerTrusted(chain, authType);
        }
    }

    private static void info(String log) {
        System.out.println("INFO: " + log);
    }

    private static void error(String log) {
        System.out.println("ERROR: " + log);
    }

}
