package com.huawei.hwversionmgr.utils;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: HwX509TrustManagerEx */
public class C5392d implements X509TrustManager {
    private X509TrustManager f19183a = null;

    public C5392d(KeyStore keyStore) throws KeyStoreException, NoSuchAlgorithmException {
        TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        instance.init(keyStore);
        TrustManager[] trustManagers = instance.getTrustManagers();
        if (trustManagers.length == 0) {
            throw new NoSuchAlgorithmException("None factory trust-manager found");
        }
        this.f19183a = (X509TrustManager) trustManagers[0];
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        this.f19183a.checkClientTrusted(x509CertificateArr, str);
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        if (x509CertificateArr == null) {
            return;
        }
        if (1 == x509CertificateArr.length) {
            x509CertificateArr[0].checkValidity();
        } else {
            this.f19183a.checkServerTrusted(x509CertificateArr, str);
        }
    }

    public X509Certificate[] getAcceptedIssuers() {
        return this.f19183a.getAcceptedIssuers();
    }
}
