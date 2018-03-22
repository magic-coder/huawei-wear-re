package com.huawei.aj.p315a;

import android.content.Context;
import com.huawei.wallet.utils.log.LogC;
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

/* compiled from: PayX509TrustManager */
public class C4023a implements X509TrustManager {
    protected ArrayList<X509TrustManager> f15306a = new ArrayList();

    public C4023a(Context context) {
        InputStream inputStream = null;
        if (context == null) {
            try {
                throw new IOException("context cannot be null");
            } catch (Throwable e) {
                LogC.m28529b("IOException / " + e.toString(), e, false);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        LogC.m28530b(e2.toString(), false);
                    }
                }
            } catch (Throwable e3) {
                LogC.m28529b("NoSuchAlgorithmException / " + e3.toString(), e3, false);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e22) {
                        LogC.m28530b(e22.toString(), false);
                    }
                }
            } catch (Throwable e32) {
                LogC.m28529b("CertificateException / " + e32.toString(), e32, false);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e222) {
                        LogC.m28530b(e222.toString(), false);
                    }
                }
            } catch (Throwable e322) {
                LogC.m28529b("KeyStoreException / " + e322.toString(), e322, false);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2222) {
                        LogC.m28530b(e2222.toString(), false);
                    }
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        LogC.m28530b(e4.toString(), false);
                    }
                }
            }
        } else {
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
                    this.f15306a.add((X509TrustManager) trustManagers[i]);
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e22222) {
                    LogC.m28530b(e22222.toString(), false);
                }
            }
        }
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        try {
            LogC.m28527a("checkClientTrusted start", false);
            if (this.f15306a.isEmpty()) {
                LogC.m28534d("Couldn't find a X509TrustManager", false);
            } else {
                ((X509TrustManager) this.f15306a.get(0)).checkClientTrusted(x509CertificateArr, str);
            }
        } catch (Throwable e) {
            LogC.m28529b("CertificateException:" + e.getMessage(), e, false);
        }
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        LogC.m28527a("checkServerTrusted  start authType=" + str, false);
        if (this.f15306a.isEmpty()) {
            LogC.m28534d("Couldn't find a X509TrustManager", false);
        } else {
            ((X509TrustManager) this.f15306a.get(0)).checkServerTrusted(x509CertificateArr, str);
        }
        LogC.m28527a("checkServerTrusted end ", false);
    }

    public X509Certificate[] getAcceptedIssuers() {
        LogC.m28530b("getAcceptedIssuers start", false);
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f15306a.iterator();
        while (it.hasNext()) {
            arrayList.addAll(Arrays.asList(((X509TrustManager) it.next()).getAcceptedIssuers()));
        }
        return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
    }
}
