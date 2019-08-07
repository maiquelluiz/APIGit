/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Certificados;

import Apoio.GzipUtils;
import Apoio.SystemExceptions;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.SocketFactory;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509KeyManager;

import org.apache.commons.httpclient.ConnectTimeoutException;
import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;

public class HSProtocolSocketFactory implements ProtocolSocketFactory {

    private SSLContext ssl = null;
    private final X509Certificate certificate;
    private final PrivateKey privateKey;

    //String caminho;
    public HSProtocolSocketFactory(X509Certificate certificate, PrivateKey privateKey) {
        this.certificate = certificate;
        this.privateKey = privateKey;
    }

    private SSLContext createSSLContext(String url, int port) throws SystemExceptions.CacertException {
        try {
            KeyManager[] keyManagers = createKeyManagers();
            TrustManager[] trustManagers = createTrustManagers(url, port);
            SSLContext sslContext = SSLContext.getInstance("TLS");
            //SSLContext sslContext = SSLContext.getInstance("TLSv1");
            sslContext.init(keyManagers, trustManagers, null);
            return sslContext;
        } catch (SystemExceptions.CacertException | NoSuchAlgorithmException | KeyManagementException ex) {
            ex.printStackTrace();
            throw new SystemExceptions.CacertException(ex.getMessage());
        }
    }

    private SSLContext getSSLContext(String url, int port) throws SystemExceptions.CacertException {
        if (ssl == null) {
            ssl = createSSLContext(url, port);
        }
        return ssl;
    }

    @Override
    public Socket createSocket(String host, int port, InetAddress localAddress, int localPort, HttpConnectionParams params) throws ConnectTimeoutException{
        
        try {
            if (params == null) {
                throw new IllegalArgumentException("Parameters may not be null");
            }
            int timeout = params.getConnectionTimeout();
            SocketFactory socketfactory = getSSLContext(host, port).getSocketFactory();
            if (timeout == 0) {
                return socketfactory.createSocket(host, port, localAddress, localPort);
            }            
            Socket socket = socketfactory.createSocket();
            ((SSLSocket) socket).setEnabledProtocols(new String[]{"SSLv3", "TLSv1"});
            SocketAddress localaddr = new InetSocketAddress(localAddress, localPort);
            SocketAddress remoteaddr = new InetSocketAddress(host, port);
            socket.bind(localaddr);
            socket.connect(remoteaddr, timeout);
            return socket;
        } catch (SystemExceptions.CacertException | IOException ex) {
            ex.printStackTrace();
            throw new ConnectTimeoutException("Erro na conexao", ex);
        }
        
    }

    @Override
    public Socket createSocket(String host, int port, InetAddress clientHost, int clientPort) throws IOException {
        try {
            return getSSLContext(host, port).getSocketFactory().createSocket(host, port, clientHost, clientPort);
        } catch (SystemExceptions.CacertException ex) {
            ex.printStackTrace();
            throw new ConnectTimeoutException("Erro na conexao", ex);
        }
    }

    @Override
    public Socket createSocket(String host, int port) throws IOException {
        try {
            return getSSLContext(host, port).getSocketFactory().createSocket(host, port);
        } catch (SystemExceptions.CacertException ex) {
            ex.printStackTrace();
            throw new ConnectTimeoutException("Erro na conexao", ex);
        }
    }

    public Socket createSocket(Socket socket, String host, int port, boolean autoClose) throws IOException{
        try {
            return getSSLContext(host, port).getSocketFactory().createSocket(socket, host, port, autoClose);
        } catch (SystemExceptions.CacertException ex) {
            ex.printStackTrace();
            throw new ConnectTimeoutException("Erro na conexao", ex);
        }
    }

    public KeyManager[] createKeyManagers() {
        HSKeyManager keyManager = new HSKeyManager(certificate, privateKey);

        return new KeyManager[]{keyManager};
    }

    public TrustManager[] createTrustManagers(String url, int port) throws SystemExceptions.CacertException {
        try {
            KeyStore trustStore = KeyStore.getInstance("JKS");
            trustStore.load(GzipUtils.Byte_to_InputStream(BuildCacerts.gerarCacerts(url, port)), "changeit".toCharArray());
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(trustStore);
            return trustManagerFactory.getTrustManagers();
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

    class HSKeyManager implements X509KeyManager {

        private final X509Certificate certificate;
        private final PrivateKey privateKey;

        public HSKeyManager(X509Certificate certificate, PrivateKey privateKey) {
            this.certificate = certificate;
            this.privateKey = privateKey;
        }

        @Override
        public String chooseClientAlias(String[] arg0, Principal[] arg1, Socket arg2) {
            return certificate.getIssuerDN().getName();
        }

        @Override
        public String chooseServerAlias(String arg0, Principal[] arg1, Socket arg2) {
            return null;
        }

        @Override
        public X509Certificate[] getCertificateChain(String arg0) {
            return new X509Certificate[]{certificate};
        }

        @Override
        public String[] getClientAliases(String arg0, Principal[] arg1) {
            return new String[]{certificate.getIssuerDN().getName()};
        }

        @Override
        public PrivateKey getPrivateKey(String arg0) {
            return privateKey;
        }

        @Override
        public String[] getServerAliases(String arg0, Principal[] arg1) {
            return null;
        }
    }
}
