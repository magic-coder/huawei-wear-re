package com.huawei.membercenter.sdk.membersdklibrary.p092a.p472d;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* compiled from: HttpsUtils */
public final class C5481c {

    /* compiled from: HttpsUtils */
    final class C54801 implements X509TrustManager {
        C54801() {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }

        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }
    }

    public static void m26182a() {
        TrustManager[] trustManagerArr = new TrustManager[]{new C54801()};
        try {
            SSLContext instance = SSLContext.getInstance(SSLSocketFactory.TLS);
            instance.init(null, trustManagerArr, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(instance.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
