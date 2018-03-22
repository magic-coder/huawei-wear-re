package com.huawei.up.p520e;

import com.huawei.p190v.C2538c;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/* compiled from: HttpConnectionAdaptor */
class C6131e implements X509TrustManager {
    final /* synthetic */ C6130d f21185a;

    C6131e(C6130d c6130d) {
        this.f21185a = c6130d;
    }

    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        C2538c.b("HttpConnetionAdaptor", new Object[]{"checkServerTrusted"});
        ((X509TrustManager) this.f21185a.f21183a.get(0)).checkServerTrusted(x509CertificateArr, str);
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
    }
}
