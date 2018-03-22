package cn.com.xy.sms.sdk.p216h;

import cn.com.xy.sms.sdk.p205a.C2904g;

public final class C3005j extends C2997c {
    private int f10163a = -1;

    public C3005j(int i, String str, String str2, C2904g c2904g, boolean z) {
        super(str, null, str2, false, null, c2904g, true);
        this.f10163a = i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r10 = this;
        r1 = 0;
        r1 = r10.m13512a();	 Catch:{ Throwable -> 0x0150 }
        r0 = "sceneType";
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0150 }
        r3 = r10.f10163a;	 Catch:{ Throwable -> 0x0150 }
        r3 = java.lang.String.valueOf(r3);	 Catch:{ Throwable -> 0x0150 }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x0150 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x0150 }
        r1.addRequestProperty(r0, r2);	 Catch:{ Throwable -> 0x0150 }
        r0 = "reqVersion";
        r2 = "5.1.2";
        r1.addRequestProperty(r0, r2);	 Catch:{ Throwable -> 0x0150 }
        r0 = "clientKey";
        r2 = cn.com.xy.sms.sdk.p216h.C3006k.f10165k;	 Catch:{ Throwable -> 0x0150 }
        r1.addRequestProperty(r0, r2);	 Catch:{ Throwable -> 0x0150 }
        r0 = "client_key";
        r2 = "123456";
        r1.addRequestProperty(r0, r2);	 Catch:{ Throwable -> 0x0150 }
        r1.connect();	 Catch:{ Throwable -> 0x0150 }
        r2 = r1.getOutputStream();	 Catch:{ Throwable -> 0x0150 }
        r0 = 1;
        r0 = cn.com.xy.sms.sdk.p229l.C3050o.m13667a(r0);	 Catch:{ Throwable -> 0x0150 }
        r3 = "xyvalue";
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0150 }
        r5 = "tempKey: ";
        r4.<init>(r5);	 Catch:{ Throwable -> 0x0150 }
        r4 = r4.append(r0);	 Catch:{ Throwable -> 0x0150 }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x0150 }
        r5 = 0;
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r3, r4, r5);	 Catch:{ Throwable -> 0x0150 }
        r3 = r10.c;	 Catch:{ Throwable -> 0x0150 }
        r0 = cn.com.xy.sms.sdk.p216h.p217a.C2987e.m13427a(r3, r0);	 Catch:{ Throwable -> 0x0150 }
        r3 = r10.h;	 Catch:{ Throwable -> 0x0150 }
        if (r3 == 0) goto L_0x0060;
    L_0x005c:
        r0 = cn.com.xy.sms.sdk.p229l.C3049n.m13647b(r0);	 Catch:{ Throwable -> 0x0150 }
    L_0x0060:
        r2.write(r0);	 Catch:{ Throwable -> 0x0150 }
        r2.flush();	 Catch:{ Throwable -> 0x0150 }
        cn.com.xy.sms.sdk.p229l.C3055t.m13696a(r2);	 Catch:{ Throwable -> 0x0150 }
        r0 = r1.getResponseCode();	 Catch:{ Throwable -> 0x0150 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0150 }
        r3 = "########sceneType=";
        r2.<init>(r3);	 Catch:{ Throwable -> 0x0150 }
        r3 = r10.f10163a;	 Catch:{ Throwable -> 0x0150 }
        r2.append(r3);	 Catch:{ Throwable -> 0x0150 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0150 }
        r3 = "url=";
        r2.<init>(r3);	 Catch:{ Throwable -> 0x0150 }
        r3 = r10.b;	 Catch:{ Throwable -> 0x0150 }
        r2.append(r3);	 Catch:{ Throwable -> 0x0150 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0150 }
        r3 = "content=";
        r2.<init>(r3);	 Catch:{ Throwable -> 0x0150 }
        r3 = r10.c;	 Catch:{ Throwable -> 0x0150 }
        r2.append(r3);	 Catch:{ Throwable -> 0x0150 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0150 }
        r3 = " responseCode: ";
        r2.<init>(r3);	 Catch:{ Throwable -> 0x0150 }
        r3 = r1.getResponseCode();	 Catch:{ Throwable -> 0x0150 }
        r2.append(r3);	 Catch:{ Throwable -> 0x0150 }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r0 != r2) goto L_0x014a;
    L_0x00a4:
        r3 = r1.getInputStream();	 Catch:{ Throwable -> 0x0150 }
        r2 = cn.com.xy.sms.sdk.p229l.C3055t.m13705a(r3);	 Catch:{ Throwable -> 0x0150 }
        r4 = r2.length;	 Catch:{ Throwable -> 0x0150 }
        r0 = r10.c;	 Catch:{ Throwable -> 0x0150 }
        cn.com.xy.sms.sdk.p216h.C2997c.m13509a(r0, r4);	 Catch:{ Throwable -> 0x0150 }
        r6 = (long) r4;	 Catch:{ Throwable -> 0x0150 }
        r8 = 26214400; // 0x1900000 float:5.2897246E-38 double:1.29516345E-316;
        r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r0 <= 0) goto L_0x00e2;
    L_0x00ba:
        r0 = -9;
        r2 = "";
        r10.m13513a(r0, r2);	 Catch:{ Throwable -> 0x0150 }
        if (r1 == 0) goto L_0x00c6;
    L_0x00c3:
        r1.disconnect();	 Catch:{ Throwable -> 0x00c7 }
    L_0x00c6:
        return;
    L_0x00c7:
        r0 = move-exception;
        r1 = "XIAOYUAN";
        r2 = new java.lang.StringBuilder;
        r3 = "run: ";
        r2.<init>(r3);
        r3 = r0.getMessage();
        r2 = r2.append(r3);
        r2 = r2.toString();
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r1, r2, r0);
        goto L_0x00c6;
    L_0x00e2:
        r0 = r10.h;	 Catch:{ Throwable -> 0x012f }
        if (r0 == 0) goto L_0x0148;
    L_0x00e6:
        r0 = cn.com.xy.sms.sdk.p229l.C3049n.m13645a(r2);	 Catch:{ Throwable -> 0x012f }
        if (r0 == 0) goto L_0x0148;
    L_0x00ec:
        r2 = new java.lang.String;	 Catch:{ Throwable -> 0x0150 }
        r5 = "UTF-8";
        r2.<init>(r0, r5);	 Catch:{ Throwable -> 0x0150 }
        r0 = 0;
        r10.m13513a(r0, r2);	 Catch:{ Throwable -> 0x0150 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0150 }
        r5 = "response=";
        r0.<init>(r5);	 Catch:{ Throwable -> 0x0150 }
        r0 = r0.append(r2);	 Catch:{ Throwable -> 0x0150 }
        r2 = " len : ";
        r0 = r0.append(r2);	 Catch:{ Throwable -> 0x0150 }
        r0.append(r4);	 Catch:{ Throwable -> 0x0150 }
        cn.com.xy.sms.sdk.p229l.C3055t.m13696a(r3);	 Catch:{ Throwable -> 0x0150 }
    L_0x010e:
        if (r1 == 0) goto L_0x00c6;
    L_0x0110:
        r1.disconnect();	 Catch:{ Throwable -> 0x0114 }
        goto L_0x00c6;
    L_0x0114:
        r0 = move-exception;
        r1 = "XIAOYUAN";
        r2 = new java.lang.StringBuilder;
        r3 = "run: ";
        r2.<init>(r3);
        r3 = r0.getMessage();
        r2 = r2.append(r3);
        r2 = r2.toString();
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r1, r2, r0);
        goto L_0x00c6;
    L_0x012f:
        r0 = move-exception;
        r5 = "XIAOYUAN";
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0150 }
        r7 = "SdkXyHttpRunnable run";
        r6.<init>(r7);	 Catch:{ Throwable -> 0x0150 }
        r7 = r0.getLocalizedMessage();	 Catch:{ Throwable -> 0x0150 }
        r6 = r6.append(r7);	 Catch:{ Throwable -> 0x0150 }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x0150 }
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r5, r6, r0);	 Catch:{ Throwable -> 0x0150 }
    L_0x0148:
        r0 = r2;
        goto L_0x00ec;
    L_0x014a:
        r0 = -8;
        r2 = 0;
        r10.m13513a(r0, r2);	 Catch:{ Throwable -> 0x0150 }
        goto L_0x010e;
    L_0x0150:
        r0 = move-exception;
        r2 = "HTTP";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01a2 }
        r4 = "http error: ";
        r3.<init>(r4);	 Catch:{ all -> 0x01a2 }
        r4 = r0.getMessage();	 Catch:{ all -> 0x01a2 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x01a2 }
        r3 = r3.toString();	 Catch:{ all -> 0x01a2 }
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r2, r3, r0);	 Catch:{ all -> 0x01a2 }
        r2 = r0.getClass();	 Catch:{ all -> 0x01a2 }
        r3 = java.net.SocketTimeoutException.class;
        if (r2 != r3) goto L_0x0199;
    L_0x0171:
        r0 = -6;
        r2 = 0;
        r10.m13513a(r0, r2);	 Catch:{ all -> 0x01a2 }
    L_0x0176:
        if (r1 == 0) goto L_0x00c6;
    L_0x0178:
        r1.disconnect();	 Catch:{ Throwable -> 0x017d }
        goto L_0x00c6;
    L_0x017d:
        r0 = move-exception;
        r1 = "XIAOYUAN";
        r2 = new java.lang.StringBuilder;
        r3 = "run: ";
        r2.<init>(r3);
        r3 = r0.getMessage();
        r2 = r2.append(r3);
        r2 = r2.toString();
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r1, r2, r0);
        goto L_0x00c6;
    L_0x0199:
        r2 = -7;
        r0 = r0.getMessage();	 Catch:{ all -> 0x01a2 }
        r10.m13513a(r2, r0);	 Catch:{ all -> 0x01a2 }
        goto L_0x0176;
    L_0x01a2:
        r0 = move-exception;
        if (r1 == 0) goto L_0x01a8;
    L_0x01a5:
        r1.disconnect();	 Catch:{ Throwable -> 0x01a9 }
    L_0x01a8:
        throw r0;
    L_0x01a9:
        r1 = move-exception;
        r2 = "XIAOYUAN";
        r3 = new java.lang.StringBuilder;
        r4 = "run: ";
        r3.<init>(r4);
        r4 = r1.getMessage();
        r3 = r3.append(r4);
        r3 = r3.toString();
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r2, r3, r1);
        goto L_0x01a8;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.xy.sms.sdk.h.j.run():void");
    }
}
