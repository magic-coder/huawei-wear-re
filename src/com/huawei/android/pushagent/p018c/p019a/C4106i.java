package com.huawei.android.pushagent.p018c.p019a;

import android.content.Context;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.p018c.p019a.p026a.C4100f;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class C4106i implements X509TrustManager {
    X509TrustManager f15495a;

    public C4106i(Context context) throws Exception {
        InputStream inputStream = null;
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance("X509");
            KeyStore instance2 = KeyStore.getInstance("BKS");
            inputStream = context.getAssets().open("rootca_0727.bks");
            inputStream.reset();
            instance2.load(inputStream, C4100f.m20116b(null, C4104d.m20128b()).toCharArray());
            instance.init(instance2);
            TrustManager[] trustManagers = instance.getTrustManagers();
            for (int i = 0; i < trustManagers.length; i++) {
                if (trustManagers[i] instanceof X509TrustManager) {
                    this.f15495a = (X509TrustManager) trustManagers[i];
                    return;
                }
            }
            if (inputStream != null) {
                inputStream.close();
            }
            throw new Exception("Couldn't initialize");
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        e.a("PushLogSC2712", "check ClientTrusted");
        this.f15495a.checkClientTrusted(x509CertificateArr, str);
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        e.a("PushLogSC2712", "check ServerTrusted");
        this.f15495a.checkServerTrusted(x509CertificateArr, str);
    }

    public X509Certificate[] getAcceptedIssuers() {
        return this.f15495a.getAcceptedIssuers();
    }
}
