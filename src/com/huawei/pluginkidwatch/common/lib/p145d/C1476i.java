package com.huawei.pluginkidwatch.common.lib.p145d;

import com.huawei.p190v.C2538c;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/* compiled from: SecureSSLSocketFactory */
class C1476i implements X509TrustManager {
    final /* synthetic */ C1475h f3439a;

    C1476i(C1475h c1475h) {
        this.f3439a = c1475h;
    }

    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        C2538c.m12674b("MySSLSocketFactory", "checkServerTrusted");
        ((X509TrustManager) this.f3439a.f3437a.get(0)).checkServerTrusted(x509CertificateArr, str);
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
    }
}
