package com.p252d.p253a.p254a;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.sina.weibo.sdk.component.GameManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.http.HttpEntity;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;
import org.apache.log4j.spi.LocationInfo;

/* compiled from: AsyncHttpClient */
public class C3543a {
    public static C3554l f13526a = new C3555k();
    private int f13527b;
    private int f13528c;
    private int f13529d;
    private final DefaultHttpClient f13530e;
    private final HttpContext f13531f;
    private ExecutorService f13532g;
    private final Map<Context, List<C3560q>> f13533h;
    private final Map<String, String> f13534i;
    private boolean f13535j;

    public C3543a() {
        this(false, 80, 443);
    }

    public C3543a(boolean z, int i, int i2) {
        this(C3543a.m17801a(z, i, i2));
    }

    private static SchemeRegistry m17801a(boolean z, int i, int i2) {
        SocketFactory b;
        if (z) {
            f13526a.mo4209b("AsyncHttpClient", "Beware! Using the fix is insecure, as it doesn't verify SSL certificates.");
        }
        if (i < 1) {
            i = 80;
            f13526a.mo4209b("AsyncHttpClient", "Invalid HTTP port number specified, defaulting to 80");
        }
        if (i2 < 1) {
            i2 = 443;
            f13526a.mo4209b("AsyncHttpClient", "Invalid HTTPS port number specified, defaulting to 443");
        }
        if (z) {
            b = C3557n.m17884b();
        } else {
            b = SSLSocketFactory.getSocketFactory();
        }
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), i));
        schemeRegistry.register(new Scheme("https", b, i2));
        return schemeRegistry;
    }

    public C3543a(SchemeRegistry schemeRegistry) {
        boolean z = true;
        this.f13527b = 10;
        this.f13528c = 10000;
        this.f13529d = 10000;
        this.f13535j = true;
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        ConnManagerParams.setTimeout(basicHttpParams, (long) this.f13528c);
        ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(this.f13527b));
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 10);
        HttpConnectionParams.setSoTimeout(basicHttpParams, this.f13529d);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, this.f13528c);
        HttpConnectionParams.setTcpNoDelay(basicHttpParams, true);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        ClientConnectionManager a = m17811a(schemeRegistry, basicHttpParams);
        if (a == null) {
            z = false;
        }
        C3564v.m17895a(z, "Custom implementation of #createConnectionManager(SchemeRegistry, BasicHttpParams) returned null");
        this.f13532g = m17817b();
        this.f13533h = Collections.synchronizedMap(new WeakHashMap());
        this.f13534i = new HashMap();
        this.f13531f = new SyncBasicHttpContext(new BasicHttpContext());
        this.f13530e = new DefaultHttpClient(a, basicHttpParams);
        this.f13530e.addRequestInterceptor(new C3544b(this));
        this.f13530e.addResponseInterceptor(new C3545c(this));
        this.f13530e.addRequestInterceptor(new C3546d(this), 0);
        this.f13530e.setHttpRequestRetryHandler(new C3562t(5, 1500));
    }

    public HttpClient m17810a() {
        return this.f13530e;
    }

    public void m17813a(ExecutorService executorService) {
        this.f13532g = executorService;
    }

    protected ExecutorService m17817b() {
        return Executors.newCachedThreadPool();
    }

    protected ClientConnectionManager m17811a(SchemeRegistry schemeRegistry, BasicHttpParams basicHttpParams) {
        return new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry);
    }

    public void m17815a(boolean z, boolean z2, boolean z3) {
        this.f13530e.getParams().setBooleanParameter(ClientPNames.REJECT_RELATIVE_REDIRECT, !z2);
        this.f13530e.getParams().setBooleanParameter(ClientPNames.ALLOW_CIRCULAR_REDIRECTS, z3);
        this.f13530e.setRedirectHandler(new C3556m(z));
    }

    public void m17814a(boolean z) {
        m17815a(z, z, z);
    }

    public void m17812a(int i, int i2) {
        this.f13530e.setHttpRequestRetryHandler(new C3562t(i, i2));
    }

    public C3560q m17808a(String str, C3561r c3561r, C3549s c3549s) {
        return m17806a(null, str, c3561r, c3549s);
    }

    public C3560q m17806a(Context context, String str, C3561r c3561r, C3549s c3549s) {
        return mo4214b(this.f13530e, this.f13531f, new C3553j(C3543a.m17798a(this.f13535j, str, c3561r)), null, c3549s, context);
    }

    public C3560q m17807a(Context context, String str, HttpEntity httpEntity, String str2, C3549s c3549s) {
        return mo4214b(this.f13530e, this.f13531f, m17800a(new HttpPost(m17809a(str)), httpEntity), str2, c3549s, context);
    }

    protected C3548f m17805a(DefaultHttpClient defaultHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, String str, C3549s c3549s, Context context) {
        return new C3548f(defaultHttpClient, httpContext, httpUriRequest, c3549s);
    }

    protected C3560q mo4214b(DefaultHttpClient defaultHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, String str, C3549s c3549s, Context context) {
        if (httpUriRequest == null) {
            throw new IllegalArgumentException("HttpUriRequest must not be null");
        } else if (c3549s == null) {
            throw new IllegalArgumentException("ResponseHandler must not be null");
        } else if (!c3549s.mo4192a() || c3549s.mo4196b()) {
            if (str != null) {
                if ((httpUriRequest instanceof HttpEntityEnclosingRequestBase) && ((HttpEntityEnclosingRequestBase) httpUriRequest).getEntity() != null && httpUriRequest.containsHeader("Content-Type")) {
                    f13526a.mo4211c("AsyncHttpClient", "Passed contentType will be ignored because HttpEntity sets content type");
                } else {
                    httpUriRequest.setHeader("Content-Type", str);
                }
            }
            c3549s.mo4191a(httpUriRequest.getAllHeaders());
            c3549s.mo4188a(httpUriRequest.getURI());
            Object a = m17805a(defaultHttpClient, httpContext, httpUriRequest, str, c3549s, context);
            this.f13532g.submit(a);
            C3560q c3560q = new C3560q(a);
            if (context != null) {
                List list;
                synchronized (this.f13533h) {
                    list = (List) this.f13533h.get(context);
                    if (list == null) {
                        list = Collections.synchronizedList(new LinkedList());
                        this.f13533h.put(context, list);
                    }
                }
                list.add(c3560q);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (((C3560q) it.next()).m17888c()) {
                        it.remove();
                    }
                }
            }
            return c3560q;
        } else {
            throw new IllegalArgumentException("Synchronous ResponseHandler used in AsyncHttpClient. You should create your response handler in a looper thread or use SyncHttpClient instead.");
        }
    }

    protected URI m17809a(String str) {
        return URI.create(str).normalize();
    }

    public static String m17798a(boolean z, String str, C3561r c3561r) {
        if (str == null) {
            return null;
        }
        String toASCIIString;
        String trim;
        if (z) {
            try {
                URL url = new URL(URLDecoder.decode(str, GameManager.DEFAULT_CHARSET));
                toASCIIString = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef()).toASCIIString();
            } catch (Throwable e) {
                f13526a.mo4210b("AsyncHttpClient", "getUrlWithQueryString encoding URL", e);
            }
            if (c3561r != null) {
                return toASCIIString;
            }
            trim = c3561r.m17891b().trim();
            if (trim.equals("") && !trim.equals(LocationInfo.NA)) {
                return (toASCIIString + (toASCIIString.contains(LocationInfo.NA) ? SNBConstant.FILTER : LocationInfo.NA)) + trim;
            }
        }
        toASCIIString = str;
        if (c3561r != null) {
            return toASCIIString;
        }
        trim = c3561r.m17891b().trim();
        return trim.equals("") ? toASCIIString : toASCIIString;
    }

    public static boolean m17804a(PushbackInputStream pushbackInputStream) throws IOException {
        boolean z = true;
        if (pushbackInputStream == null) {
            return false;
        }
        byte[] bArr = new byte[2];
        int read = pushbackInputStream.read(bArr);
        pushbackInputStream.unread(bArr);
        int i = ((bArr[1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (bArr[0] & 255);
        if (!(read == 2 && 35615 == i)) {
            z = false;
        }
        return z;
    }

    public static void m17802a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Throwable e) {
                f13526a.mo4208a("AsyncHttpClient", "Cannot close input stream", e);
            }
        }
    }

    private HttpEntityEnclosingRequestBase m17800a(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, HttpEntity httpEntity) {
        if (httpEntity != null) {
            httpEntityEnclosingRequestBase.setEntity(httpEntity);
        }
        return httpEntityEnclosingRequestBase;
    }

    public static void m17803a(HttpEntity httpEntity) {
        if (httpEntity instanceof HttpEntityWrapper) {
            try {
                for (Field field : HttpEntityWrapper.class.getDeclaredFields()) {
                    if (field.getName().equals("wrappedEntity")) {
                        break;
                    }
                }
                Field field2 = null;
                if (field2 != null) {
                    field2.setAccessible(true);
                    HttpEntity httpEntity2 = (HttpEntity) field2.get(httpEntity);
                    if (httpEntity2 != null) {
                        httpEntity2.consumeContent();
                    }
                }
            } catch (Throwable th) {
                f13526a.mo4210b("AsyncHttpClient", "wrappedEntity consume", th);
            }
        }
    }
}
