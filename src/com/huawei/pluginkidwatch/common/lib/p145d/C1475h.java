package com.huawei.pluginkidwatch.common.lib.p145d;

import android.content.Context;
import com.huawei.p190v.C2538c;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.log4j.helpers.DateLayout;

/* compiled from: SecureSSLSocketFactory */
public class C1475h extends SSLSocketFactory {
    protected ArrayList<X509TrustManager> f3437a = new ArrayList();
    SSLContext f3438b = SSLContext.getInstance(SSLSocketFactory.TLS);

    public C1475h(KeyStore keyStore, Context context) throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        IOException e;
        Throwable th;
        NoSuchAlgorithmException e2;
        CertificateException e3;
        KeyStoreException e4;
        super(keyStore);
        InputStream open;
        try {
            open = context.getResources().getAssets().open("hicloudroot.cer");
            try {
                Certificate generateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(open);
                keyStore.load(null, null);
                keyStore.setCertificateEntry("trust", generateCertificate);
                TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                instance.init(keyStore);
                TrustManager[] trustManagers = instance.getTrustManagers();
                for (int i = 0; i < trustManagers.length; i++) {
                    if (trustManagers[i] instanceof X509TrustManager) {
                        this.f3437a.add((X509TrustManager) trustManagers[i]);
                    }
                }
                if (this.f3437a.isEmpty()) {
                    throw new RuntimeException("Couldn't find a X509TrustManager!");
                }
                C2538c.m12674b("AccountX509TrustManager", "new AccountX509TrustManager end");
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException e5) {
                        C2538c.m12674b("MySSLSocketFactory", e5.getMessage());
                    }
                }
                this.f3438b.init(null, new X509TrustManager[]{new C1476i(this)}, new SecureRandom());
            } catch (IOException e6) {
                e5 = e6;
                try {
                    C2538c.m12680e("AccountX509TrustManager", "IOException / " + e5.getMessage());
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e52) {
                            C2538c.m12674b("MySSLSocketFactory", e52.getMessage());
                        }
                    }
                    this.f3438b.init(null, new X509TrustManager[]{new C1476i(this)}, new SecureRandom());
                } catch (Throwable th2) {
                    th = th2;
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e7) {
                            C2538c.m12674b("MySSLSocketFactory", e7.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (NoSuchAlgorithmException e8) {
                e2 = e8;
                C2538c.m12680e("AccountX509TrustManager", "NoSuchAlgorithmException / " + e2.getMessage());
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException e522) {
                        C2538c.m12674b("MySSLSocketFactory", e522.getMessage());
                    }
                }
                this.f3438b.init(null, new X509TrustManager[]{new C1476i(this)}, new SecureRandom());
            } catch (CertificateException e9) {
                e3 = e9;
                C2538c.m12680e("AccountX509TrustManager", "CertificateException / " + e3.getMessage());
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException e5222) {
                        C2538c.m12674b("MySSLSocketFactory", e5222.getMessage());
                    }
                }
                this.f3438b.init(null, new X509TrustManager[]{new C1476i(this)}, new SecureRandom());
            } catch (KeyStoreException e10) {
                e4 = e10;
                C2538c.m12680e("AccountX509TrustManager", "KeyStoreException / " + e4.getMessage());
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException e52222) {
                        C2538c.m12674b("MySSLSocketFactory", e52222.getMessage());
                    }
                }
                this.f3438b.init(null, new X509TrustManager[]{new C1476i(this)}, new SecureRandom());
            }
        } catch (IOException e11) {
            e52222 = e11;
            open = null;
            C2538c.m12680e("AccountX509TrustManager", "IOException / " + e52222.getMessage());
            if (open != null) {
                open.close();
            }
            this.f3438b.init(null, new X509TrustManager[]{new C1476i(this)}, new SecureRandom());
        } catch (NoSuchAlgorithmException e12) {
            e2 = e12;
            open = null;
            C2538c.m12680e("AccountX509TrustManager", "NoSuchAlgorithmException / " + e2.getMessage());
            if (open != null) {
                open.close();
            }
            this.f3438b.init(null, new X509TrustManager[]{new C1476i(this)}, new SecureRandom());
        } catch (CertificateException e13) {
            e3 = e13;
            open = null;
            C2538c.m12680e("AccountX509TrustManager", "CertificateException / " + e3.getMessage());
            if (open != null) {
                open.close();
            }
            this.f3438b.init(null, new X509TrustManager[]{new C1476i(this)}, new SecureRandom());
        } catch (KeyStoreException e14) {
            e4 = e14;
            open = null;
            C2538c.m12680e("AccountX509TrustManager", "KeyStoreException / " + e4.getMessage());
            if (open != null) {
                open.close();
            }
            this.f3438b.init(null, new X509TrustManager[]{new C1476i(this)}, new SecureRandom());
        } catch (Throwable th3) {
            th = th3;
            open = null;
            if (open != null) {
                open.close();
            }
            throw th;
        }
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        C2538c.m12674b("MySSLSocketFactory", "----createSocket------one---");
        SSLSocket sSLSocket = (SSLSocket) this.f3438b.getSocketFactory().createSocket(socket, str, i, z);
        C1475h.m6803a(sSLSocket);
        return sSLSocket;
    }

    public Socket createSocket() throws IOException {
        C2538c.m12674b("MySSLSocketFactory", "----createSocket------two---");
        SSLSocket sSLSocket = (SSLSocket) this.f3438b.getSocketFactory().createSocket();
        C1475h.m6803a(sSLSocket);
        return sSLSocket;
    }

    public static void m6803a(SSLSocket sSLSocket) {
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        List arrayList = new ArrayList();
        for (String str : enabledCipherSuites) {
            if (str.toUpperCase().contains("AES") && !str.toUpperCase().contains("ANON") && !str.toUpperCase().contains(DateLayout.NULL_DATE_FORMAT) && str.toUpperCase().contains("SHA")) {
                arrayList.add(str);
            }
        }
        sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
    }
}
