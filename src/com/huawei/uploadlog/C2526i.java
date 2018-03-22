package com.huawei.uploadlog;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/* compiled from: SecureNetSSLSocketFactory */
class C2526i implements X509TrustManager {
    final /* synthetic */ C2525h f9011a;

    C2526i(C2525h c2525h) {
        this.f9011a = c2525h;
    }

    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
    }
}
