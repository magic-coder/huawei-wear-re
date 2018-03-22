package cn.com.xy.sms.sdk.p216h;

import cn.com.xy.sms.sdk.p205a.C2904g;
import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p208d.p211c.C2947n;
import cn.com.xy.sms.sdk.p213e.C2973a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p216h.p217a.C2994l;
import cn.com.xy.sms.sdk.p229l.C3049n;
import cn.com.xy.sms.sdk.p229l.ad;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import java.net.HttpURLConnection;

public final class C3006k extends C2997c {
    public static String f10164a = null;
    public static String f10165k = null;
    private String f10166l;

    public C3006k(String str, String str2, String str3, String str4, boolean z, C2904g c2904g, Boolean bool) {
        super(str, null, str2, z, str4, c2904g, bool.booleanValue());
        this.f10166l = str3;
    }

    public final void mo3633a(C3000e c3000e, boolean z, String str, HttpURLConnection httpURLConnection) {
        httpURLConnection.addRequestProperty("Content-Type", "text/xml;UTF-8");
        if (!C3049n.m13653e(this.f10166l)) {
            httpURLConnection.addRequestProperty("cnum", this.f10166l);
        }
        String str2 = f10165k;
        if (z) {
            httpURLConnection.addRequestProperty("command", "2");
        } else {
            String d = C2947n.m13284d(C2917a.m13105a(), "HTTPTOKEN");
            httpURLConnection.addRequestProperty("command", "1");
            if (!C3049n.m13653e(d)) {
                str2 = new StringBuilder(String.valueOf(str2)).append(d).toString();
                httpURLConnection.addRequestProperty(SNBConstant.FIELD_TOKEN, d);
            }
        }
        str2 = C2994l.m13473a(f10164a, str2);
        httpURLConnection.addRequestProperty("app-key", f10165k);
        httpURLConnection.addRequestProperty("app-key-sign", str2);
        httpURLConnection.addRequestProperty("compress", "1");
        httpURLConnection.addRequestProperty("loginid", "");
        httpURLConnection.addRequestProperty("recordState", ad.m13585a());
        httpURLConnection.addRequestProperty("sdkversion", C2996a.f10136h);
        httpURLConnection.addRequestProperty("abi", C2997c.m13511c());
        httpURLConnection.addRequestProperty("uiversion", C2973a.m13385g());
        if (C2982a.f10101a) {
            C2982a.m13414a("httpheader", httpURLConnection.getRequestProperties().toString());
        }
        if (!C3049n.m13653e(str)) {
            httpURLConnection.addRequestProperty("cmd", str);
        }
        m13517a(httpURLConnection);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r8 = this;
        r1 = 0;
        r2 = r8.m13512a();	 Catch:{ Throwable -> 0x0167, all -> 0x0164 }
        r0 = r2.getRequestProperties();	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r1 = cn.com.xy.sms.sdk.p215g.C2982a.f10101a;	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        if (r1 == 0) goto L_0x001d;
    L_0x000d:
        if (r0 == 0) goto L_0x001d;
    L_0x000f:
        r0 = r0.entrySet();	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r3 = r0.iterator();	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
    L_0x0017:
        r0 = r3.hasNext();	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        if (r0 != 0) goto L_0x00bb;
    L_0x001d:
        r2.connect();	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r1 = r2.getOutputStream();	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r0 = 2;
        r3 = cn.com.xy.sms.sdk.p229l.C3050o.m13667a(r0);	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r4 = " url=";
        r0.<init>(r4);	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r4 = r8.b;	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r0 = r0.append(r4);	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r4 = "isCompress:";
        r0 = r0.append(r4);	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r4 = r8.h;	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r0.append(r4);	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r4 = " content=";
        r0.<init>(r4);	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r4 = r8.c;	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r0.append(r4);	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r0 = "xyvalue";
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r5 = "keyStr: ";
        r4.<init>(r5);	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r4 = r4.append(r3);	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r5 = 0;
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r0, r4, r5);	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r0 = r8.c;	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r0 = cn.com.xy.sms.sdk.p216h.p217a.C2987e.m13427a(r0, r3);	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r4 = r8.h;	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        if (r4 == 0) goto L_0x0071;
    L_0x006d:
        r0 = cn.com.xy.sms.sdk.p229l.C3049n.m13647b(r0);	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
    L_0x0071:
        r1.write(r0);	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r1.flush();	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r1.close();	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r0 = r2.getResponseCode();	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r4 = "URL:";
        r1.<init>(r4);	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r4 = r8.b;	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r1 = r1.append(r4);	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r4 = "  code=";
        r1 = r1.append(r4);	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r1.append(r0);	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r0 != r1) goto L_0x014e;
    L_0x0098:
        r1 = r2.getInputStream();	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r0 = cn.com.xy.sms.sdk.p229l.C3055t.m13705a(r1);	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r4 = r0.length;	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r5 = r8.c;	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        cn.com.xy.sms.sdk.p216h.C2997c.m13509a(r5, r4);	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r4 = (long) r4;	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r6 = 26214400; // 0x1900000 float:5.2897246E-38 double:1.29516345E-316;
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 <= 0) goto L_0x0107;
    L_0x00ae:
        r0 = -9;
        r1 = "";
        r8.m13513a(r0, r1);	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        if (r2 == 0) goto L_0x00ba;
    L_0x00b7:
        r2.disconnect();	 Catch:{ Throwable -> 0x015f }
    L_0x00ba:
        return;
    L_0x00bb:
        r0 = r3.next();	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r1 = "key=";
        r4.<init>(r1);	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r1 = r0.getKey();	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r1 = (java.lang.String) r1;	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r1 = r4.append(r1);	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r4 = " value =";
        r1 = r1.append(r4);	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r0 = r0.getValue();	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r1.append(r0);	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        goto L_0x0017;
    L_0x00e1:
        r0 = move-exception;
        r1 = r2;
    L_0x00e3:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x015c }
        r3 = "http error: ";
        r2.<init>(r3);	 Catch:{ all -> 0x015c }
        r3 = r0.getMessage();	 Catch:{ all -> 0x015c }
        r2.append(r3);	 Catch:{ all -> 0x015c }
        r0 = r0.getClass();	 Catch:{ all -> 0x015c }
        r2 = java.net.SocketTimeoutException.class;
        if (r0 != r2) goto L_0x0155;
    L_0x00f9:
        r0 = -6;
        r2 = "";
        r8.m13513a(r0, r2);	 Catch:{ all -> 0x015c }
    L_0x00ff:
        if (r1 == 0) goto L_0x00ba;
    L_0x0101:
        r1.disconnect();	 Catch:{ Throwable -> 0x0105 }
        goto L_0x00ba;
    L_0x0105:
        r0 = move-exception;
        goto L_0x00ba;
    L_0x0107:
        r4 = r8.h;	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        if (r4 == 0) goto L_0x010f;
    L_0x010b:
        r0 = cn.com.xy.sms.sdk.p229l.C3049n.m13645a(r0);	 Catch:{ Throwable -> 0x012d, all -> 0x0147 }
    L_0x010f:
        r3 = r3.getBytes();	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r0 = cn.com.xy.sms.sdk.p216h.p217a.C2987e.m13428a(r0, r3);	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r3 = new java.lang.String;	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r4 = "UTF-8";
        r3.<init>(r0, r4);	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r0 = 0;
        r8.m13513a(r0, r3);	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        cn.com.xy.sms.sdk.p229l.C3055t.m13696a(r1);	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
    L_0x0125:
        if (r2 == 0) goto L_0x00ba;
    L_0x0127:
        r2.disconnect();	 Catch:{ Throwable -> 0x012b }
        goto L_0x00ba;
    L_0x012b:
        r0 = move-exception;
        goto L_0x00ba;
    L_0x012d:
        r4 = move-exception;
        r5 = "XIAOYUAN";
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r7 = "XyHttpRunnable run";
        r6.<init>(r7);	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r7 = r4.getLocalizedMessage();	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r6 = r6.append(r7);	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r5, r6, r4);	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        goto L_0x010f;
    L_0x0147:
        r0 = move-exception;
    L_0x0148:
        if (r2 == 0) goto L_0x014d;
    L_0x014a:
        r2.disconnect();	 Catch:{ Throwable -> 0x0162 }
    L_0x014d:
        throw r0;
    L_0x014e:
        r0 = -8;
        r1 = "";
        r8.m13513a(r0, r1);	 Catch:{ Throwable -> 0x00e1, all -> 0x0147 }
        goto L_0x0125;
    L_0x0155:
        r0 = -7;
        r2 = "";
        r8.m13513a(r0, r2);	 Catch:{ all -> 0x015c }
        goto L_0x00ff;
    L_0x015c:
        r0 = move-exception;
        r2 = r1;
        goto L_0x0148;
    L_0x015f:
        r0 = move-exception;
        goto L_0x00ba;
    L_0x0162:
        r1 = move-exception;
        goto L_0x014d;
    L_0x0164:
        r0 = move-exception;
        r2 = r1;
        goto L_0x0148;
    L_0x0167:
        r0 = move-exception;
        goto L_0x00e3;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.xy.sms.sdk.h.k.run():void");
    }
}
