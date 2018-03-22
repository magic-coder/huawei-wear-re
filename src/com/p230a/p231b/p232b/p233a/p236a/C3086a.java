package com.p230a.p231b.p232b.p233a.p236a;

import com.p230a.p231b.p232b.p233a.C3085g;
import com.p230a.p231b.p232b.p233a.C3102w;
import com.p230a.p231b.p232b.p233a.C3106t;
import com.p230a.p231b.p232b.p233a.C3115m;
import com.p230a.p231b.p232b.p233a.C3119u;
import com.p230a.p231b.p232b.p233a.C3121x;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

public class C3086a implements C3085g {
    protected static final boolean f10368a = C3121x.f10470b;
    private static int f10369d = 3000;
    private static int f10370e = 4096;
    protected final C3091g f10371b;
    protected final C3087b f10372c;

    public C3086a(C3091g c3091g) {
        this(c3091g, new C3087b(f10370e));
    }

    public C3086a(C3091g c3091g, C3087b c3087b) {
        this.f10371b = c3091g;
        this.f10372c = c3087b;
    }

    private static Map m13796a(Header[] headerArr) {
        Map hashMap = new HashMap();
        for (int i = 0; i < headerArr.length; i++) {
            hashMap.put(headerArr[i].getName(), headerArr[i].getValue());
        }
        return hashMap;
    }

    private static void m13797a(String str, C3115m c3115m, C3102w c3102w) {
        C3106t s = c3115m.m13894s();
        int r = c3115m.m13893r();
        try {
            s.mo3657a(c3102w);
            c3115m.m13873a(String.format("%s-retry [timeout=%s]", new Object[]{str, Integer.valueOf(r)}));
        } catch (C3102w e) {
            c3115m.m13873a(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{str, Integer.valueOf(r)}));
            throw e;
        }
    }

    private byte[] m13798a(HttpEntity httpEntity) {
        C3096j c3096j = new C3096j(this.f10372c, (int) httpEntity.getContentLength());
        byte[] bArr = null;
        try {
            InputStream content = httpEntity.getContent();
            if (content == null) {
                throw new C3119u();
            }
            bArr = this.f10372c.m13802a(1024);
            while (true) {
                int read = content.read(bArr);
                if (read == -1) {
                    break;
                }
                c3096j.write(bArr, 0, read);
            }
            byte[] toByteArray = c3096j.toByteArray();
            return toByteArray;
        } finally {
            try {
                httpEntity.consumeContent();
            } catch (IOException e) {
                C3121x.m13905a("Error occured when calling consumingContent", new Object[0]);
            }
            this.f10372c.m13801a(bArr);
            c3096j.close();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.p230a.p231b.p232b.p233a.C3112j mo3651a(com.p230a.p231b.p232b.p233a.C3115m r13) {
        /*
        r12 = this;
        r4 = android.os.SystemClock.elapsedRealtime();
    L_0x0004:
        r3 = 0;
        r2 = 0;
        r1 = new java.util.HashMap;
        r1.<init>();
        r0 = new java.util.HashMap;	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        r0.<init>();	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        r6 = r13.m13883h();	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        if (r6 == 0) goto L_0x0039;
    L_0x0016:
        r7 = r6.f10411b;	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        if (r7 == 0) goto L_0x0021;
    L_0x001a:
        r7 = "If-None-Match";
        r8 = r6.f10411b;	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        r0.put(r7, r8);	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
    L_0x0021:
        r8 = r6.f10412c;	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        r10 = 0;
        r7 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r7 <= 0) goto L_0x0039;
    L_0x0029:
        r7 = new java.util.Date;	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        r8 = r6.f10412c;	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        r7.<init>(r8);	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        r6 = "If-Modified-Since";
        r7 = org.apache.http.impl.cookie.DateUtils.formatDate(r7);	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        r0.put(r6, r7);	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
    L_0x0039:
        r6 = r12.f10371b;	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        r3 = r6.mo3655a(r13, r0);	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        r6 = r3.getStatusLine();	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        r7 = r6.getStatusCode();	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        r0 = r3.getAllHeaders();	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        r1 = com.p230a.p231b.p232b.p233a.p236a.C3086a.m13796a(r0);	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        r0 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        if (r7 != r0) goto L_0x0062;
    L_0x0053:
        r0 = new com.a.b.b.a.j;	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        r6 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        r7 = r13.m13883h();	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        r7 = r7.f10410a;	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        r8 = 1;
        r0.<init>(r6, r7, r1, r8);	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
    L_0x0061:
        return r0;
    L_0x0062:
        r0 = r3.getEntity();	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        if (r0 == 0) goto L_0x00d2;
    L_0x0068:
        r0 = r3.getEntity();	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        r2 = r12.m13798a(r0);	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
    L_0x0070:
        r8 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        r8 = r8 - r4;
        r0 = f10368a;	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        if (r0 != 0) goto L_0x0080;
    L_0x0079:
        r0 = f10369d;	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        r10 = (long) r0;	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r0 <= 0) goto L_0x00b6;
    L_0x0080:
        r10 = "HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]";
        r0 = 5;
        r11 = new java.lang.Object[r0];	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        r0 = 0;
        r11[r0] = r13;	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        r0 = 1;
        r8 = java.lang.Long.valueOf(r8);	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        r11[r0] = r8;	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        r8 = 2;
        if (r2 == 0) goto L_0x00d6;
    L_0x0092:
        r0 = r2.length;	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
    L_0x0097:
        r11[r8] = r0;	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        r0 = 3;
        r6 = r6.getStatusCode();	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        r11[r0] = r6;	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        r0 = 4;
        r6 = r13.m13894s();	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        r6 = r6.mo3658b();	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        r11[r0] = r6;	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        com.p230a.p231b.p232b.p233a.C3121x.m13907b(r10, r11);	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
    L_0x00b6:
        r0 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r7 < r0) goto L_0x00be;
    L_0x00ba:
        r0 = 299; // 0x12b float:4.19E-43 double:1.477E-321;
        if (r7 <= r0) goto L_0x00d9;
    L_0x00be:
        r0 = new java.io.IOException;	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        r0.<init>();	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        throw r0;	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
    L_0x00c4:
        r0 = move-exception;
        r0 = "socket";
        r1 = new com.a.b.b.a.v;
        r1.<init>();
        com.p230a.p231b.p232b.p233a.p236a.C3086a.m13797a(r0, r13, r1);
        goto L_0x0004;
    L_0x00d2:
        r0 = 0;
        r2 = new byte[r0];	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        goto L_0x0070;
    L_0x00d6:
        r0 = "null";
        goto L_0x0097;
    L_0x00d9:
        r0 = new com.a.b.b.a.j;	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        r6 = 0;
        r0.<init>(r7, r2, r1, r6);	 Catch:{ SocketTimeoutException -> 0x00c4, ConnectTimeoutException -> 0x00e0, MalformedURLException -> 0x00ed, IOException -> 0x0107 }
        goto L_0x0061;
    L_0x00e0:
        r0 = move-exception;
        r0 = "connection";
        r1 = new com.a.b.b.a.v;
        r1.<init>();
        com.p230a.p231b.p232b.p233a.p236a.C3086a.m13797a(r0, r13, r1);
        goto L_0x0004;
    L_0x00ed:
        r0 = move-exception;
        r1 = new java.lang.RuntimeException;
        r2 = new java.lang.StringBuilder;
        r3 = "Bad URL ";
        r2.<init>(r3);
        r3 = r13.m13881f();
        r2 = r2.append(r3);
        r2 = r2.toString();
        r1.<init>(r2, r0);
        throw r1;
    L_0x0107:
        r0 = move-exception;
        if (r3 == 0) goto L_0x0144;
    L_0x010a:
        r0 = r3.getStatusLine();
        r0 = r0.getStatusCode();
        r3 = "Unexpected response code %d for %s";
        r6 = 2;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r8 = java.lang.Integer.valueOf(r0);
        r6[r7] = r8;
        r7 = 1;
        r8 = r13.m13881f();
        r6[r7] = r8;
        com.p230a.p231b.p232b.p233a.C3121x.m13908c(r3, r6);
        if (r2 == 0) goto L_0x0150;
    L_0x012a:
        r3 = new com.a.b.b.a.j;
        r6 = 0;
        r3.<init>(r0, r2, r1, r6);
        r1 = 401; // 0x191 float:5.62E-43 double:1.98E-321;
        if (r0 == r1) goto L_0x0138;
    L_0x0134:
        r1 = 403; // 0x193 float:5.65E-43 double:1.99E-321;
        if (r0 != r1) goto L_0x014a;
    L_0x0138:
        r0 = "auth";
        r1 = new com.a.b.b.a.a;
        r1.<init>(r3);
        com.p230a.p231b.p232b.p233a.p236a.C3086a.m13797a(r0, r13, r1);
        goto L_0x0004;
    L_0x0144:
        r1 = new com.a.b.b.a.k;
        r1.<init>(r0);
        throw r1;
    L_0x014a:
        r0 = new com.a.b.b.a.u;
        r0.<init>(r3);
        throw r0;
    L_0x0150:
        r0 = new com.a.b.b.a.i;
        r1 = 0;
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.b.b.a.a.a.a(com.a.b.b.a.m):com.a.b.b.a.j");
    }
}
