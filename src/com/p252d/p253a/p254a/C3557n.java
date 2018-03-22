package com.p252d.p253a.p254a;

import java.io.IOException;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* compiled from: MySSLSocketFactory */
public class C3557n extends SSLSocketFactory {
    SSLContext f13564a = SSLContext.getInstance(SSLSocketFactory.TLS);

    public C3557n(KeyStore keyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super(keyStore);
        C3558o c3558o = new C3558o(this);
        this.f13564a.init(null, new TrustManager[]{c3558o}, null);
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return this.f13564a.getSocketFactory().createSocket(socket, str, i, z);
    }

    public Socket createSocket() throws IOException {
        return this.f13564a.getSocketFactory().createSocket();
    }

    public static KeyStore m17883a() {
        KeyStore instance;
        Throwable th;
        try {
            instance = KeyStore.getInstance(KeyStore.getDefaultType());
            try {
                instance.load(null, null);
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                return instance;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            instance = null;
            th = th4;
            th.printStackTrace();
            return instance;
        }
        return instance;
    }

    public static SSLSocketFactory m17884b() {
        try {
            SSLSocketFactory c3557n = new C3557n(C3557n.m17883a());
            c3557n.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            return c3557n;
        } catch (Throwable th) {
            th.printStackTrace();
            return SSLSocketFactory.getSocketFactory();
        }
    }
}
