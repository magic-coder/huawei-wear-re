package com.huawei.androidcommon.dependence;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

public class TrustAllSSLSocketFactory extends SSLSocketFactory {
    SSLContext sslContext = SSLContext.getInstance(SSLSocketFactory.TLS);

    class C06641 implements X509TrustManager {
        C06641() {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }
    }

    public TrustAllSSLSocketFactory(KeyStore keyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super(keyStore);
        C06641 c06641 = new C06641();
        this.sslContext.init(null, new TrustManager[]{c06641}, null);
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException, UnknownHostException {
        return this.sslContext.getSocketFactory().createSocket(socket, str, i, z);
    }

    public Socket createSocket() throws IOException {
        return this.sslContext.getSocketFactory().createSocket();
    }
}
