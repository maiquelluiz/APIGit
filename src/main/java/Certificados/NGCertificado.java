package Certificados;

import Apoio.GzipUtils;
import Apoio.SystemExceptions;
import Apoio.TrataString;
import org.apache.commons.httpclient.protocol.Protocol;

import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * @author Maiquel
 */
public class NGCertificado {
    TrataString TS = new TrataString();

    public static void A1() throws SystemExceptions.DBeException, SystemExceptions.CertificadoException, KeyStoreException {
        try {
            System.out.println("Usando A1");
            String senha = OBJKeyStoreA1.getInstance().getSenha();
            KeyStore ks = OBJKeyStoreA1.getInstance().getKeyStore();
            String alias = ks.aliases().nextElement();
            Protocol protocol = new Protocol("https", new HSProtocolSocketFactory((X509Certificate) ks.getCertificate(alias), (PrivateKey) ks.getKey(alias, senha.toCharArray())), 443);
            Protocol.registerProtocol("https", protocol);
            System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");
            System.setProperty("javax.net.ssl.keyStoreType", ks.getType());
            System.setProperty("javax.net.ssl.keyStorePassword", senha);
            System.setProperty("sun.security.ssl.allowUnsafeRenegotiation", "true");
            System.setProperty("javax.net.ssl.keyStore", "NONE");
            System.setProperty("javax.net.ssl.trustStoreType", "JKS");
        } catch (NoSuchAlgorithmException | UnrecoverableKeyException ex) {
            ex.printStackTrace();
            throw new SystemExceptions.CertificadoException(ex.getMessage());
        }
    }

    public static void Cacert(String url, int port) throws SystemExceptions.CacertException{
        try {
            info("Usando CACERT");
            KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
            ks.load(GzipUtils.Byte_to_InputStream(BuildCacerts.gerarCacerts(url, port)), "changeit".toCharArray());
            String alias = ks.aliases().nextElement();
            Protocol protocol = new Protocol("https", new HSProtocolSocketFactory((X509Certificate) ks.getCertificate(alias), (PrivateKey) ks.getKey(alias, "changeit".toCharArray())), 443);
            Protocol.registerProtocol("https", protocol);
            System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");
            System.setProperty("javax.net.ssl.keyStoreType", ks.getType());
            System.setProperty("javax.net.ssl.keyStorePassword", "changeit");
            System.setProperty("sun.security.ssl.allowUnsafeRenegotiation", "true");
            System.setProperty("javax.net.ssl.keyStore", "NONE");
            System.setProperty("javax.net.ssl.trustStoreType", "JKS");
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new SystemExceptions.CacertException(ex.getMessage());
        } catch (NoSuchAlgorithmException | CertificateException ex) {
            ex.printStackTrace();
            throw new SystemExceptions.CacertException(ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new SystemExceptions.CacertException(ex.getMessage());
        }
    }

    /**
     * Log ERROR.
     *
     * @param error
     */
    private void error(String error) {
        System.out.println("| ERROR: " + error);
    }

    /**
     * Log INFO.
     *
     * @param info
     */
    private static void info(String info) {
        System.out.println("| INFO: " + info);
    }

}
