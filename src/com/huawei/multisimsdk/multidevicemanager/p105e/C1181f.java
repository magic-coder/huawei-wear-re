package com.huawei.multisimsdk.multidevicemanager.p105e;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/* compiled from: HttpConnectionUtils */
class C1181f implements X509TrustManager {
    final /* synthetic */ C1180e f2597a;

    C1181f(C1180e c1180e) {
        this.f2597a = c1180e;
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
    }

    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}
