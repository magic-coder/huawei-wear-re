package com.p230a.p231b.p232b.p233a.p236a;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

public class C3090d implements X509TrustManager {
    private static TrustManager[] f10382a;
    private static final X509Certificate[] f10383b = new X509Certificate[0];

    public static void m13823a() {
        SSLContext instance;
        NoSuchAlgorithmException e;
        KeyManagementException e2;
        HttpsURLConnection.setDefaultHostnameVerifier(new C3101o());
        if (f10382a == null) {
            f10382a = new TrustManager[]{new C3090d()};
        }
        try {
            instance = SSLContext.getInstance(SSLSocketFactory.TLS);
            try {
                instance.init(null, f10382a, new SecureRandom());
            } catch (NoSuchAlgorithmException e3) {
                e = e3;
                e.printStackTrace();
                HttpsURLConnection.setDefaultSSLSocketFactory(instance.getSocketFactory());
            } catch (KeyManagementException e4) {
                e2 = e4;
                e2.printStackTrace();
                HttpsURLConnection.setDefaultSSLSocketFactory(instance.getSocketFactory());
            }
        } catch (NoSuchAlgorithmException e5) {
            NoSuchAlgorithmException noSuchAlgorithmException = e5;
            instance = null;
            e = noSuchAlgorithmException;
            e.printStackTrace();
            HttpsURLConnection.setDefaultSSLSocketFactory(instance.getSocketFactory());
        } catch (KeyManagementException e6) {
            KeyManagementException keyManagementException = e6;
            instance = null;
            e2 = keyManagementException;
            e2.printStackTrace();
            HttpsURLConnection.setDefaultSSLSocketFactory(instance.getSocketFactory());
        }
        HttpsURLConnection.setDefaultSSLSocketFactory(instance.getSocketFactory());
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    public X509Certificate[] getAcceptedIssuers() {
        return f10383b;
    }
}
