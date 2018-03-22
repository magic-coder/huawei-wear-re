package com.huawei.appmarket.sdk.service.p373c;

import android.content.Context;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.util.InetAddressUtils;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

public class C4302j {
    private C4297e f16010a;
    private Context f16011b;
    private ThreadLocal<C4294b> f16012c = new ThreadLocal();

    public C4302j(String str, Context context) {
        this.f16010a = C4297e.m20733a(str, this.f16012c);
        this.f16011b = context;
    }

    private URI m20743a(URI uri, String str) {
        if (!InetAddressUtils.isIPv6Address(str)) {
            try {
                uri = URIUtils.createURI(uri.getScheme(), str, uri.getPort(), uri.getPath(), uri.getQuery(), uri.getFragment());
            } catch (URISyntaxException e) {
            }
        }
        return uri;
    }

    public static void m20744a(String str, int i, String str2, URI uri) {
        if (uri != null) {
            C4294b c4294b = new C4294b();
            c4294b.m20716a(C4296d.m20726a());
            c4294b.m20718b(uri.getHost());
            c4294b.m20717b(i);
            c4294b.m20723g(str2);
            c4294b.m20714a(3);
            c4294b.m20724h(uri.getPath());
            InetAddress[] a = C4296d.m20728a(uri.getHost());
            if (a != null) {
                for (InetAddress hostAddress : a) {
                    c4294b.m20719c(hostAddress.getHostAddress());
                    c4294b.m20716a(C4296d.m20726a());
                    C4296d.m20730c(c4294b.toString());
                }
                return;
            }
            c4294b.m20716a(C4296d.m20726a());
            C4296d.m20730c(c4294b.toString());
        }
    }

    private void m20745a(HttpResponse httpResponse) {
        C4294b c4294b = (C4294b) this.f16012c.get();
        if (c4294b != null) {
            c4294b.m20717b(httpResponse.getStatusLine().getStatusCode());
            c4294b.m20723g(httpResponse.getStatusLine().toString());
            if (httpResponse.getStatusLine().getStatusCode() == 200 || httpResponse.getStatusLine().getStatusCode() == 206) {
                c4294b.m20724h("");
                return;
            }
            c4294b.m20716a(C4296d.m20726a());
            C4296d.m20730c(c4294b.toString());
        }
    }

    private C4294b m20746b(HttpUriRequest httpUriRequest) {
        C4294b c4294b = new C4294b();
        this.f16012c.set(c4294b);
        URI uri = httpUriRequest.getURI();
        c4294b.m20718b(uri.getHost());
        c4294b.m20722f(C4296d.m20727a(this.f16011b));
        c4294b.m20724h(uri.getPath());
        return c4294b;
    }

    public final HttpResponse m20747a(HttpUriRequest httpUriRequest) throws ClientProtocolException, IOException {
        return m20748a(httpUriRequest, (HttpContext) null);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.apache.http.HttpResponse m20748a(org.apache.http.client.methods.HttpUriRequest r12, org.apache.http.protocol.HttpContext r13) throws java.io.IOException, org.apache.http.client.ClientProtocolException {
        /*
        r11 = this;
        if (r12 != 0) goto L_0x0009;
    L_0x0002:
        r0 = r11.f16010a;
        r2 = r0.execute(r12, r13);
    L_0x0008:
        return r2;
    L_0x0009:
        r0 = "GET";
        r1 = r12.getMethod();
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x001c;
    L_0x0015:
        r0 = r11.f16010a;
        r2 = r0.execute(r12, r13);
        goto L_0x0008;
    L_0x001c:
        r0 = com.huawei.appmarket.sdk.service.p373c.C4304l.m20758a();
        if (r0 == 0) goto L_0x0029;
    L_0x0022:
        r0 = r11.f16010a;
        r2 = r0.execute(r12, r13);
        goto L_0x0008;
    L_0x0029:
        r4 = r11.m20746b(r12);
        r5 = r12.getURI();
        r6 = r5.getHost();
        r7 = com.huawei.appmarket.sdk.service.p373c.C4296d.m20728a(r6);
        r1 = 0;
        if (r7 == 0) goto L_0x0135;
    L_0x003c:
        r0 = r7.length;
        if (r0 <= 0) goto L_0x0135;
    L_0x003f:
        r0 = 0;
        r2 = r1;
        r1 = r0;
    L_0x0042:
        r0 = r7.length;
        if (r1 >= r0) goto L_0x0008;
    L_0x0045:
        r0 = r7.length;
        r0 = r0 + -1;
        if (r1 != r0) goto L_0x00a2;
    L_0x004a:
        r0 = 1;
        r3 = r0;
    L_0x004c:
        r0 = r7[r1];
        r0 = r0.getHostAddress();
        r4.m20718b(r6);
        r4.m20719c(r0);
        r8 = r11.m20743a(r5, r0);
        r0 = r12 instanceof org.apache.http.client.methods.HttpRequestBase;
        if (r0 == 0) goto L_0x00a5;
    L_0x0060:
        r0 = r12;
        r0 = (org.apache.http.client.methods.HttpRequestBase) r0;
        r0.setURI(r8);
    L_0x0066:
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ HttpHostConnectException -> 0x0082, ConnectTimeoutException -> 0x00b0, ClientProtocolException -> 0x00d0, SocketException -> 0x00f0, IOException -> 0x0110 }
        r4.m20715a(r8);	 Catch:{ HttpHostConnectException -> 0x0082, ConnectTimeoutException -> 0x00b0, ClientProtocolException -> 0x00d0, SocketException -> 0x00f0, IOException -> 0x0110 }
        r0 = com.huawei.appmarket.sdk.service.p373c.C4296d.m20731d(r6);	 Catch:{ HttpHostConnectException -> 0x0082, ConnectTimeoutException -> 0x00b0, ClientProtocolException -> 0x00d0, SocketException -> 0x00f0, IOException -> 0x0110 }
        if (r0 != 0) goto L_0x0078;
    L_0x0073:
        r0 = "Host";
        r12.setHeader(r0, r6);	 Catch:{ HttpHostConnectException -> 0x0082, ConnectTimeoutException -> 0x00b0, ClientProtocolException -> 0x00d0, SocketException -> 0x00f0, IOException -> 0x0110 }
    L_0x0078:
        r0 = r11.f16010a;	 Catch:{ HttpHostConnectException -> 0x0082, ConnectTimeoutException -> 0x00b0, ClientProtocolException -> 0x00d0, SocketException -> 0x00f0, IOException -> 0x0110 }
        r2 = r0.execute(r12, r13);	 Catch:{ HttpHostConnectException -> 0x0082, ConnectTimeoutException -> 0x00b0, ClientProtocolException -> 0x00d0, SocketException -> 0x00f0, IOException -> 0x0110 }
        r11.m20745a(r2);	 Catch:{ HttpHostConnectException -> 0x0082, ConnectTimeoutException -> 0x00b0, ClientProtocolException -> 0x00d0, SocketException -> 0x00f0, IOException -> 0x0110 }
        goto L_0x0008;
    L_0x0082:
        r0 = move-exception;
        r10 = r0;
        r0 = r2;
        r2 = r10;
        r8 = -1;
        r4.m20717b(r8);
        r8 = r2.getMessage();
        r4.m20723g(r8);
        r8 = com.huawei.appmarket.sdk.service.p373c.C4296d.m20726a();
        r4.m20716a(r8);
        r8 = r4.toString();
        com.huawei.appmarket.sdk.service.p373c.C4296d.m20730c(r8);
        if (r3 == 0) goto L_0x0130;
    L_0x00a1:
        throw r2;
    L_0x00a2:
        r0 = 0;
        r3 = r0;
        goto L_0x004c;
    L_0x00a5:
        r0 = r12 instanceof org.apache.http.impl.client.RequestWrapper;
        if (r0 == 0) goto L_0x0066;
    L_0x00a9:
        r0 = r12;
        r0 = (org.apache.http.impl.client.RequestWrapper) r0;
        r0.setURI(r8);
        goto L_0x0066;
    L_0x00b0:
        r0 = move-exception;
        r10 = r0;
        r0 = r2;
        r2 = r10;
        r8 = -1;
        r4.m20717b(r8);
        r8 = r2.getMessage();
        r4.m20723g(r8);
        r8 = com.huawei.appmarket.sdk.service.p373c.C4296d.m20726a();
        r4.m20716a(r8);
        r8 = r4.toString();
        com.huawei.appmarket.sdk.service.p373c.C4296d.m20730c(r8);
        if (r3 == 0) goto L_0x0130;
    L_0x00cf:
        throw r2;
    L_0x00d0:
        r0 = move-exception;
        r10 = r0;
        r0 = r2;
        r2 = r10;
        r8 = -1;
        r4.m20717b(r8);
        r8 = r2.getMessage();
        r4.m20723g(r8);
        r8 = com.huawei.appmarket.sdk.service.p373c.C4296d.m20726a();
        r4.m20716a(r8);
        r8 = r4.toString();
        com.huawei.appmarket.sdk.service.p373c.C4296d.m20730c(r8);
        if (r3 == 0) goto L_0x0130;
    L_0x00ef:
        throw r2;
    L_0x00f0:
        r0 = move-exception;
        r10 = r0;
        r0 = r2;
        r2 = r10;
        r8 = -1;
        r4.m20717b(r8);
        r8 = r2.getMessage();
        r4.m20723g(r8);
        r8 = com.huawei.appmarket.sdk.service.p373c.C4296d.m20726a();
        r4.m20716a(r8);
        r8 = r4.toString();
        com.huawei.appmarket.sdk.service.p373c.C4296d.m20730c(r8);
        if (r3 == 0) goto L_0x0130;
    L_0x010f:
        throw r2;
    L_0x0110:
        r0 = move-exception;
        r10 = r0;
        r0 = r2;
        r2 = r10;
        r8 = -1;
        r4.m20717b(r8);
        r8 = r2.getMessage();
        r4.m20723g(r8);
        r8 = com.huawei.appmarket.sdk.service.p373c.C4296d.m20726a();
        r4.m20716a(r8);
        r8 = r4.toString();
        com.huawei.appmarket.sdk.service.p373c.C4296d.m20730c(r8);
        if (r3 == 0) goto L_0x0130;
    L_0x012f:
        throw r2;
    L_0x0130:
        r1 = r1 + 1;
        r2 = r0;
        goto L_0x0042;
    L_0x0135:
        r0 = -1;
        r4.m20717b(r0);
        r0 = com.huawei.appmarket.sdk.service.p373c.C4296d.m20726a();
        r4.m20716a(r0);
        r0 = r4.toString();
        com.huawei.appmarket.sdk.service.p373c.C4296d.m20730c(r0);
        r0 = r11.f16010a;
        r2 = r0.execute(r12, r13);
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.appmarket.sdk.service.c.j.a(org.apache.http.client.methods.HttpUriRequest, org.apache.http.protocol.HttpContext):org.apache.http.HttpResponse");
    }

    public HttpParams m20749a() {
        return this.f16010a.getParams();
    }

    public void m20750a(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        C4294b c4294b = (C4294b) this.f16012c.get();
        if (c4294b != null) {
            long a = c4294b.m20713a();
            c4294b.m20717b(200);
            c4294b.m20723g("");
            c4294b.m20720d(String.valueOf(currentTimeMillis - a));
            if (j > 0) {
                c4294b.m20721e(String.valueOf(j));
            }
            c4294b.m20716a(C4296d.m20726a());
            C4296d.m20730c(c4294b.toString());
            this.f16012c.remove();
        }
    }

    public ClientConnectionManager m20751b() {
        return this.f16010a.getConnectionManager();
    }

    public void m20752c() {
        if (this.f16010a != null) {
            this.f16010a.m20738a();
        }
    }
}
