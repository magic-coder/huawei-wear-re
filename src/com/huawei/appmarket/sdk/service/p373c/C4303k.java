package com.huawei.appmarket.sdk.service.p373c;

import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.Locale;
import java.util.Map;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.Header;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.AuthState;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.client.AuthenticationHandler;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.RedirectException;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.impl.client.DefaultRequestDirector;
import org.apache.http.impl.client.EntityEnclosingRequestWrapper;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.impl.client.RoutedRequest;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;

public class C4303k extends DefaultRequestDirector {
    private static Method f16013i;
    private static Object f16014j;
    private int f16015a = 0;
    private int f16016b = this.params.getIntParameter(ClientPNames.MAX_REDIRECTS, 100);
    private final AuthenticationHandler f16017c;
    private final UserTokenHandler f16018d;
    private final AuthenticationHandler f16019e;
    private final AuthState f16020f;
    private final AuthState f16021g;
    private ThreadLocal<C4294b> f16022h;

    public C4303k(HttpRequestExecutor httpRequestExecutor, ClientConnectionManager clientConnectionManager, ConnectionReuseStrategy connectionReuseStrategy, ConnectionKeepAliveStrategy connectionKeepAliveStrategy, HttpRoutePlanner httpRoutePlanner, HttpProcessor httpProcessor, HttpRequestRetryHandler httpRequestRetryHandler, RedirectHandler redirectHandler, AuthenticationHandler authenticationHandler, AuthenticationHandler authenticationHandler2, UserTokenHandler userTokenHandler, HttpParams httpParams, ThreadLocal<C4294b> threadLocal) {
        super(httpRequestExecutor, clientConnectionManager, connectionReuseStrategy, connectionKeepAliveStrategy, httpRoutePlanner, httpProcessor, httpRequestRetryHandler, redirectHandler, authenticationHandler, authenticationHandler2, userTokenHandler, httpParams);
        this.f16018d = userTokenHandler;
        this.f16017c = authenticationHandler;
        this.f16019e = authenticationHandler2;
        this.f16020f = new AuthState();
        this.f16021g = new AuthState();
        this.f16022h = threadLocal;
    }

    private RequestWrapper m20753a(HttpRequest httpRequest) throws ProtocolException {
        return httpRequest instanceof HttpEntityEnclosingRequest ? new EntityEnclosingRequestWrapper((HttpEntityEnclosingRequest) httpRequest) : new RequestWrapper(httpRequest);
    }

    private void m20754a() {
        ManagedClientConnection managedClientConnection = this.managedConn;
        if (managedClientConnection != null) {
            this.managedConn = null;
            try {
                managedClientConnection.abortConnection();
            } catch (IOException e) {
            }
            try {
                managedClientConnection.releaseConnection();
            } catch (IOException e2) {
            }
        }
    }

    private void m20755a(Map<String, Header> map, AuthState authState, AuthenticationHandler authenticationHandler, HttpResponse httpResponse, HttpContext httpContext) throws MalformedChallengeException, AuthenticationException {
        AuthScheme authScheme = authState.getAuthScheme();
        if (authScheme == null) {
            authScheme = authenticationHandler.selectScheme(map, httpResponse, httpContext);
            authState.setAuthScheme(authScheme);
        }
        AuthScheme authScheme2 = authScheme;
        String schemeName = authScheme2.getSchemeName();
        Header header = (Header) map.get(schemeName.toLowerCase(Locale.ENGLISH));
        if (header == null) {
            throw new AuthenticationException(schemeName + " authorization challenge expected, but not found");
        }
        authScheme2.processChallenge(header);
    }

    private void m20756a(AuthState authState, HttpHost httpHost, CredentialsProvider credentialsProvider) {
        if (authState.isValid()) {
            String hostName;
            int i = 0;
            if (httpHost != null) {
                hostName = httpHost.getHostName();
                i = httpHost.getPort();
            } else {
                hostName = null;
            }
            if (i < 0) {
                i = this.connManager.getSchemeRegistry().getScheme(httpHost).getDefaultPort();
            }
            AuthScheme authScheme = authState.getAuthScheme();
            AuthScope authScope = new AuthScope(hostName, i, authScheme.getRealm(), authScheme.getSchemeName());
            Credentials credentials = authState.getCredentials();
            if (credentials == null) {
                credentials = credentialsProvider.getCredentials(authScope);
            } else if (authScheme.isComplete()) {
                credentials = null;
            }
            authState.setAuthScope(authScope);
            authState.setCredentials(credentials);
        }
    }

    private static boolean m20757b() {
        try {
            Object obj;
            Method method;
            synchronized (DefaultRequestDirector.class) {
                if (f16013i == null) {
                    Class cls = Class.forName("android.security.NetworkSecurityPolicy");
                    f16014j = cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
                    f16013i = cls.getMethod("isCleartextTrafficPermitted", new Class[0]);
                }
                obj = f16014j;
                method = f16013i;
            }
            return ((Boolean) method.invoke(obj, new Object[0])).booleanValue();
        } catch (Exception e) {
            return true;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.apache.http.HttpResponse execute(org.apache.http.HttpHost r26, org.apache.http.HttpRequest r27, org.apache.http.protocol.HttpContext r28) throws org.apache.http.HttpException, java.io.IOException {
        /*
        r25 = this;
        r9 = 0;
        r0 = r25;
        r1 = r27;
        r4 = r0.m20753a(r1);
        r0 = r25;
        r5 = r0.params;
        r4.setParams(r5);
        r0 = r25;
        r1 = r26;
        r2 = r28;
        r5 = r0.determineRoute(r1, r4, r2);
        r8 = new org.apache.http.impl.client.RoutedRequest;
        r8.<init>(r4, r5);
        r0 = r25;
        r4 = r0.params;
        r20 = org.apache.http.conn.params.ConnManagerParams.getTimeout(r4);
        r7 = 0;
        r6 = 0;
        r5 = 0;
        r4 = 0;
        r14 = r4;
        r15 = r8;
        r16 = r9;
        r4 = r6;
        r6 = r7;
    L_0x0031:
        if (r14 != 0) goto L_0x046a;
    L_0x0033:
        r19 = r15.getRequest();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r22 = r15.getRoute();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r0 = r25;
        r4 = r0.f16022h;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r4 = r4.get();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r0 = r4;
        r0 = (com.huawei.appmarket.sdk.service.p373c.C4294b) r0;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r11 = r0;
        r4 = r22.getTargetHost();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r4 = r4.getHostName();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        if (r16 == 0) goto L_0x006f;
    L_0x0051:
        if (r11 == 0) goto L_0x006f;
    L_0x0053:
        r11.m20718b(r4);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r7 = r19.getOriginal();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r7 = r7.getRequestLine();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        if (r7 == 0) goto L_0x006f;
    L_0x0060:
        r7 = r19.getOriginal();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r7 = r7.getRequestLine();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r7 = r7.getUri();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r11.m20724h(r7);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
    L_0x006f:
        r23 = com.huawei.appmarket.sdk.service.p373c.C4296d.m20728a(r4);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        if (r23 == 0) goto L_0x0443;
    L_0x0075:
        r0 = r23;
        r4 = r0.length;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        if (r4 <= 0) goto L_0x0443;
    L_0x007a:
        r4 = 0;
        r18 = r4;
        r12 = r5;
        r13 = r6;
    L_0x007f:
        r0 = r23;
        r4 = r0.length;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r0 = r18;
        if (r0 >= r4) goto L_0x049e;
    L_0x0086:
        r0 = r23;
        r4 = r0.length;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r4 = r4 + -1;
        r0 = r18;
        if (r0 != r4) goto L_0x01e2;
    L_0x008f:
        r4 = 1;
        r17 = r4;
    L_0x0092:
        r4 = r23[r18];	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r4 = r4.getHostAddress();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        if (r11 == 0) goto L_0x009d;
    L_0x009a:
        r11.m20719c(r4);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
    L_0x009d:
        r5 = new org.apache.http.HttpHost;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r6 = r22.getTargetHost();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r6 = r6.getPort();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r7 = r22.getTargetHost();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r7 = r7.getSchemeName();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r5.<init>(r4, r6, r7);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r4 = new org.apache.http.conn.routing.HttpRoute;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r6 = r22.getLocalAddress();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r7 = r22.getProxyHost();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r8 = r22.isSecure();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r9 = r22.getTunnelType();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r10 = r22.getLayerType();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r4.<init>(r5, r6, r7, r8, r9, r10);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r5 = "http.user-token";
        r0 = r28;
        r5 = r0.getAttribute(r5);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r0 = r25;
        r6 = r0.managedConn;	 Catch:{ ConnectTimeoutException -> 0x01f1, HttpHostConnectException -> 0x020d, IOException -> 0x025d, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        if (r6 != 0) goto L_0x0124;
    L_0x00d9:
        r0 = r25;
        r6 = r0.connManager;	 Catch:{ ConnectTimeoutException -> 0x01f1, HttpHostConnectException -> 0x020d, IOException -> 0x025d, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        r6 = r6.requestConnection(r4, r5);	 Catch:{ ConnectTimeoutException -> 0x01f1, HttpHostConnectException -> 0x020d, IOException -> 0x025d, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        r0 = r27;
        r5 = r0 instanceof org.apache.http.client.methods.AbortableHttpRequest;	 Catch:{ ConnectTimeoutException -> 0x01f1, HttpHostConnectException -> 0x020d, IOException -> 0x025d, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        if (r5 == 0) goto L_0x00ef;
    L_0x00e7:
        r0 = r27;
        r0 = (org.apache.http.client.methods.AbortableHttpRequest) r0;	 Catch:{ ConnectTimeoutException -> 0x01f1, HttpHostConnectException -> 0x020d, IOException -> 0x025d, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        r5 = r0;
        r5.setConnectionRequest(r6);	 Catch:{ ConnectTimeoutException -> 0x01f1, HttpHostConnectException -> 0x020d, IOException -> 0x025d, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
    L_0x00ef:
        r5 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x01e7 }
        r0 = r20;
        r5 = r6.getConnection(r0, r5);	 Catch:{ InterruptedException -> 0x01e7 }
        r0 = r25;
        r0.managedConn = r5;	 Catch:{ InterruptedException -> 0x01e7 }
        r0 = r25;
        r5 = r0.params;	 Catch:{ ConnectTimeoutException -> 0x01f1, HttpHostConnectException -> 0x020d, IOException -> 0x025d, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        r5 = org.apache.http.params.HttpConnectionParams.isStaleCheckingEnabled(r5);	 Catch:{ ConnectTimeoutException -> 0x01f1, HttpHostConnectException -> 0x020d, IOException -> 0x025d, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        if (r5 == 0) goto L_0x0124;
    L_0x0105:
        r5 = "TraceRequestDirector";
        r6 = "Stale connection check";
        com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a.m20529a(r5, r6);	 Catch:{ ConnectTimeoutException -> 0x01f1, HttpHostConnectException -> 0x020d, IOException -> 0x025d, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        r0 = r25;
        r5 = r0.managedConn;	 Catch:{ ConnectTimeoutException -> 0x01f1, HttpHostConnectException -> 0x020d, IOException -> 0x025d, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        r5 = r5.isStale();	 Catch:{ ConnectTimeoutException -> 0x01f1, HttpHostConnectException -> 0x020d, IOException -> 0x025d, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        if (r5 == 0) goto L_0x0124;
    L_0x0116:
        r5 = "TraceRequestDirector";
        r6 = "Stale connection detected";
        com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a.m20529a(r5, r6);	 Catch:{ ConnectTimeoutException -> 0x01f1, HttpHostConnectException -> 0x020d, IOException -> 0x025d, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        r0 = r25;
        r5 = r0.managedConn;	 Catch:{ IOException -> 0x049b, ConnectTimeoutException -> 0x01f1, HttpHostConnectException -> 0x020d, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        r5.close();	 Catch:{ IOException -> 0x049b, ConnectTimeoutException -> 0x01f1, HttpHostConnectException -> 0x020d, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
    L_0x0124:
        r0 = r27;
        r5 = r0 instanceof org.apache.http.client.methods.AbortableHttpRequest;	 Catch:{ ConnectTimeoutException -> 0x01f1, HttpHostConnectException -> 0x020d, IOException -> 0x025d, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        if (r5 == 0) goto L_0x0136;
    L_0x012a:
        r0 = r27;
        r0 = (org.apache.http.client.methods.AbortableHttpRequest) r0;	 Catch:{ ConnectTimeoutException -> 0x01f1, HttpHostConnectException -> 0x020d, IOException -> 0x025d, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        r5 = r0;
        r0 = r25;
        r6 = r0.managedConn;	 Catch:{ ConnectTimeoutException -> 0x01f1, HttpHostConnectException -> 0x020d, IOException -> 0x025d, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        r5.setReleaseTrigger(r6);	 Catch:{ ConnectTimeoutException -> 0x01f1, HttpHostConnectException -> 0x020d, IOException -> 0x025d, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
    L_0x0136:
        r0 = r25;
        r5 = r0.managedConn;	 Catch:{ ConnectTimeoutException -> 0x01f1, HttpHostConnectException -> 0x020d, IOException -> 0x025d, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        r5 = r5.isOpen();	 Catch:{ ConnectTimeoutException -> 0x01f1, HttpHostConnectException -> 0x020d, IOException -> 0x025d, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        if (r5 != 0) goto L_0x01fc;
    L_0x0140:
        r0 = r25;
        r5 = r0.managedConn;	 Catch:{ ConnectTimeoutException -> 0x01f1, HttpHostConnectException -> 0x020d, IOException -> 0x025d, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        r0 = r25;
        r6 = r0.params;	 Catch:{ ConnectTimeoutException -> 0x01f1, HttpHostConnectException -> 0x020d, IOException -> 0x025d, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        r0 = r28;
        r5.open(r4, r0, r6);	 Catch:{ ConnectTimeoutException -> 0x01f1, HttpHostConnectException -> 0x020d, IOException -> 0x025d, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
    L_0x014d:
        r0 = r25;
        r1 = r28;
        r0.establishRoute(r4, r1);	 Catch:{ TunnelRefusedException -> 0x0282 }
        r19.resetHeaders();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r0 = r25;
        r1 = r19;
        r0.rewriteRequestURI(r1, r4);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r5 = r19.getParams();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r6 = "http.virtual-host";
        r5 = r5.getParameter(r6);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r5 = (org.apache.http.HttpHost) r5;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        if (r5 != 0) goto L_0x0170;
    L_0x016c:
        r5 = r4.getTargetHost();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
    L_0x0170:
        r6 = r4.getProxyHost();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r7 = "http.target_host";
        r0 = r28;
        r0.setAttribute(r7, r5);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r5 = "http.proxy_host";
        r0 = r28;
        r0.setAttribute(r5, r6);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r5 = "http.connection";
        r0 = r25;
        r6 = r0.managedConn;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r0 = r28;
        r0.setAttribute(r5, r6);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r5 = "http.auth.target-scope";
        r0 = r25;
        r6 = r0.f16020f;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r0 = r28;
        r0.setAttribute(r5, r6);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r5 = "http.auth.proxy-scope";
        r0 = r25;
        r6 = r0.f16021g;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r0 = r28;
        r0.setAttribute(r5, r6);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r0 = r25;
        r5 = r0.requestExec;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r0 = r25;
        r6 = r0.httpProcessor;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r0 = r19;
        r1 = r28;
        r5.preProcess(r0, r6, r1);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r5 = "http.request";
        r0 = r28;
        r1 = r19;
        r0.setAttribute(r5, r1);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r6 = 1;
        r5 = 0;
        r8 = r5;
        r9 = r6;
        r5 = r12;
        r6 = r13;
    L_0x01c1:
        if (r9 == 0) goto L_0x04a9;
    L_0x01c3:
        r7 = r6 + 1;
        r19.incrementExecCount();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r6 = r19.getExecCount();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r10 = 1;
        if (r6 <= r10) goto L_0x02f9;
    L_0x01cf:
        r6 = r19.isRepeatable();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        if (r6 != 0) goto L_0x02f9;
    L_0x01d5:
        r4 = new org.apache.http.client.NonRepeatableRequestException;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r5 = "Cannot retry request with a non-repeatable request entity";
        r4.<init>(r5);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        throw r4;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
    L_0x01dd:
        r4 = move-exception;
        r25.m20754a();
        throw r4;
    L_0x01e2:
        r4 = 0;
        r17 = r4;
        goto L_0x0092;
    L_0x01e7:
        r4 = move-exception;
        r5 = new java.io.InterruptedIOException;	 Catch:{ ConnectTimeoutException -> 0x01f1, HttpHostConnectException -> 0x020d, IOException -> 0x025d, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        r5.<init>();	 Catch:{ ConnectTimeoutException -> 0x01f1, HttpHostConnectException -> 0x020d, IOException -> 0x025d, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        r5.initCause(r4);	 Catch:{ ConnectTimeoutException -> 0x01f1, HttpHostConnectException -> 0x020d, IOException -> 0x025d, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        throw r5;	 Catch:{ ConnectTimeoutException -> 0x01f1, HttpHostConnectException -> 0x020d, IOException -> 0x025d, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
    L_0x01f1:
        r4 = move-exception;
        if (r16 == 0) goto L_0x023d;
    L_0x01f4:
        if (r17 == 0) goto L_0x0218;
    L_0x01f6:
        throw r4;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
    L_0x01f7:
        r4 = move-exception;
        r25.m20754a();
        throw r4;
    L_0x01fc:
        r0 = r25;
        r5 = r0.managedConn;	 Catch:{ ConnectTimeoutException -> 0x01f1, HttpHostConnectException -> 0x020d, IOException -> 0x025d, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        r0 = r25;
        r6 = r0.params;	 Catch:{ ConnectTimeoutException -> 0x01f1, HttpHostConnectException -> 0x020d, IOException -> 0x025d, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        r6 = org.apache.http.params.HttpConnectionParams.getSoTimeout(r6);	 Catch:{ ConnectTimeoutException -> 0x01f1, HttpHostConnectException -> 0x020d, IOException -> 0x025d, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        r5.setSocketTimeout(r6);	 Catch:{ ConnectTimeoutException -> 0x01f1, HttpHostConnectException -> 0x020d, IOException -> 0x025d, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        goto L_0x014d;
    L_0x020d:
        r4 = move-exception;
        if (r16 == 0) goto L_0x025c;
    L_0x0210:
        if (r17 == 0) goto L_0x023e;
    L_0x0212:
        throw r4;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
    L_0x0213:
        r4 = move-exception;
        r25.m20754a();
        throw r4;
    L_0x0218:
        if (r11 == 0) goto L_0x0233;
    L_0x021a:
        r5 = -1;
        r11.m20717b(r5);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r4 = r4.getMessage();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r11.m20723g(r4);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r4 = com.huawei.appmarket.sdk.service.p373c.C4296d.m20726a();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r11.m20716a(r4);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r4 = r11.toString();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        com.huawei.appmarket.sdk.service.p373c.C4296d.m20730c(r4);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
    L_0x0233:
        r4 = r12;
        r5 = r13;
    L_0x0235:
        r6 = r18 + 1;
        r18 = r6;
        r12 = r4;
        r13 = r5;
        goto L_0x007f;
    L_0x023d:
        throw r4;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
    L_0x023e:
        if (r11 == 0) goto L_0x0259;
    L_0x0240:
        r5 = -1;
        r11.m20717b(r5);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r4 = r4.getMessage();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r11.m20723g(r4);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r4 = com.huawei.appmarket.sdk.service.p373c.C4296d.m20726a();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r11.m20716a(r4);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r4 = r11.toString();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        com.huawei.appmarket.sdk.service.p373c.C4296d.m20730c(r4);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
    L_0x0259:
        r4 = r12;
        r5 = r13;
        goto L_0x0235;
    L_0x025c:
        throw r4;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
    L_0x025d:
        r4 = move-exception;
        if (r16 == 0) goto L_0x0281;
    L_0x0260:
        if (r17 == 0) goto L_0x0263;
    L_0x0262:
        throw r4;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
    L_0x0263:
        if (r11 == 0) goto L_0x027e;
    L_0x0265:
        r5 = -1;
        r11.m20717b(r5);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r4 = r4.getMessage();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r11.m20723g(r4);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r4 = com.huawei.appmarket.sdk.service.p373c.C4296d.m20726a();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r11.m20716a(r4);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r4 = r11.toString();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        com.huawei.appmarket.sdk.service.p373c.C4296d.m20730c(r4);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
    L_0x027e:
        r4 = r12;
        r5 = r13;
        goto L_0x0235;
    L_0x0281:
        throw r4;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
    L_0x0282:
        r4 = move-exception;
        r5 = "TraceRequestDirector";
        r6 = r4.getMessage();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a.m20529a(r5, r6);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r5 = r4.getResponse();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r7 = r13;
    L_0x0291:
        if (r5 == 0) goto L_0x029a;
    L_0x0293:
        r0 = r25;
        r4 = r0.params;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r5.setParams(r4);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
    L_0x029a:
        r0 = r25;
        r4 = r0.requestExec;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r0 = r25;
        r6 = r0.httpProcessor;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r0 = r28;
        r4.postProcess(r5, r6, r0);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r0 = r25;
        r4 = r0.reuseStrategy;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r0 = r28;
        r6 = r4.keepAlive(r5, r0);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        if (r6 == 0) goto L_0x02c6;
    L_0x02b3:
        r0 = r25;
        r4 = r0.keepAliveStrategy;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r0 = r28;
        r8 = r4.getKeepAliveDuration(r5, r0);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r0 = r25;
        r4 = r0.managedConn;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r10 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r4.setIdleDuration(r8, r10);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
    L_0x02c6:
        r0 = r25;
        r1 = r28;
        r8 = r0.handleResponse(r15, r5, r1);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        if (r8 != 0) goto L_0x040a;
    L_0x02d0:
        r4 = 1;
        r9 = 0;
        r8 = r15;
    L_0x02d3:
        r0 = r25;
        r10 = r0.f16018d;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r0 = r28;
        r10 = r10.getUserToken(r0);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r11 = "http.user-token";
        r0 = r28;
        r0.setAttribute(r11, r10);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r0 = r25;
        r11 = r0.managedConn;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        if (r11 == 0) goto L_0x02f1;
    L_0x02ea:
        r0 = r25;
        r11 = r0.managedConn;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r11.setState(r10);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
    L_0x02f1:
        r14 = r4;
        r15 = r8;
        r16 = r9;
        r4 = r6;
        r6 = r7;
        goto L_0x0031;
    L_0x02f9:
        r6 = "TraceRequestDirector";
        r10 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0340, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        r10.<init>();	 Catch:{ IOException -> 0x0340, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        r12 = "Attempt ";
        r10 = r10.append(r12);	 Catch:{ IOException -> 0x0340, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        r10 = r10.append(r7);	 Catch:{ IOException -> 0x0340, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        r12 = " to execute request";
        r10 = r10.append(r12);	 Catch:{ IOException -> 0x0340, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        r10 = r10.toString();	 Catch:{ IOException -> 0x0340, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a.m20529a(r6, r10);	 Catch:{ IOException -> 0x0340, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        r6 = r4.isSecure();	 Catch:{ IOException -> 0x0340, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        if (r6 != 0) goto L_0x03ae;
    L_0x031d:
        r6 = com.huawei.appmarket.sdk.service.p373c.C4303k.m20757b();	 Catch:{ IOException -> 0x0340, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        if (r6 != 0) goto L_0x03ae;
    L_0x0323:
        r6 = new java.io.IOException;	 Catch:{ IOException -> 0x0340, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        r10 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0340, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        r10.<init>();	 Catch:{ IOException -> 0x0340, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        r12 = "Cleartext traffic not permitted: ";
        r10 = r10.append(r12);	 Catch:{ IOException -> 0x0340, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        r12 = r4.getTargetHost();	 Catch:{ IOException -> 0x0340, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        r10 = r10.append(r12);	 Catch:{ IOException -> 0x0340, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        r10 = r10.toString();	 Catch:{ IOException -> 0x0340, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        r6.<init>(r10);	 Catch:{ IOException -> 0x0340, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        throw r6;	 Catch:{ IOException -> 0x0340, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
    L_0x0340:
        r6 = move-exception;
        r10 = "TraceRequestDirector";
        r12 = "Closing the connection.";
        com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a.m20529a(r10, r12);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r0 = r25;
        r10 = r0.managedConn;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r10.close();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r0 = r25;
        r10 = r0.retryHandler;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r0 = r28;
        r10 = r10.retryRequest(r6, r7, r0);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        if (r10 == 0) goto L_0x03c6;
    L_0x035b:
        r10 = "TraceRequestDirector";
        r12 = new java.lang.StringBuilder;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r12.<init>();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r13 = "I/O exception (";
        r12 = r12.append(r13);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r13 = r6.getClass();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r13 = r13.getName();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r12 = r12.append(r13);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r13 = ") caught when processing request: ";
        r12 = r12.append(r13);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r13 = r6.getMessage();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r12 = r12.append(r13);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r12 = r12.toString();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a.m20529a(r10, r12);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r10 = "TraceRequestDirector";
        r12 = "Retrying request";
        com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a.m20529a(r10, r12);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r10 = r4.getHopCount();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r12 = 1;
        if (r10 != r12) goto L_0x03ea;
    L_0x0397:
        r6 = "TraceRequestDirector";
        r10 = "Reopening the direct connection.";
        com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a.m20529a(r6, r10);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r0 = r25;
        r6 = r0.managedConn;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r0 = r25;
        r10 = r0.params;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r0 = r28;
        r6.open(r4, r0, r10);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r6 = r7;
        goto L_0x01c1;
    L_0x03ae:
        r0 = r25;
        r6 = r0.requestExec;	 Catch:{ IOException -> 0x0340, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        r0 = r25;
        r10 = r0.managedConn;	 Catch:{ IOException -> 0x0340, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        r0 = r19;
        r1 = r28;
        r12 = r6.execute(r0, r10, r1);	 Catch:{ IOException -> 0x0340, HttpException -> 0x01dd, RuntimeException -> 0x0213 }
        r6 = 0;
        r5 = 1;
        r8 = r5;
        r9 = r6;
        r5 = r12;
        r6 = r7;
        goto L_0x01c1;
    L_0x03c6:
        if (r17 == 0) goto L_0x03c9;
    L_0x03c8:
        throw r6;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
    L_0x03c9:
        if (r11 == 0) goto L_0x03e4;
    L_0x03cb:
        r4 = -1;
        r11.m20717b(r4);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r4 = r6.getMessage();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r11.m20723g(r4);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r4 = com.huawei.appmarket.sdk.service.p373c.C4296d.m20726a();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r11.m20716a(r4);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r4 = r11.toString();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        com.huawei.appmarket.sdk.service.p373c.C4296d.m20730c(r4);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
    L_0x03e4:
        r4 = r7;
    L_0x03e5:
        if (r8 == 0) goto L_0x04a2;
    L_0x03e7:
        r7 = r4;
        goto L_0x0291;
    L_0x03ea:
        if (r17 == 0) goto L_0x03ed;
    L_0x03ec:
        throw r6;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
    L_0x03ed:
        if (r11 == 0) goto L_0x0408;
    L_0x03ef:
        r4 = -1;
        r11.m20717b(r4);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r4 = r6.getMessage();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r11.m20723g(r4);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r4 = com.huawei.appmarket.sdk.service.p373c.C4296d.m20726a();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r11.m20716a(r4);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r4 = r11.toString();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        com.huawei.appmarket.sdk.service.p373c.C4296d.m20730c(r4);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
    L_0x0408:
        r4 = r7;
        goto L_0x03e5;
    L_0x040a:
        if (r6 == 0) goto L_0x043b;
    L_0x040c:
        r4 = "TraceRequestDirector";
        r9 = "Connection kept alive";
        com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a.m20529a(r4, r9);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r4 = 0;
        if (r5 == 0) goto L_0x041a;
    L_0x0416:
        r4 = r5.getEntity();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
    L_0x041a:
        if (r4 == 0) goto L_0x041f;
    L_0x041c:
        r4.consumeContent();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
    L_0x041f:
        r0 = r25;
        r4 = r0.managedConn;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r4.markReusable();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
    L_0x0426:
        r4 = r8.getRoute();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r9 = r15.getRoute();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r4 = r4.equals(r9);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        if (r4 != 0) goto L_0x0437;
    L_0x0434:
        r25.releaseConnection();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
    L_0x0437:
        r9 = 1;
        r4 = r14;
        goto L_0x02d3;
    L_0x043b:
        r0 = r25;
        r4 = r0.managedConn;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r4.close();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        goto L_0x0426;
    L_0x0443:
        if (r16 == 0) goto L_0x0459;
    L_0x0445:
        if (r11 == 0) goto L_0x0459;
    L_0x0447:
        r4 = -1;
        r11.m20717b(r4);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r4 = com.huawei.appmarket.sdk.service.p373c.C4296d.m20726a();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r11.m20716a(r4);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r4 = r11.toString();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        com.huawei.appmarket.sdk.service.p373c.C4296d.m20730c(r4);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
    L_0x0459:
        r4 = r22.getTargetHost();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r5 = r19.getOriginal();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r0 = r25;
        r1 = r28;
        r4 = super.execute(r4, r5, r1);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
    L_0x0469:
        return r4;
    L_0x046a:
        if (r5 == 0) goto L_0x047c;
    L_0x046c:
        r6 = r5.getEntity();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        if (r6 == 0) goto L_0x047c;
    L_0x0472:
        r6 = r5.getEntity();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r6 = r6.isStreaming();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        if (r6 != 0) goto L_0x048a;
    L_0x047c:
        if (r4 == 0) goto L_0x0485;
    L_0x047e:
        r0 = r25;
        r4 = r0.managedConn;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r4.markReusable();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
    L_0x0485:
        r25.releaseConnection();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
    L_0x0488:
        r4 = r5;
        goto L_0x0469;
    L_0x048a:
        r6 = r5.getEntity();	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r7 = new org.apache.http.conn.BasicManagedEntity;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r0 = r25;
        r8 = r0.managedConn;	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r7.<init>(r6, r8, r4);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        r5.setEntity(r7);	 Catch:{ HttpException -> 0x01dd, IOException -> 0x01f7, RuntimeException -> 0x0213 }
        goto L_0x0488;
    L_0x049b:
        r5 = move-exception;
        goto L_0x0124;
    L_0x049e:
        r5 = r12;
        r7 = r13;
        goto L_0x0291;
    L_0x04a2:
        r24 = r5;
        r5 = r4;
        r4 = r24;
        goto L_0x0235;
    L_0x04a9:
        r4 = r6;
        goto L_0x03e5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.appmarket.sdk.service.c.k.execute(org.apache.http.HttpHost, org.apache.http.HttpRequest, org.apache.http.protocol.HttpContext):org.apache.http.HttpResponse");
    }

    protected RoutedRequest handleResponse(RoutedRequest routedRequest, HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
        HttpRoute route = routedRequest.getRoute();
        HttpHost proxyHost = route.getProxyHost();
        RequestWrapper request = routedRequest.getRequest();
        HttpParams params = request.getParams();
        if (!HttpClientParams.isRedirecting(params) || !this.redirectHandler.isRedirectRequested(httpResponse, httpContext)) {
            CredentialsProvider credentialsProvider = (CredentialsProvider) httpContext.getAttribute(ClientContext.CREDS_PROVIDER);
            if (credentialsProvider != null && HttpClientParams.isAuthenticating(params)) {
                if (this.f16017c.isAuthenticationRequested(httpResponse, httpContext)) {
                    HttpHost httpHost = (HttpHost) httpContext.getAttribute("http.target_host");
                    proxyHost = httpHost == null ? route.getTargetHost() : httpHost;
                    try {
                        m20755a(this.f16017c.getChallenges(httpResponse, httpContext), this.f16020f, this.f16017c, httpResponse, httpContext);
                    } catch (AuthenticationException e) {
                    }
                    m20756a(this.f16020f, proxyHost, credentialsProvider);
                    return this.f16020f.getCredentials() == null ? null : routedRequest;
                } else {
                    this.f16020f.setAuthScope(null);
                    if (this.f16019e.isAuthenticationRequested(httpResponse, httpContext)) {
                        try {
                            m20755a(this.f16019e.getChallenges(httpResponse, httpContext), this.f16021g, this.f16019e, httpResponse, httpContext);
                        } catch (AuthenticationException e2) {
                        }
                        m20756a(this.f16021g, proxyHost, credentialsProvider);
                        return this.f16021g.getCredentials() == null ? null : routedRequest;
                    } else {
                        this.f16021g.setAuthScope(null);
                    }
                }
            }
            return null;
        } else if (this.f16015a >= this.f16016b) {
            throw new RedirectException("Maximum redirects (" + this.f16016b + ") exceeded");
        } else {
            this.f16015a++;
            URI locationURI = this.redirectHandler.getLocationURI(httpResponse, httpContext);
            HttpHost httpHost2 = new HttpHost(locationURI.getHost(), locationURI.getPort(), locationURI.getScheme());
            HttpRequest httpGet = new HttpGet(locationURI);
            httpGet.setHeaders(request.getOriginal().getAllHeaders());
            Object requestWrapper = new RequestWrapper(httpGet);
            requestWrapper.setParams(params);
            HttpRoute determineRoute = determineRoute(httpHost2, requestWrapper, httpContext);
            routedRequest = new RoutedRequest(requestWrapper, determineRoute);
            C4241a.m20529a("TraceRequestDirector", "Redirecting to '" + locationURI + "' via " + determineRoute);
            HttpRequest original = routedRequest.getRequest().getOriginal();
            String host = routedRequest.getRequest().getURI().getHost();
            if (original == null || C4296d.m20729b(host)) {
                return routedRequest;
            }
            original.setHeader("Host", host);
            return routedRequest;
        }
    }
}
