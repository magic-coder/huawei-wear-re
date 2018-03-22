package com.huawei.hwid.core.p430b.p433b;

import android.content.Context;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: AccountX509TrustManager */
public class C5143a implements X509TrustManager {
    protected ArrayList<X509TrustManager> f18574a = new ArrayList();

    public C5143a(Context context) {
        InputStream inputStream = null;
        try {
            C5165e.m24912e("AccountX509TrustManager", "new AccountX509TrustManager start");
            TrustManagerFactory instance = TrustManagerFactory.getInstance("X509");
            KeyStore instance2 = KeyStore.getInstance("bks");
            inputStream = context.getAssets().open("hicloudroot.bks");
            inputStream.reset();
            instance2.load(inputStream, "".toCharArray());
            inputStream.close();
            instance.init(instance2);
            TrustManager[] trustManagers = instance.getTrustManagers();
            for (int i = 0; i < trustManagers.length; i++) {
                if (trustManagers[i] instanceof X509TrustManager) {
                    this.f18574a.add((X509TrustManager) trustManagers[i]);
                }
            }
            if (this.f18574a.isEmpty()) {
                throw new NullPointerException("Couldn't find a X509TrustManager!");
            }
            C5165e.m24912e("AccountX509TrustManager", "new AccountX509TrustManager end");
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    C5165e.m24906b("AccountX509TrustManager", e.getMessage());
                }
            }
        } catch (Throwable e2) {
            C5165e.m24911d("AccountX509TrustManager", "IOException / " + e2.getMessage(), e2);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    C5165e.m24906b("AccountX509TrustManager", e3.getMessage());
                }
            }
        } catch (Throwable e22) {
            C5165e.m24911d("AccountX509TrustManager", "NoSuchAlgorithmException / " + e22.getMessage(), e22);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e32) {
                    C5165e.m24906b("AccountX509TrustManager", e32.getMessage());
                }
            }
        } catch (Throwable e222) {
            C5165e.m24911d("AccountX509TrustManager", "CertificateException / " + e222.getMessage(), e222);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e322) {
                    C5165e.m24906b("AccountX509TrustManager", e322.getMessage());
                }
            }
        } catch (Throwable e2222) {
            C5165e.m24911d("AccountX509TrustManager", "KeyStoreException / " + e2222.getMessage(), e2222);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3222) {
                    C5165e.m24906b("AccountX509TrustManager", e3222.getMessage());
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    C5165e.m24906b("AccountX509TrustManager", e4.getMessage());
                }
            }
        }
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        try {
            C5165e.m24904a("AccountX509TrustManager", "checkClientTrusted start");
            ((X509TrustManager) this.f18574a.get(0)).checkClientTrusted(x509CertificateArr, str);
        } catch (Throwable e) {
            C5165e.m24911d("AccountX509TrustManager", "CertificateException:" + e.getMessage(), e);
        }
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        C5165e.m24904a("AccountX509TrustManager", "checkServerTrusted  start authType=" + str);
        ((X509TrustManager) this.f18574a.get(0)).checkServerTrusted(x509CertificateArr, str);
        C5165e.m24904a("AccountX509TrustManager", "checkServerTrusted end ");
    }

    public X509Certificate[] getAcceptedIssuers() {
        C5165e.m24912e("AccountX509TrustManager", "getAcceptedIssuers start");
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f18574a.iterator();
        while (it.hasNext()) {
            arrayList.addAll(Arrays.asList(((X509TrustManager) it.next()).getAcceptedIssuers()));
        }
        return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
    }
}
