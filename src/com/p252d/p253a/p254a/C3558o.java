package com.p252d.p253a.p254a;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/* compiled from: MySSLSocketFactory */
class C3558o implements X509TrustManager {
    final /* synthetic */ C3557n f13565a;

    C3558o(C3557n c3557n) {
        this.f13565a = c3557n;
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
    }

    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}
