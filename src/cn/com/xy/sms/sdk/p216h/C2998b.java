package cn.com.xy.sms.sdk.p216h;

import cn.com.xy.sms.sdk.p205a.C2904g;
import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p213e.C2973a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p216h.p217a.C2994l;
import cn.com.xy.sms.sdk.p229l.C3049n;
import cn.com.xy.sms.sdk.p229l.ad;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.leisen.wallet.sdk.http.RequestParams;
import java.net.HttpURLConnection;
import java.util.Map;

public class C2998b extends C2997c {
    public static String f10154a = null;

    public C2998b(String str, String str2, C2904g c2904g, boolean z, boolean z2, Map<String, String> map) {
        super(str, null, str2, z, "", c2904g, z2);
    }

    public void mo3633a(C3000e c3000e, boolean z, String str, HttpURLConnection httpURLConnection) {
        String str2 = C3006k.f10165k;
        String f = C2996a.m13505f();
        if (!C3049n.m13653e(f)) {
            str2 = new StringBuilder(String.valueOf(str2)).append(f).toString();
            httpURLConnection.addRequestProperty(SNBConstant.FIELD_TOKEN, f);
        }
        str2 = C2994l.m13473a(C3006k.f10164a, str2);
        if (C2917a.f9899i.equals(f10154a)) {
            httpURLConnection.addRequestProperty(LogBuilder.KEY_APPKEY, "XYSELF");
        } else {
            httpURLConnection.addRequestProperty(LogBuilder.KEY_APPKEY, C3006k.f10165k);
        }
        httpURLConnection.addRequestProperty("app-key-sign", str2);
        httpURLConnection.addRequestProperty("recordState", ad.m13585a());
        httpURLConnection.addRequestProperty("sdkversion", C2996a.f10136h);
        m13517a(httpURLConnection);
        httpURLConnection.addRequestProperty("abi", C2997c.m13511c());
        httpURLConnection.addRequestProperty("uiversion", C2973a.m13385g());
        httpURLConnection.addRequestProperty("Content-Type", RequestParams.APPLICATION_OCTET_STREAM);
        if (C2982a.f10101a) {
            C2982a.m13414a("httpheader", httpURLConnection.getRequestProperties().toString());
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r8 = this;
        r3 = 0;
        r2 = r8.m13512a();	 Catch:{ Throwable -> 0x01f2, all -> 0x01ef }
        r0 = r2.getRequestProperties();	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r1 = cn.com.xy.sms.sdk.p215g.C2982a.f10101a;	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        if (r1 == 0) goto L_0x001d;
    L_0x000d:
        if (r0 == 0) goto L_0x001d;
    L_0x000f:
        r0 = r0.entrySet();	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r4 = r0.iterator();	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
    L_0x0017:
        r0 = r4.hasNext();	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        if (r0 != 0) goto L_0x00a7;
    L_0x001d:
        r2.connect();	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r1 = r2.getOutputStream();	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r4 = " url=";
        r0.<init>(r4);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r4 = r8.b;	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r0.append(r4);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r4 = " content=";
        r0.<init>(r4);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r4 = r8.c;	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r0.append(r4);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r4 = " isCompress=";
        r0.<init>(r4);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r4 = r8.h;	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r0.append(r4);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r0 = r8.h;	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        if (r0 == 0) goto L_0x010c;
    L_0x004c:
        r0 = r8.c;	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r4 = "utf-8";
        r0 = r0.getBytes(r4);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r0 = cn.com.xy.sms.sdk.p229l.C3049n.m13647b(r0);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
    L_0x0059:
        r4 = r8.f;	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        if (r4 == 0) goto L_0x0117;
    L_0x005d:
        r4 = f10154a;	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r0 = cn.com.xy.sms.sdk.p216h.p217a.C2989g.m13434a(r0, r4);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
    L_0x0063:
        r4 = 0;
        r5 = r0.length;	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r1.write(r0, r4, r5);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r1.flush();	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r1.close();	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r0 = r2.getResponseCode();	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r4 = "URL:";
        r1.<init>(r4);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r4 = r8.b;	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r1 = r1.append(r4);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r4 = "  code=";
        r1 = r1.append(r4);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r1.append(r0);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r0 != r1) goto L_0x01b8;
    L_0x008c:
        r1 = r2.getInputStream();	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r0 = "XY-ERR-CODE";
        r0 = r2.getHeaderField(r0);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r4 = cn.com.xy.sms.sdk.p229l.C3049n.m13653e(r0);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        if (r4 != 0) goto L_0x0141;
    L_0x009c:
        r1 = "";
        r8.m13516a(r0, r1);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        if (r2 == 0) goto L_0x00a6;
    L_0x00a3:
        r2.disconnect();	 Catch:{ Throwable -> 0x01ea }
    L_0x00a6:
        return;
    L_0x00a7:
        r0 = r4.next();	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r1 = "key=";
        r5.<init>(r1);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r1 = r0.getKey();	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r1 = (java.lang.String) r1;	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r1 = r5.append(r1);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r5 = " value =";
        r1 = r1.append(r5);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r0 = r0.getValue();	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r1.append(r0);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        goto L_0x0017;
    L_0x00cd:
        r0 = move-exception;
        r1 = r2;
    L_0x00cf:
        r2 = "XIAOYUAN";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01e7 }
        r4 = "run: ";
        r3.<init>(r4);	 Catch:{ all -> 0x01e7 }
        r4 = r0.getMessage();	 Catch:{ all -> 0x01e7 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x01e7 }
        r3 = r3.toString();	 Catch:{ all -> 0x01e7 }
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r2, r3, r0);	 Catch:{ all -> 0x01e7 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01e7 }
        r3 = "http error: ";
        r2.<init>(r3);	 Catch:{ all -> 0x01e7 }
        r3 = r0.getMessage();	 Catch:{ all -> 0x01e7 }
        r2.append(r3);	 Catch:{ all -> 0x01e7 }
        r0 = r0.getClass();	 Catch:{ all -> 0x01e7 }
        r2 = java.net.SocketTimeoutException.class;
        if (r0 != r2) goto L_0x01df;
    L_0x00fe:
        r0 = -6;
        r2 = "";
        r8.m13513a(r0, r2);	 Catch:{ all -> 0x01e7 }
    L_0x0104:
        if (r1 == 0) goto L_0x00a6;
    L_0x0106:
        r1.disconnect();	 Catch:{ Throwable -> 0x010a }
        goto L_0x00a6;
    L_0x010a:
        r0 = move-exception;
        goto L_0x00a6;
    L_0x010c:
        r0 = r8.c;	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r4 = "utf-8";
        r0 = r0.getBytes(r4);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        goto L_0x0059;
    L_0x0117:
        r3 = cn.com.xy.sms.sdk.p207c.C2917a.m13105a();	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r4 = "AESKEY";
        r3 = cn.com.xy.sms.sdk.p208d.p211c.C2947n.m13284d(r3, r4);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r4 = "xyvalue";
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r6 = "keyStr: ";
        r5.<init>(r6);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r5 = r5.append(r3);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r5 = r5.toString();	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r6 = 0;
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r4, r5, r6);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r4 = cn.com.xy.sms.sdk.p216h.p217a.C2989g.m13433a(r3);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r0 = cn.com.xy.sms.sdk.p216h.p217a.C2984b.m13418a(r0, r4);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        goto L_0x0063;
    L_0x0141:
        r0 = cn.com.xy.sms.sdk.p229l.C3055t.m13705a(r1);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r4 = r0.length;	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r5 = r8.c;	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        cn.com.xy.sms.sdk.p216h.C2997c.m13509a(r5, r4);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r4 = (long) r4;	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r6 = 26214400; // 0x1900000 float:5.2897246E-38 double:1.29516345E-316;
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 <= 0) goto L_0x0164;
    L_0x0153:
        r0 = -9;
        r1 = "";
        r8.m13513a(r0, r1);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        if (r2 == 0) goto L_0x00a6;
    L_0x015c:
        r2.disconnect();	 Catch:{ Throwable -> 0x0161 }
        goto L_0x00a6;
    L_0x0161:
        r0 = move-exception;
        goto L_0x00a6;
    L_0x0164:
        r4 = r8.f;	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        if (r4 == 0) goto L_0x018e;
    L_0x0168:
        r3 = f10154a;	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r0 = cn.com.xy.sms.sdk.p216h.p217a.C2989g.m13435b(r0, r3);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
    L_0x016e:
        r3 = r8.h;	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        if (r3 == 0) goto L_0x0176;
    L_0x0172:
        r0 = cn.com.xy.sms.sdk.p229l.C3049n.m13645a(r0);	 Catch:{ Throwable -> 0x0197, all -> 0x01b1 }
    L_0x0176:
        r3 = new java.lang.String;	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r4 = "UTF-8";
        r3.<init>(r0, r4);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r0 = 0;
        r8.m13513a(r0, r3);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        cn.com.xy.sms.sdk.p229l.C3055t.m13696a(r1);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
    L_0x0184:
        if (r2 == 0) goto L_0x00a6;
    L_0x0186:
        r2.disconnect();	 Catch:{ Throwable -> 0x018b }
        goto L_0x00a6;
    L_0x018b:
        r0 = move-exception;
        goto L_0x00a6;
    L_0x018e:
        r3 = cn.com.xy.sms.sdk.p216h.p217a.C2989g.m13433a(r3);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r0 = cn.com.xy.sms.sdk.p216h.p217a.C2984b.m13419b(r0, r3);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        goto L_0x016e;
    L_0x0197:
        r3 = move-exception;
        r4 = "XIAOYUAN";
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r6 = "NewXyHttpRunnable run";
        r5.<init>(r6);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r6 = r3.getLocalizedMessage();	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r5 = r5.append(r6);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r5 = r5.toString();	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r4, r5, r3);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        goto L_0x0176;
    L_0x01b1:
        r0 = move-exception;
    L_0x01b2:
        if (r2 == 0) goto L_0x01b7;
    L_0x01b4:
        r2.disconnect();	 Catch:{ Throwable -> 0x01ed }
    L_0x01b7:
        throw r0;
    L_0x01b8:
        r1 = 204; // 0xcc float:2.86E-43 double:1.01E-321;
        if (r0 != r1) goto L_0x01d8;
    L_0x01bc:
        r0 = "XY-ERR-CODE";
        r0 = r2.getHeaderField(r0);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        r1 = cn.com.xy.sms.sdk.p229l.C3049n.m13653e(r0);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        if (r1 != 0) goto L_0x0184;
    L_0x01c8:
        r1 = "token refresh";
        r8.m13516a(r0, r1);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        if (r2 == 0) goto L_0x00a6;
    L_0x01d0:
        r2.disconnect();	 Catch:{ Throwable -> 0x01d5 }
        goto L_0x00a6;
    L_0x01d5:
        r0 = move-exception;
        goto L_0x00a6;
    L_0x01d8:
        r0 = -8;
        r1 = "";
        r8.m13513a(r0, r1);	 Catch:{ Throwable -> 0x00cd, all -> 0x01b1 }
        goto L_0x0184;
    L_0x01df:
        r0 = -7;
        r2 = "";
        r8.m13513a(r0, r2);	 Catch:{ all -> 0x01e7 }
        goto L_0x0104;
    L_0x01e7:
        r0 = move-exception;
        r2 = r1;
        goto L_0x01b2;
    L_0x01ea:
        r0 = move-exception;
        goto L_0x00a6;
    L_0x01ed:
        r1 = move-exception;
        goto L_0x01b7;
    L_0x01ef:
        r0 = move-exception;
        r2 = r3;
        goto L_0x01b2;
    L_0x01f2:
        r0 = move-exception;
        r1 = r3;
        goto L_0x00cf;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.xy.sms.sdk.h.b.run():void");
    }
}
