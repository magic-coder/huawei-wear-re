package com.huawei.hwid.core.p430b.p433b;

import android.content.Context;
import android.os.Build.VERSION;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerPNames;
import org.apache.http.conn.params.ConnPerRoute;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

/* compiled from: HttpClientConnetManager */
public class C5145b {
    private static ClientConnectionManager f18575a;
    private static final ConnPerRoute f18576b = new C51441();

    /* compiled from: HttpClientConnetManager */
    final class C51441 implements ConnPerRoute {
        C51441() {
        }

        public int getMaxForRoute(HttpRoute httpRoute) {
            return 8;
        }
    }

    public static void m24821a(Socket socket) {
        if (socket != null && (socket instanceof SSLSocket)) {
            ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1.2"});
        }
    }

    public static ClientConnectionManager m24820a(Context context) {
        if (f18575a == null) {
            boolean z;
            SocketFactory c5146c;
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            if (VERSION.SDK_INT >= 16) {
                z = true;
            } else {
                z = false;
            }
            try {
                c5146c = new C5146c(null, context, z);
            } catch (Throwable e) {
                C5165e.m24911d("HttpClientConnetManager", "getConnectionManager Exception KeyManagementException", e);
                c5146c = null;
            } catch (Throwable e2) {
                C5165e.m24911d("HttpClientConnetManager", "getConnectionManager Exception NoSuchAlgorithmException", e2);
                c5146c = null;
            } catch (Throwable e22) {
                C5165e.m24911d("HttpClientConnetManager", "getConnectionManager Exception KeyStoreException", e22);
                c5146c = null;
            } catch (Throwable e222) {
                C5165e.m24911d("HttpClientConnetManager", "getConnectionManager Exception UnrecoverableKeyException", e222);
                c5146c = null;
            }
            if (c5146c != null) {
                C5165e.m24904a("HttpClientConnetManager", "mysslSocketFactory is not null");
                c5146c.setHostnameVerifier(SSLSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
                schemeRegistry.register(new Scheme("https", c5146c, 443));
            }
            schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 8080));
            HttpParams basicHttpParams = new BasicHttpParams();
            basicHttpParams.setIntParameter(ConnManagerPNames.MAX_TOTAL_CONNECTIONS, 25);
            basicHttpParams.setParameter(ConnManagerPNames.MAX_CONNECTIONS_PER_ROUTE, f18576b);
            C5145b.m24823a(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry));
        }
        return f18575a;
    }

    private static synchronized void m24823a(ClientConnectionManager clientConnectionManager) {
        synchronized (C5145b.class) {
            f18575a = clientConnectionManager;
        }
    }

    public static void m24822a(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            C5165e.m24910d("HttpClientConnetManager", "socket error");
            return;
        }
        C5165e.m24906b("HttpClientConnetManager", "enter setEnableSafeCipherSuites");
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        C5165e.m24906b("HttpClientConnetManager", " current EnabledCipherSuites size" + enabledCipherSuites.length);
        List arrayList = new ArrayList();
        for (String str : enabledCipherSuites) {
            if (!(str.contains("RC4") || str.contains("DES") || str.contains("3DES") || str.contains("aNULL") || str.contains("eNULL") || str.contains("MD5") || str.contains("TLS_DH_anon_WITH_AES_256_CBC_SHA"))) {
                arrayList.add(str);
            }
        }
        C5165e.m24906b("HttpClientConnetManager", "get safe EnabledCipherSuites list size =" + arrayList.size());
        String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        C5165e.m24906b("HttpClientConnetManager", "get safe EnabledCipherSuites Array length =" + strArr.length);
        sSLSocket.setEnabledCipherSuites(strArr);
    }
}
