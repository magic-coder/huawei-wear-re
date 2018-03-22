package com.huawei.hwcommonmodel.p064d;

import android.content.Context;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.p190v.C2538c;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.log4j.helpers.DateLayout;

/* compiled from: SecureNetSSLSocketFactory */
public class C4730i extends SSLSocketFactory {
    private static final ArrayList<X509TrustManager> f17276b = new ArrayList();
    private static X509TrustManager[] f17277c = new X509TrustManager[]{new C4731j()};
    SSLContext f17278a = null;

    public C4730i() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException, IOException {
        InputStream open;
        Throwable th;
        Throwable th2;
        InputStream inputStream = null;
        try {
            Context b = BaseApplication.b();
            if (b != null) {
                open = b.getResources().getAssets().open("hicloudroot.cer");
                try {
                    C2538c.b("SecureNetSSLSocketFactory", new Object[]{"" + CertificateFactory.getInstance("X.509").generateCertificate(open).toString()});
                    KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
                    instance.load(null, null);
                    instance.setCertificateEntry("trust", r0);
                    TrustManagerFactory instance2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                    instance2.init(instance);
                    TrustManager[] trustManagers = instance2.getTrustManagers();
                    for (int i = 0; i < trustManagers.length; i++) {
                        if (trustManagers[i] instanceof X509TrustManager) {
                            f17276b.add((X509TrustManager) trustManagers[i]);
                        }
                    }
                    if (f17276b.isEmpty()) {
                        throw new RuntimeException("Couldn't find a X509TrustManager!");
                    }
                    this.f17278a = SSLContext.getInstance(org.apache.http.conn.ssl.SSLSocketFactory.TLS);
                    this.f17278a.init(null, f17277c, new SecureRandom());
                } catch (GeneralSecurityException e) {
                    inputStream = open;
                    try {
                        C2538c.e("SecureNetSSLSocketFactory", new Object[]{"SSLContext init exception"});
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e2) {
                                C2538c.e("SecureNetSSLSocketFactory", new Object[]{e2.getMessage()});
                                return;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        open = inputStream;
                        th2 = th;
                        if (open != null) {
                            try {
                                open.close();
                            } catch (IOException e3) {
                                C2538c.e("SecureNetSSLSocketFactory", new Object[]{e3.getMessage()});
                            }
                        }
                        throw th2;
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (open != null) {
                        open.close();
                    }
                    throw th2;
                }
            }
            C2538c.e("SecureNetSSLSocketFactory", new Object[]{"SSLContext init exception context is null"});
            open = null;
            if (open != null) {
                try {
                    open.close();
                } catch (IOException e22) {
                    C2538c.e("SecureNetSSLSocketFactory", new Object[]{e22.getMessage()});
                }
            }
        } catch (GeneralSecurityException e4) {
            C2538c.e("SecureNetSSLSocketFactory", new Object[]{"SSLContext init exception"});
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Throwable th32) {
            th = th32;
            open = null;
            th2 = th;
            if (open != null) {
                open.close();
            }
            throw th2;
        }
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        Socket createSocket = this.f17278a.getSocketFactory().createSocket(socket, str, i, z);
        if (createSocket == null) {
            return null;
        }
        C4730i.m22634a((SSLSocket) createSocket);
        return createSocket;
    }

    public static void m22634a(SSLSocket sSLSocket) {
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        List arrayList = new ArrayList();
        String str = "";
        for (String str2 : enabledCipherSuites) {
            String toUpperCase = str2.toUpperCase(Locale.US);
            if (!(toUpperCase.contains("RC4") || toUpperCase.contains("DES") || toUpperCase.contains("MD5") || toUpperCase.contains("ANON") || toUpperCase.contains(DateLayout.NULL_DATE_FORMAT))) {
                arrayList.add(str2);
            }
        }
        sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getSupportedCipherSuites() {
        return new String[0];
    }

    public Socket createSocket(String str, int i) throws IOException, UnknownHostException {
        Socket createSocket = this.f17278a.getSocketFactory().createSocket(str, i);
        if (createSocket == null) {
            return null;
        }
        C4730i.m22634a((SSLSocket) createSocket);
        return createSocket;
    }

    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        Socket createSocket = this.f17278a.getSocketFactory().createSocket(inetAddress, i);
        if (createSocket == null) {
            return null;
        }
        C4730i.m22634a((SSLSocket) createSocket);
        return createSocket;
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        Socket createSocket = this.f17278a.getSocketFactory().createSocket(str, i, inetAddress, i2);
        if (createSocket == null) {
            return null;
        }
        C4730i.m22634a((SSLSocket) createSocket);
        return createSocket;
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        Socket createSocket = this.f17278a.getSocketFactory().createSocket(inetAddress, i, inetAddress2, i2);
        if (createSocket == null) {
            return null;
        }
        C4730i.m22634a((SSLSocket) createSocket);
        return createSocket;
    }
}
