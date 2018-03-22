package com.tencent.stat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.stat.p544a.C6443b;
import com.tencent.stat.p545b.C6452b;
import com.tencent.stat.p545b.C6463m;
import java.util.Arrays;
import java.util.List;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

class C6477k {
    private static C6452b f22516c = C6463m.m29449b();
    private static long f22517d = -1;
    private static C6477k f22518e = null;
    private static Context f22519f = null;
    DefaultHttpClient f22520a = null;
    Handler f22521b = null;

    private C6477k() {
        try {
            HandlerThread handlerThread = new HandlerThread("StatDispatcher");
            handlerThread.start();
            f22517d = handlerThread.getId();
            this.f22521b = new Handler(handlerThread.getLooper());
            HttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
            HttpConnectionParams.setSoTimeout(basicHttpParams, 10000);
            this.f22520a = new DefaultHttpClient(basicHttpParams);
            this.f22520a.setKeepAliveStrategy(new C6478l(this));
            if (C6470c.m29525h() != null) {
                this.f22520a.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, C6470c.m29525h());
            }
        } catch (Throwable th) {
            f22516c.m29411f(th);
        }
    }

    static Context m29578a() {
        return f22519f;
    }

    static void m29579a(Context context) {
        f22519f = context.getApplicationContext();
    }

    static synchronized C6477k m29580b() {
        C6477k c6477k;
        synchronized (C6477k.class) {
            if (f22518e == null) {
                f22518e = new C6477k();
            }
            c6477k = f22518e;
        }
        return c6477k;
    }

    void m29582a(C6443b c6443b, C6450j c6450j) {
        m29584b(Arrays.asList(new String[]{c6443b.m29367d()}), c6450j);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m29583a(java.util.List<java.lang.String> r13, com.tencent.stat.C6450j r14) {
        /*
        r12 = this;
        r10 = 0;
        r9 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r1 = 0;
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0145 }
        r3.<init>();	 Catch:{ Throwable -> 0x0145 }
        r0 = "[";
        r3.append(r0);	 Catch:{ Throwable -> 0x0145 }
        r2 = r1;
    L_0x0010:
        r0 = r13.size();	 Catch:{ Throwable -> 0x0145 }
        if (r2 >= r0) goto L_0x0030;
    L_0x0016:
        r0 = r13.get(r2);	 Catch:{ Throwable -> 0x0145 }
        r0 = (java.lang.String) r0;	 Catch:{ Throwable -> 0x0145 }
        r3.append(r0);	 Catch:{ Throwable -> 0x0145 }
        r0 = r13.size();	 Catch:{ Throwable -> 0x0145 }
        r0 = r0 + -1;
        if (r2 == r0) goto L_0x002c;
    L_0x0027:
        r0 = ",";
        r3.append(r0);	 Catch:{ Throwable -> 0x0145 }
    L_0x002c:
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x0010;
    L_0x0030:
        r0 = "]";
        r3.append(r0);	 Catch:{ Throwable -> 0x0145 }
        r0 = com.tencent.stat.C6470c.m29530m();	 Catch:{ Throwable -> 0x0145 }
        r2 = f22516c;	 Catch:{ Throwable -> 0x0145 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0145 }
        r4.<init>();	 Catch:{ Throwable -> 0x0145 }
        r5 = "[";
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x0145 }
        r4 = r4.append(r0);	 Catch:{ Throwable -> 0x0145 }
        r5 = "]Send request(";
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x0145 }
        r5 = r3.toString();	 Catch:{ Throwable -> 0x0145 }
        r5 = r5.length();	 Catch:{ Throwable -> 0x0145 }
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x0145 }
        r5 = "bytes):";
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x0145 }
        r5 = r3.toString();	 Catch:{ Throwable -> 0x0145 }
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x0145 }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x0145 }
        r2.m29407b(r4);	 Catch:{ Throwable -> 0x0145 }
        r2 = new org.apache.http.client.methods.HttpPost;	 Catch:{ Throwable -> 0x0145 }
        r2.<init>(r0);	 Catch:{ Throwable -> 0x0145 }
        r0 = "Accept-Encoding";
        r4 = "gzip";
        r2.addHeader(r0, r4);	 Catch:{ Throwable -> 0x0145 }
        r0 = "Connection";
        r4 = "Keep-Alive";
        r2.setHeader(r0, r4);	 Catch:{ Throwable -> 0x0145 }
        r0 = "Cache-Control";
        r2.removeHeaders(r0);	 Catch:{ Throwable -> 0x0145 }
        r0 = f22519f;	 Catch:{ Throwable -> 0x0145 }
        r4 = com.tencent.stat.p545b.C6463m.m29444a(r0);	 Catch:{ Throwable -> 0x0145 }
        if (r4 == 0) goto L_0x00b9;
    L_0x0091:
        r0 = r12.f22520a;	 Catch:{ Throwable -> 0x0145 }
        r0 = r0.getParams();	 Catch:{ Throwable -> 0x0145 }
        r1 = "http.route.default-proxy";
        r5 = f22519f;	 Catch:{ Throwable -> 0x0145 }
        r5 = com.tencent.stat.p545b.C6463m.m29444a(r5);	 Catch:{ Throwable -> 0x0145 }
        r0.setParameter(r1, r5);	 Catch:{ Throwable -> 0x0145 }
        r0 = "X-Online-Host";
        r1 = "pingma.qq.com:80";
        r2.addHeader(r0, r1);	 Catch:{ Throwable -> 0x0145 }
        r0 = "Accept";
        r1 = "*/*";
        r2.addHeader(r0, r1);	 Catch:{ Throwable -> 0x0145 }
        r0 = "Content-Type";
        r1 = "json";
        r2.addHeader(r0, r1);	 Catch:{ Throwable -> 0x0145 }
        r0 = 1;
        r1 = r0;
    L_0x00b9:
        r5 = new java.io.ByteArrayOutputStream;	 Catch:{ Throwable -> 0x0145 }
        r5.<init>();	 Catch:{ Throwable -> 0x0145 }
        r0 = r3.toString();	 Catch:{ Throwable -> 0x0145 }
        r6 = "UTF-8";
        r0 = r0.getBytes(r6);	 Catch:{ Throwable -> 0x0145 }
        r6 = r0.length;	 Catch:{ Throwable -> 0x0145 }
        r3 = r3.length();	 Catch:{ Throwable -> 0x0145 }
        r7 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        if (r3 >= r7) goto L_0x015a;
    L_0x00d1:
        if (r4 != 0) goto L_0x013d;
    L_0x00d3:
        r3 = "Content-Encoding";
        r4 = "rc4";
        r2.addHeader(r3, r4);	 Catch:{ Throwable -> 0x0145 }
    L_0x00da:
        r0 = com.tencent.stat.p545b.C6457g.m29419a(r0);	 Catch:{ Throwable -> 0x0145 }
        r3 = new org.apache.http.entity.ByteArrayEntity;	 Catch:{ Throwable -> 0x0145 }
        r3.<init>(r0);	 Catch:{ Throwable -> 0x0145 }
        r2.setEntity(r3);	 Catch:{ Throwable -> 0x0145 }
        r0 = r12.f22520a;	 Catch:{ Throwable -> 0x0145 }
        r2 = r0.execute(r2);	 Catch:{ Throwable -> 0x0145 }
        if (r1 == 0) goto L_0x00f9;
    L_0x00ee:
        r0 = r12.f22520a;	 Catch:{ Throwable -> 0x0145 }
        r0 = r0.getParams();	 Catch:{ Throwable -> 0x0145 }
        r1 = "http.route.default-proxy";
        r0.removeParameter(r1);	 Catch:{ Throwable -> 0x0145 }
    L_0x00f9:
        r0 = r2.getEntity();	 Catch:{ Throwable -> 0x0145 }
        r1 = r2.getStatusLine();	 Catch:{ Throwable -> 0x0145 }
        r1 = r1.getStatusCode();	 Catch:{ Throwable -> 0x0145 }
        r6 = r0.getContentLength();	 Catch:{ Throwable -> 0x0145 }
        r3 = f22516c;	 Catch:{ Throwable -> 0x0145 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0145 }
        r4.<init>();	 Catch:{ Throwable -> 0x0145 }
        r8 = "recv response status code:";
        r4 = r4.append(r8);	 Catch:{ Throwable -> 0x0145 }
        r4 = r4.append(r1);	 Catch:{ Throwable -> 0x0145 }
        r8 = ", content length:";
        r4 = r4.append(r8);	 Catch:{ Throwable -> 0x0145 }
        r4 = r4.append(r6);	 Catch:{ Throwable -> 0x0145 }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x0145 }
        r3.m29407b(r4);	 Catch:{ Throwable -> 0x0145 }
        r3 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1));
        if (r3 != 0) goto L_0x01ce;
    L_0x012f:
        org.apache.http.util.EntityUtils.toString(r0);	 Catch:{ Throwable -> 0x0145 }
        if (r1 != r9) goto L_0x01b4;
    L_0x0134:
        if (r14 == 0) goto L_0x0139;
    L_0x0136:
        r14.mo5344a();	 Catch:{ Throwable -> 0x0145 }
    L_0x0139:
        r5.close();	 Catch:{ Throwable -> 0x0145 }
    L_0x013c:
        return;
    L_0x013d:
        r3 = "X-Content-Encoding";
        r4 = "rc4";
        r2.addHeader(r3, r4);	 Catch:{ Throwable -> 0x0145 }
        goto L_0x00da;
    L_0x0145:
        r0 = move-exception;
        r1 = f22516c;	 Catch:{ all -> 0x0158 }
        r1.m29411f(r0);	 Catch:{ all -> 0x0158 }
        if (r14 == 0) goto L_0x013c;
    L_0x014d:
        r14.mo5345b();	 Catch:{ Throwable -> 0x0151 }
        goto L_0x013c;
    L_0x0151:
        r0 = move-exception;
        r1 = f22516c;	 Catch:{ all -> 0x0158 }
        r1.m29411f(r0);	 Catch:{ all -> 0x0158 }
        goto L_0x013c;
    L_0x0158:
        r0 = move-exception;
        throw r0;
    L_0x015a:
        if (r4 != 0) goto L_0x01ac;
    L_0x015c:
        r3 = "Content-Encoding";
        r4 = "rc4,gzip";
        r2.addHeader(r3, r4);	 Catch:{ Throwable -> 0x0145 }
    L_0x0163:
        r3 = 4;
        r3 = new byte[r3];	 Catch:{ Throwable -> 0x0145 }
        r5.write(r3);	 Catch:{ Throwable -> 0x0145 }
        r3 = new java.util.zip.GZIPOutputStream;	 Catch:{ Throwable -> 0x0145 }
        r3.<init>(r5);	 Catch:{ Throwable -> 0x0145 }
        r3.write(r0);	 Catch:{ Throwable -> 0x0145 }
        r3.close();	 Catch:{ Throwable -> 0x0145 }
        r0 = r5.toByteArray();	 Catch:{ Throwable -> 0x0145 }
        r3 = 0;
        r4 = 4;
        r3 = java.nio.ByteBuffer.wrap(r0, r3, r4);	 Catch:{ Throwable -> 0x0145 }
        r3.putInt(r6);	 Catch:{ Throwable -> 0x0145 }
        r3 = f22516c;	 Catch:{ Throwable -> 0x0145 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0145 }
        r4.<init>();	 Catch:{ Throwable -> 0x0145 }
        r7 = "before Gzip:";
        r4 = r4.append(r7);	 Catch:{ Throwable -> 0x0145 }
        r4 = r4.append(r6);	 Catch:{ Throwable -> 0x0145 }
        r6 = " bytes, after Gzip:";
        r4 = r4.append(r6);	 Catch:{ Throwable -> 0x0145 }
        r6 = r0.length;	 Catch:{ Throwable -> 0x0145 }
        r4 = r4.append(r6);	 Catch:{ Throwable -> 0x0145 }
        r6 = " bytes";
        r4 = r4.append(r6);	 Catch:{ Throwable -> 0x0145 }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x0145 }
        r3.m29413h(r4);	 Catch:{ Throwable -> 0x0145 }
        goto L_0x00da;
    L_0x01ac:
        r3 = "X-Content-Encoding";
        r4 = "rc4,gzip";
        r2.addHeader(r3, r4);	 Catch:{ Throwable -> 0x0145 }
        goto L_0x0163;
    L_0x01b4:
        r0 = f22516c;	 Catch:{ Throwable -> 0x0145 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0145 }
        r2.<init>();	 Catch:{ Throwable -> 0x0145 }
        r3 = "Server response error code:";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x0145 }
        r1 = r2.append(r1);	 Catch:{ Throwable -> 0x0145 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x0145 }
        r0.m29410e(r1);	 Catch:{ Throwable -> 0x0145 }
        goto L_0x0139;
    L_0x01ce:
        r3 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1));
        if (r3 <= 0) goto L_0x0312;
    L_0x01d2:
        r3 = r0.getContent();	 Catch:{ Throwable -> 0x0145 }
        r4 = new java.io.DataInputStream;	 Catch:{ Throwable -> 0x0145 }
        r4.<init>(r3);	 Catch:{ Throwable -> 0x0145 }
        r6 = r0.getContentLength();	 Catch:{ Throwable -> 0x0145 }
        r0 = (int) r6;	 Catch:{ Throwable -> 0x0145 }
        r0 = new byte[r0];	 Catch:{ Throwable -> 0x0145 }
        r4.readFully(r0);	 Catch:{ Throwable -> 0x0145 }
        r3.close();	 Catch:{ Throwable -> 0x0145 }
        r4.close();	 Catch:{ Throwable -> 0x0145 }
        r4 = "Content-Encoding";
        r2 = r2.getFirstHeader(r4);	 Catch:{ Throwable -> 0x0145 }
        if (r2 == 0) goto L_0x0207;
    L_0x01f3:
        r4 = r2.getValue();	 Catch:{ Throwable -> 0x0145 }
        r6 = "gzip,rc4";
        r4 = r4.equalsIgnoreCase(r6);	 Catch:{ Throwable -> 0x0145 }
        if (r4 == 0) goto L_0x028e;
    L_0x01ff:
        r0 = com.tencent.stat.p545b.C6463m.m29447a(r0);	 Catch:{ Throwable -> 0x0145 }
        r0 = com.tencent.stat.p545b.C6457g.m29421b(r0);	 Catch:{ Throwable -> 0x0145 }
    L_0x0207:
        if (r1 != r9) goto L_0x02e7;
    L_0x0209:
        r1 = new java.lang.String;	 Catch:{ Throwable -> 0x02dc }
        r2 = "UTF-8";
        r1.<init>(r0, r2);	 Catch:{ Throwable -> 0x02dc }
        r0 = f22516c;	 Catch:{ Throwable -> 0x02dc }
        r0.m29413h(r1);	 Catch:{ Throwable -> 0x02dc }
        r0 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x02dc }
        r0.<init>(r1);	 Catch:{ Throwable -> 0x02dc }
        r2 = "cfg";
        r2 = r0.isNull(r2);	 Catch:{ Throwable -> 0x02dc }
        if (r2 != 0) goto L_0x022b;
    L_0x0222:
        r2 = "cfg";
        r2 = r0.getJSONObject(r2);	 Catch:{ Throwable -> 0x02dc }
        com.tencent.stat.C6470c.m29510a(r2);	 Catch:{ Throwable -> 0x02dc }
    L_0x022b:
        r2 = "et";
        r2 = r0.isNull(r2);	 Catch:{ Throwable -> 0x02dc }
        if (r2 != 0) goto L_0x0284;
    L_0x0233:
        r2 = "st";
        r2 = r0.isNull(r2);	 Catch:{ Throwable -> 0x02dc }
        if (r2 != 0) goto L_0x0284;
    L_0x023c:
        r2 = f22516c;	 Catch:{ Throwable -> 0x02dc }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x02dc }
        r4.<init>();	 Catch:{ Throwable -> 0x02dc }
        r6 = "get mid respone:";
        r4 = r4.append(r6);	 Catch:{ Throwable -> 0x02dc }
        r1 = r4.append(r1);	 Catch:{ Throwable -> 0x02dc }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x02dc }
        r2.m29413h(r1);	 Catch:{ Throwable -> 0x02dc }
        r1 = "et";
        r1 = r0.getInt(r1);	 Catch:{ Throwable -> 0x02dc }
        r2 = com.tencent.stat.p544a.C6445c.SESSION_ENV;	 Catch:{ Throwable -> 0x02dc }
        r2 = r2.m29371a();	 Catch:{ Throwable -> 0x02dc }
        if (r1 != r2) goto L_0x0284;
    L_0x0262:
        r1 = "st";
        r1 = r0.getInt(r1);	 Catch:{ Throwable -> 0x02dc }
        switch(r1) {
            case -1: goto L_0x02c8;
            case 0: goto L_0x02c8;
            default: goto L_0x026c;
        };	 Catch:{ Throwable -> 0x02dc }
    L_0x026c:
        r0 = f22516c;	 Catch:{ Throwable -> 0x02dc }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x02dc }
        r2.<init>();	 Catch:{ Throwable -> 0x02dc }
        r4 = "error type for st:";
        r2 = r2.append(r4);	 Catch:{ Throwable -> 0x02dc }
        r1 = r2.append(r1);	 Catch:{ Throwable -> 0x02dc }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x02dc }
        r0.m29411f(r1);	 Catch:{ Throwable -> 0x02dc }
    L_0x0284:
        if (r14 == 0) goto L_0x0289;
    L_0x0286:
        r14.mo5344a();	 Catch:{ Throwable -> 0x0145 }
    L_0x0289:
        r3.close();	 Catch:{ Throwable -> 0x0145 }
        goto L_0x0139;
    L_0x028e:
        r4 = r2.getValue();	 Catch:{ Throwable -> 0x0145 }
        r6 = "rc4,gzip";
        r4 = r4.equalsIgnoreCase(r6);	 Catch:{ Throwable -> 0x0145 }
        if (r4 == 0) goto L_0x02a4;
    L_0x029a:
        r0 = com.tencent.stat.p545b.C6457g.m29421b(r0);	 Catch:{ Throwable -> 0x0145 }
        r0 = com.tencent.stat.p545b.C6463m.m29447a(r0);	 Catch:{ Throwable -> 0x0145 }
        goto L_0x0207;
    L_0x02a4:
        r4 = r2.getValue();	 Catch:{ Throwable -> 0x0145 }
        r6 = "gzip";
        r4 = r4.equalsIgnoreCase(r6);	 Catch:{ Throwable -> 0x0145 }
        if (r4 == 0) goto L_0x02b6;
    L_0x02b0:
        r0 = com.tencent.stat.p545b.C6463m.m29447a(r0);	 Catch:{ Throwable -> 0x0145 }
        goto L_0x0207;
    L_0x02b6:
        r2 = r2.getValue();	 Catch:{ Throwable -> 0x0145 }
        r4 = "rc4";
        r2 = r2.equalsIgnoreCase(r4);	 Catch:{ Throwable -> 0x0145 }
        if (r2 == 0) goto L_0x0207;
    L_0x02c2:
        r0 = com.tencent.stat.p545b.C6457g.m29421b(r0);	 Catch:{ Throwable -> 0x0145 }
        goto L_0x0207;
    L_0x02c8:
        r1 = "mid";
        r1 = r0.isNull(r1);	 Catch:{ Throwable -> 0x02dc }
        if (r1 != 0) goto L_0x0284;
    L_0x02d0:
        r1 = f22519f;	 Catch:{ Throwable -> 0x02dc }
        r2 = "mid";
        r0 = r0.getString(r2);	 Catch:{ Throwable -> 0x02dc }
        com.tencent.stat.C6471d.m29543a(r1, r0);	 Catch:{ Throwable -> 0x02dc }
        goto L_0x0284;
    L_0x02dc:
        r0 = move-exception;
        r1 = f22516c;	 Catch:{ Throwable -> 0x0145 }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x0145 }
        r1.m29407b(r0);	 Catch:{ Throwable -> 0x0145 }
        goto L_0x0284;
    L_0x02e7:
        r2 = f22516c;	 Catch:{ Throwable -> 0x0145 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0145 }
        r4.<init>();	 Catch:{ Throwable -> 0x0145 }
        r6 = "Server response error code:";
        r4 = r4.append(r6);	 Catch:{ Throwable -> 0x0145 }
        r1 = r4.append(r1);	 Catch:{ Throwable -> 0x0145 }
        r4 = ", error:";
        r1 = r1.append(r4);	 Catch:{ Throwable -> 0x0145 }
        r4 = new java.lang.String;	 Catch:{ Throwable -> 0x0145 }
        r6 = "UTF-8";
        r4.<init>(r0, r6);	 Catch:{ Throwable -> 0x0145 }
        r0 = r1.append(r4);	 Catch:{ Throwable -> 0x0145 }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x0145 }
        r2.m29410e(r0);	 Catch:{ Throwable -> 0x0145 }
        goto L_0x0289;
    L_0x0312:
        org.apache.http.util.EntityUtils.toString(r0);	 Catch:{ Throwable -> 0x0145 }
        goto L_0x0139;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.k.a(java.util.List, com.tencent.stat.j):void");
    }

    void m29584b(List<String> list, C6450j c6450j) {
        if (!list.isEmpty() && this.f22521b != null) {
            this.f22521b.post(new C6479m(this, list, c6450j));
        }
    }
}
