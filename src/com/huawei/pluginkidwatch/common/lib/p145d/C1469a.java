package com.huawei.pluginkidwatch.common.lib.p145d;

import android.content.Context;
import com.d.a.a.a;
import com.d.a.a.u;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.security.KeyStore;
import java.util.concurrent.RejectedExecutionException;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.entity.StringEntity;

/* compiled from: ExHttpClient */
public class C1469a {
    private static String f3420d = "";
    private SchemeRegistry f3421a = null;
    private a f3422b = null;
    private u f3423c = null;

    public C1469a(Context context) {
        m6791a(context);
    }

    private void m6791a(Context context) {
        m6794c(context);
        m6793b(context);
    }

    public void m6795a(String str, String str2, int i, C1455g c1455g) {
        C1474f c1474f = new C1474f();
        c1474f.f3433a = C1473e.f3431b;
        c1474f.f3434b = str;
        c1474f.f3435c = str2;
        c1474f.f3436d = i;
        m6792a(c1474f, c1455g);
    }

    public void m6796a(String str, String str2, C1455g c1455g) {
        C1474f c1474f = new C1474f();
        c1474f.f3433a = C1473e.f3431b;
        c1474f.f3434b = str;
        c1474f.f3435c = str2;
        try {
            this.f3423c.a(1, 60000);
            this.f3423c.a().getParams().setParameter("http.connection.timeout", Integer.valueOf(60000));
            this.f3423c.a().getParams().setParameter("http.socket.timeout", Integer.valueOf(60000));
            this.f3423c.a(false);
            C2538c.m12674b("ExHttpClient", "param.url:", c1474f.f3434b);
            C2538c.m12674b("ExHttpClient", "===HttpClient POST request: ", c1474f.f3435c);
            this.f3423c.a(null, c1474f.f3434b, new StringEntity(c1474f.f3435c, GameManager.DEFAULT_CHARSET), null, new C1470b(this, c1455g));
        } catch (RejectedExecutionException e) {
            C2538c.m12674b("ExHttpClient", "===HttpClient onFailure  result for url: ", c1474f.f3434b, " RejectedExecutionException = " + e.getMessage());
            C2538c.m12680e("ExHttpClient", "===HttpClient onFailure RejectedExecutionException = " + e.getMessage());
            c1455g.mo2515b(-1, "");
        } catch (UnsupportedEncodingException e2) {
            C2538c.m12674b("ExHttpClient", "===HttpClient onFailure  result for url: ", c1474f.f3434b, " UnsupportedEncodingException = " + e2.getMessage());
            C2538c.m12680e("ExHttpClient", "===HttpClient onFailure UnsupportedEncodingException = " + e2.getMessage());
            c1455g.mo2515b(-1, "");
        }
    }

    private void m6792a(C1474f c1474f, C1455g c1455g) {
        try {
            this.f3422b.a(1, 60000);
            m6790a();
            this.f3422b.a(false);
            C2538c.m12674b("ExHttpClient", "param.timeout = " + c1474f.f3436d);
            if (C1473e.f3430a == c1474f.f3433a) {
                this.f3422b.a(c1474f.f3434b, null, new C1471c(this, c1455g));
                return;
            }
            C2538c.m12674b("ExHttpClient", "param.url:", c1474f.f3434b);
            C2538c.m12674b("ExHttpClient", "===HttpClient POST request: ", c1474f.f3435c);
            this.f3422b.a(null, c1474f.f3434b, new StringEntity(c1474f.f3435c, GameManager.DEFAULT_CHARSET), null, new C1472d(this, c1455g));
        } catch (RejectedExecutionException e) {
            C2538c.m12680e("ExHttpClient", "===HttpClient onFailure RejectedExecutionException = " + e.getMessage());
            C2538c.m12674b("ExHttpClient", "===HttpClient onFailure  result for url: ", c1474f.f3434b, " RejectedExecutionException = " + e.getMessage());
            c1455g.mo2515b(-1, "");
        } catch (UnsupportedEncodingException e2) {
            C2538c.m12680e("ExHttpClient", "===HttpClient onFailure UnsupportedEncodingException = " + e2.getMessage());
            C2538c.m12674b("ExHttpClient", "===HttpClient onFailure  result for url: ", c1474f.f3434b, " UnsupportedEncodingException = " + e2.getMessage());
            c1455g.mo2515b(-1, "");
        }
    }

    private void m6793b(Context context) {
        if (this.f3423c == null) {
            try {
                KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
                C2538c.m12674b("ExHttpClient", "-----setSSLSocketFactory---start--");
                SocketFactory c1475h = new C1475h(instance, context);
                this.f3421a = new SchemeRegistry();
                this.f3421a.register(new Scheme("https", c1475h, 443));
                this.f3421a.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
                this.f3423c = new u(this.f3421a);
            } catch (Exception e) {
                C2538c.m12680e("ExHttpClient", "Exception e = " + e.getMessage());
                this.f3423c = new u();
            }
            this.f3423c.a(C1477j.m6804a());
        }
    }

    private void m6794c(Context context) {
        if (this.f3422b == null) {
            try {
                KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
                C2538c.m12674b("ExHttpClient", "-----setSSLSocketFactory---start--");
                SocketFactory c1475h = new C1475h(instance, context);
                this.f3421a = new SchemeRegistry();
                this.f3421a.register(new Scheme("https", c1475h, 443));
                this.f3421a.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
                this.f3422b = new a(this.f3421a);
                this.f3422b.a(1, 60000);
                this.f3422b.a().getParams().setParameter("http.connection.timeout", Integer.valueOf(60000));
                this.f3422b.a().getParams().setParameter("http.socket.timeout", Integer.valueOf(60000));
            } catch (Exception e) {
                C2538c.m12680e("ExHttpClient", "Exception e = " + e.getMessage());
                this.f3422b = new a();
                this.f3422b.a(1, 60000);
                this.f3422b.a().getParams().setParameter("http.connection.timeout", Integer.valueOf(60000));
                this.f3422b.a().getParams().setParameter("http.socket.timeout", Integer.valueOf(60000));
            }
            this.f3422b.a(C1477j.m6804a());
        }
    }

    private void m6790a() {
        if (this.f3422b != null) {
        }
    }
}
