package com.huawei.hwid.core.p430b.p433b;

import android.content.Context;
import android.os.Build.VERSION;
import com.huawei.hwid.core.encrypt.C5203g;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* compiled from: HttpClientConnetManager */
class C5146c extends SSLSocketFactory {
    private static Object f18577d = new Object();
    SSLContext f18578a = SSLContext.getInstance(SSLSocketFactory.TLS);
    Context f18579b;
    boolean f18580c;

    public C5146c(KeyStore keyStore, Context context, boolean z) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException {
        C5143a c5143a;
        super(keyStore);
        this.f18579b = context;
        this.f18580c = z;
        try {
            c5143a = new C5143a(this.f18579b);
        } catch (Throwable e) {
            C5165e.m24911d("MySSLSocketFactory", "Initialize AccountX509TrustManager failed.", e);
            c5143a = null;
        }
        this.f18578a.init(null, new TrustManager[]{c5143a}, new SecureRandom());
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException, UnknownHostException {
        SSLSocket sSLSocket;
        Socket createSocket = this.f18578a.getSocketFactory().createSocket(socket, str, i, z);
        if (createSocket instanceof SSLSocket) {
            sSLSocket = (SSLSocket) createSocket;
        } else {
            createSocket = null;
        }
        C5165e.m24906b("MySSLSocketFactory", "host =" + C5203g.m25316a(str) + "port=" + C5203g.m25315a(Integer.valueOf(i)) + "autoclouse=" + z);
        C5145b.m24822a(sSLSocket);
        if (this.f18580c) {
            C5145b.m24821a((Socket) sSLSocket);
        }
        if (str.contains("hicloud.com")) {
            if (VERSION.SDK_INT < 22) {
                synchronized (f18577d) {
                    getHostnameVerifier().verify(str, sSLSocket);
                }
            } else {
                getHostnameVerifier().verify(str, sSLSocket);
            }
        }
        return sSLSocket;
    }

    public Socket createSocket() throws IOException {
        Socket createSocket = this.f18578a.getSocketFactory().createSocket();
        if (createSocket instanceof SSLSocket) {
            createSocket = (SSLSocket) createSocket;
        } else {
            createSocket = null;
        }
        C5145b.m24822a((SSLSocket) createSocket);
        if (this.f18580c) {
            C5145b.m24821a(createSocket);
        }
        return createSocket;
    }
}
