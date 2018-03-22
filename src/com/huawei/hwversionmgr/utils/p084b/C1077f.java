package com.huawei.hwversionmgr.utils.p084b;

import android.content.Context;
import com.huawei.hwversionmgr.p079a.C1068c;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.component.GameManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AppStatusReportThread */
public class C1077f implements Runnable {
    private C1068c f2162a = null;

    public C1077f(Context context, C1068c c1068c) {
        this.f2162a = c1068c;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r10 = this;
        r8 = 1;
        r7 = 0;
        r0 = 0;
        r0 = r10.m4555a();	 Catch:{ IOException -> 0x0042, RuntimeException -> 0x0063, JSONException -> 0x0084, all -> 0x00a5 }
        if (r0 == 0) goto L_0x002f;
    L_0x0009:
        r1 = com.huawei.hwversionmgr.utils.C1078c.m4567b();	 Catch:{ IOException -> 0x0042, RuntimeException -> 0x0063, JSONException -> 0x0084 }
        r1 = com.huawei.hwversionmgr.utils.a.a(r1, r0);	 Catch:{ IOException -> 0x0042, RuntimeException -> 0x0063, JSONException -> 0x0084 }
        r2 = "AppStatusReportThread";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ IOException -> 0x0042, RuntimeException -> 0x0063, JSONException -> 0x0084 }
        r4 = 0;
        r5 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0042, RuntimeException -> 0x0063, JSONException -> 0x0084 }
        r5.<init>();	 Catch:{ IOException -> 0x0042, RuntimeException -> 0x0063, JSONException -> 0x0084 }
        r6 = "statusCode = ";
        r5 = r5.append(r6);	 Catch:{ IOException -> 0x0042, RuntimeException -> 0x0063, JSONException -> 0x0084 }
        r1 = r5.append(r1);	 Catch:{ IOException -> 0x0042, RuntimeException -> 0x0063, JSONException -> 0x0084 }
        r1 = r1.toString();	 Catch:{ IOException -> 0x0042, RuntimeException -> 0x0063, JSONException -> 0x0084 }
        r3[r4] = r1;	 Catch:{ IOException -> 0x0042, RuntimeException -> 0x0063, JSONException -> 0x0084 }
        com.huawei.p190v.C2538c.m12677c(r2, r3);	 Catch:{ IOException -> 0x0042, RuntimeException -> 0x0063, JSONException -> 0x0084 }
    L_0x002f:
        if (r0 == 0) goto L_0x0034;
    L_0x0031:
        r0.close();	 Catch:{ IOException -> 0x0035 }
    L_0x0034:
        return;
    L_0x0035:
        r0 = move-exception;
        r0 = "AppStatusReportThread";
        r1 = new java.lang.Object[r8];
        r2 = "finally JSONException ";
        r1[r7] = r2;
        com.huawei.p190v.C2538c.m12677c(r0, r1);
        goto L_0x0034;
    L_0x0042:
        r1 = move-exception;
        r1 = "AppStatusReportThread";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x00bc }
        r3 = 0;
        r4 = "IOException ";
        r2[r3] = r4;	 Catch:{ all -> 0x00bc }
        com.huawei.p190v.C2538c.m12677c(r1, r2);	 Catch:{ all -> 0x00bc }
        if (r0 == 0) goto L_0x0034;
    L_0x0052:
        r0.close();	 Catch:{ IOException -> 0x0056 }
        goto L_0x0034;
    L_0x0056:
        r0 = move-exception;
        r0 = "AppStatusReportThread";
        r1 = new java.lang.Object[r8];
        r2 = "finally JSONException ";
        r1[r7] = r2;
        com.huawei.p190v.C2538c.m12677c(r0, r1);
        goto L_0x0034;
    L_0x0063:
        r1 = move-exception;
        r1 = "AppStatusReportThread";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x00bc }
        r3 = 0;
        r4 = "RuntimeException ";
        r2[r3] = r4;	 Catch:{ all -> 0x00bc }
        com.huawei.p190v.C2538c.m12677c(r1, r2);	 Catch:{ all -> 0x00bc }
        if (r0 == 0) goto L_0x0034;
    L_0x0073:
        r0.close();	 Catch:{ IOException -> 0x0077 }
        goto L_0x0034;
    L_0x0077:
        r0 = move-exception;
        r0 = "AppStatusReportThread";
        r1 = new java.lang.Object[r8];
        r2 = "finally JSONException ";
        r1[r7] = r2;
        com.huawei.p190v.C2538c.m12677c(r0, r1);
        goto L_0x0034;
    L_0x0084:
        r1 = move-exception;
        r1 = "AppStatusReportThread";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x00bc }
        r3 = 0;
        r4 = "JSONException ";
        r2[r3] = r4;	 Catch:{ all -> 0x00bc }
        com.huawei.p190v.C2538c.m12677c(r1, r2);	 Catch:{ all -> 0x00bc }
        if (r0 == 0) goto L_0x0034;
    L_0x0094:
        r0.close();	 Catch:{ IOException -> 0x0098 }
        goto L_0x0034;
    L_0x0098:
        r0 = move-exception;
        r0 = "AppStatusReportThread";
        r1 = new java.lang.Object[r8];
        r2 = "finally JSONException ";
        r1[r7] = r2;
        com.huawei.p190v.C2538c.m12677c(r0, r1);
        goto L_0x0034;
    L_0x00a5:
        r1 = move-exception;
        r9 = r1;
        r1 = r0;
        r0 = r9;
    L_0x00a9:
        if (r1 == 0) goto L_0x00ae;
    L_0x00ab:
        r1.close();	 Catch:{ IOException -> 0x00af }
    L_0x00ae:
        throw r0;
    L_0x00af:
        r1 = move-exception;
        r1 = "AppStatusReportThread";
        r2 = new java.lang.Object[r8];
        r3 = "finally JSONException ";
        r2[r7] = r3;
        com.huawei.p190v.C2538c.m12677c(r1, r2);
        goto L_0x00ae;
    L_0x00bc:
        r1 = move-exception;
        r9 = r1;
        r1 = r0;
        r0 = r9;
        goto L_0x00a9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hwversionmgr.utils.b.f.run():void");
    }

    public OutputStream m4555a() throws IOException, JSONException {
        C2538c.m12674b("AppStatusReportThread", "convertUpdateLogXMLToStream JSON begin");
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (this.f2162a == null) {
            C2538c.m12680e("AppStatusReportThread", "appStatusReportInfo is null");
            return null;
        }
        jSONObject.put("operateType", String.valueOf(this.f2162a.f2123a));
        jSONObject2.put("IMEI", this.f2162a.f2124b);
        jSONObject2.put("versionID", this.f2162a.f2125c);
        jSONObject2.put("clientversion", this.f2162a.f2126d);
        jSONObject2.put("descinfo", this.f2162a.f2127e);
        jSONObject.putOpt("updateLog", jSONObject2);
        byteArrayOutputStream.write(jSONObject.toString().getBytes(GameManager.DEFAULT_CHARSET));
        byteArrayOutputStream.flush();
        return byteArrayOutputStream;
    }
}
