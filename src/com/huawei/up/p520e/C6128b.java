package com.huawei.up.p520e;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.component.GameManager;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.SSLSocket;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRoute;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.log4j.helpers.DateLayout;

/* compiled from: HttpConnectionAdaptor */
public class C6128b {
    private static Context f21176a = null;
    private static HttpClient f21177b = null;
    private static SSLSocketFactory f21178c = null;
    private static HttpParams f21179d = null;
    private static SchemeRegistry f21180e = null;
    private static PlainSocketFactory f21181f = null;
    private static final Object f21182g = new Object();

    public static HttpPost m27910a(String str, int i, int i2, boolean z) {
        HttpRequestBase httpRequestBase = (HttpPost) new WeakReference(new HttpPost(str)).get();
        if (httpRequestBase == null) {
            return null;
        }
        C6128b.m27912a(httpRequestBase, i, i2, z);
        return httpRequestBase;
    }

    public static HttpClient m27909a(Context context, String str) throws C6133g {
        HttpClient httpClient;
        synchronized (f21182g) {
            f21176a = context.getApplicationContext();
            if (f21177b == null) {
                f21177b = C6128b.m27908a();
            }
            C6128b.m27914b(str);
            f21177b.getParams().setParameter("accept-encoding", "gzip");
            httpClient = f21177b;
        }
        return httpClient;
    }

    private static void m27914b(String str) throws C6133g {
        C6132f c = C6128b.m27915c(str);
        String a = C6128b.m27906a(c);
        SchemeRegistry schemeRegistry = f21177b.getConnectionManager().getSchemeRegistry();
        if (schemeRegistry.get(a) != null) {
            return;
        }
        if (c.f21186a) {
            schemeRegistry.register(new Scheme(a, f21178c, c.f21187b));
        } else {
            schemeRegistry.register(new Scheme(a, f21181f, c.f21187b));
        }
    }

    private static HttpClient m27908a() throws C6133g {
        try {
            C6128b.m27913b();
            return (HttpClient) new WeakReference(new DefaultHttpClient(new ThreadSafeClientConnManager(f21179d, f21180e), f21179d)).get();
        } catch (Exception e) {
            throw new C6133g(2, "Service unavailable.", e);
        }
    }

    private static void m27913b() {
        try {
            if (f21178c == null) {
                f21179d = new BasicHttpParams();
                HttpProtocolParams.setContentCharset(f21179d, GameManager.DEFAULT_CHARSET);
                HttpProtocolParams.setUseExpectContinue(f21179d, false);
                ConnPerRoute connPerRouteBean = new ConnPerRouteBean(20);
                connPerRouteBean.setMaxForRoute(new HttpRoute(new HttpHost("localhost", 80)), 100);
                ConnManagerParams.setMaxConnectionsPerRoute(f21179d, connPerRouteBean);
                ConnManagerParams.setMaxTotalConnections(f21179d, 800);
                f21178c = new C6130d(KeyStore.getInstance(KeyStore.getDefaultType()));
                f21180e = new SchemeRegistry();
                f21180e.register(new Scheme("https", f21178c, 443));
                f21181f = PlainSocketFactory.getSocketFactory();
                f21180e.register(new Scheme("http", f21181f, 80));
            }
        } catch (Exception e) {
            C2538c.e("HttpConnetionAdaptor", new Object[]{"SSLContext initSocketFactory failed:" + e.getMessage()});
        }
    }

    public static void m27911a(SSLSocket sSLSocket) {
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        List arrayList = new ArrayList();
        for (String str : enabledCipherSuites) {
            if (str.toUpperCase().contains("AES") && !str.toUpperCase().contains("ANON") && !str.toUpperCase().contains(DateLayout.NULL_DATE_FORMAT) && str.toUpperCase().contains("SHA")) {
                arrayList.add(str);
            }
        }
        sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public static HttpHost m27907a(String str) throws C6133g {
        C6132f c = C6128b.m27915c(str);
        return (HttpHost) new WeakReference(new HttpHost(c.f21188c, c.f21187b, C6128b.m27906a(c))).get();
    }

    private static String m27906a(C6132f c6132f) {
        String str = "https";
        if (c6132f.f21186a) {
            return "https" + c6132f.f21187b;
        }
        return "http" + c6132f.f21187b;
    }

    private static C6132f m27915c(String str) throws C6133g {
        Object host;
        int port;
        Exception e;
        boolean startsWith;
        int i = 443;
        if (TextUtils.isEmpty(str)) {
            throw new C6133g(2, "Url is empty.");
        }
        C6132f c6132f = new C6132f();
        String str2 = "";
        try {
            URL url = new URL(str);
            host = url.getHost();
            try {
                port = url.getPort();
            } catch (Exception e2) {
                e = e2;
                C2538c.e("HttpConnetionAdaptor", new Object[]{"EXCEPTION E = " + e.getMessage()});
                port = 443;
                if (TextUtils.isEmpty(host)) {
                    host = C6128b.m27916d(str);
                }
                startsWith = str.toLowerCase(Locale.getDefault()).startsWith("https");
                if (port <= 0) {
                    i = port;
                } else if (!startsWith) {
                    i = 80;
                }
                if (startsWith) {
                    c6132f.f21186a = true;
                } else {
                    c6132f.f21186a = false;
                }
                c6132f.f21187b = i;
                if (!TextUtils.isEmpty(host)) {
                    c6132f.f21188c = host;
                }
                return c6132f;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            host = str2;
            e = exception;
            C2538c.e("HttpConnetionAdaptor", new Object[]{"EXCEPTION E = " + e.getMessage()});
            port = 443;
            if (TextUtils.isEmpty(host)) {
                host = C6128b.m27916d(str);
            }
            startsWith = str.toLowerCase(Locale.getDefault()).startsWith("https");
            if (port <= 0) {
                i = port;
            } else if (startsWith) {
                i = 80;
            }
            if (startsWith) {
                c6132f.f21186a = false;
            } else {
                c6132f.f21186a = true;
            }
            c6132f.f21187b = i;
            if (TextUtils.isEmpty(host)) {
                c6132f.f21188c = host;
            }
            return c6132f;
        }
        if (TextUtils.isEmpty(host)) {
            host = C6128b.m27916d(str);
        }
        startsWith = str.toLowerCase(Locale.getDefault()).startsWith("https");
        if (port <= 0) {
            i = port;
        } else if (startsWith) {
            i = 80;
        }
        if (startsWith) {
            c6132f.f21186a = true;
        } else {
            c6132f.f21186a = false;
        }
        c6132f.f21187b = i;
        if (TextUtils.isEmpty(host)) {
            c6132f.f21188c = host;
        }
        return c6132f;
    }

    private static String m27916d(String str) {
        int indexOf = str.indexOf("//");
        if (indexOf == -1) {
            indexOf = 0;
        } else {
            indexOf += 2;
        }
        int indexOf2 = str.indexOf(58, indexOf);
        if (indexOf2 == -1) {
            indexOf2 = str.indexOf(47, indexOf);
            if (indexOf2 < 0) {
                indexOf2 = str.length();
            }
        }
        return str.substring(indexOf, indexOf2);
    }

    private static void m27912a(HttpRequestBase httpRequestBase, int i, int i2, boolean z) {
        httpRequestBase.getParams().setParameter("http.connection.timeout", Integer.valueOf(i * 1000));
        httpRequestBase.getParams().setParameter("http.socket.timeout", Integer.valueOf(i2 * 1000));
        httpRequestBase.getParams().setParameter(ClientPNames.HANDLE_REDIRECTS, Boolean.valueOf(z));
    }
}
