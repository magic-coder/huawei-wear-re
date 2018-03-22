package com.huawei.hwappdfxmgr.p056f;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: HwX509TrustMangerEx */
public class C4591b implements X509TrustManager {
    private X509TrustManager f16808a = null;

    public C4591b(KeyStore keyStore) throws KeyStoreException, NoSuchAlgorithmException {
        TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        instance.init(keyStore);
        TrustManager[] trustManagers = instance.getTrustManagers();
        if (trustManagers.length == 0) {
            throw new NoSuchAlgorithmException("None factory trust-manager found");
        }
        this.f16808a = (X509TrustManager) trustManagers[0];
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        this.f16808a.checkClientTrusted(x509CertificateArr, str);
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        if (x509CertificateArr == null) {
            return;
        }
        if (1 == x509CertificateArr.length) {
            x509CertificateArr[0].checkValidity();
        } else {
            this.f16808a.checkServerTrusted(x509CertificateArr, str);
        }
    }

    public X509Certificate[] getAcceptedIssuers() {
        return this.f16808a.getAcceptedIssuers();
    }
}
