package com.tencent.open.p532d;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* compiled from: ProGuard */
public class C6398k extends SSLSocketFactory {
    private final SSLContext f22236a = SSLContext.getInstance(SSLSocketFactory.TLS);

    public C6398k(KeyStore keyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        C6400m c6400m;
        super(keyStore);
        try {
            c6400m = new C6400m();
        } catch (Exception e) {
            c6400m = null;
        }
        this.f22236a.init(null, new TrustManager[]{c6400m}, null);
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException, UnknownHostException {
        return this.f22236a.getSocketFactory().createSocket(socket, str, i, z);
    }

    public Socket createSocket() throws IOException {
        return this.f22236a.getSocketFactory().createSocket();
    }
}
