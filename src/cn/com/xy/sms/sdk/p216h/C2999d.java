package cn.com.xy.sms.sdk.p216h;

import cn.com.xy.sms.sdk.p215g.C2982a;
import java.io.IOException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public final class C2999d {
    private SSLSocketFactory f10155a = null;

    public static HttpsURLConnection m13519a(String str) {
        try {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
            try {
                new C2999d().m13521a(httpsURLConnection, 1);
                return httpsURLConnection;
            } catch (Throwable th) {
                return httpsURLConnection;
            }
        } catch (Throwable th2) {
            return null;
        }
    }

    public static HttpsURLConnection m13520a(String str, int i) {
        HttpsURLConnection httpsURLConnection;
        Throwable th;
        try {
            httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
            try {
                new C2999d().m13521a(httpsURLConnection, i);
                httpsURLConnection.connect();
            } catch (Throwable th2) {
                th = th2;
                C2982a.m13415a("XIAOYUAN", "createHttpsURLConnectionAndConnect: " + th.getMessage(), th);
                return httpsURLConnection;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            httpsURLConnection = null;
            th = th4;
            C2982a.m13415a("XIAOYUAN", "createHttpsURLConnectionAndConnect: " + th.getMessage(), th);
            return httpsURLConnection;
        }
        return httpsURLConnection;
    }

    private void m13521a(HttpsURLConnection httpsURLConnection, int i) {
        if (this.f10155a == null) {
            try {
                this.f10155a = C3001f.m13523a(i).m13525a();
            } catch (Throwable th) {
                if (th instanceof IOException) {
                    IOException iOException = (IOException) th;
                } else {
                    IOException iOException2 = new IOException(th);
                }
            }
        }
        if (this.f10155a != null) {
            httpsURLConnection.setSSLSocketFactory(this.f10155a);
        }
        try {
            httpsURLConnection.setHostnameVerifier(C3001f.m13523a(i).m13526b());
        } catch (Throwable th2) {
            iOException2 = new IOException(th2);
        }
    }
}
