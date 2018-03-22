package cn.com.xy.sms.sdk.p216h;

import java.security.SecureRandom;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

public class C3001f {
    private static C3001f f10156d = null;
    private static C3001f f10157e = null;
    private SSLContext f10158a;
    private SSLSocketFactory f10159b;
    private HostnameVerifier f10160c;
    private int f10161f = 1;

    private C3001f(int i) {
        this.f10161f = i;
        this.f10160c = new C3002g(this);
    }

    public static C3001f m13523a(int i) {
        C3001f c3001f;
        synchronized (C3001f.class) {
            if (i == 0) {
                if (f10157e == null) {
                    f10157e = new C3001f(i);
                }
                c3001f = f10157e;
            } else {
                if (f10156d == null) {
                    f10156d = new C3001f(i);
                }
                c3001f = f10156d;
            }
        }
        return c3001f;
    }

    private synchronized SSLContext m13524c() {
        if (this.f10158a == null) {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init(null);
            SSLContext instance2 = SSLContext.getInstance(org.apache.http.conn.ssl.SSLSocketFactory.TLS);
            instance2.init(null, instance.getTrustManagers(), new SecureRandom());
            this.f10158a = instance2;
        }
        return this.f10158a;
    }

    public final synchronized SSLSocketFactory m13525a() {
        if (this.f10159b == null) {
            this.f10159b = m13524c().getSocketFactory();
        }
        return this.f10159b;
    }

    public final HostnameVerifier m13526b() {
        return this.f10160c;
    }
}
