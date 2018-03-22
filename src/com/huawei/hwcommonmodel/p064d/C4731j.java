package com.huawei.hwcommonmodel.p064d;

import com.huawei.p190v.C2538c;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/* compiled from: SecureNetSSLSocketFactory */
final class C4731j implements X509TrustManager {
    C4731j() {
    }

    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        if (C4730i.f17276b.isEmpty()) {
            C2538c.c("SecureNetSSLSocketFactory", new Object[]{"Couldn't find a X509TrustManager"});
            return;
        }
        ((X509TrustManager) C4730i.f17276b.get(0)).checkServerTrusted(x509CertificateArr, str);
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
    }
}
