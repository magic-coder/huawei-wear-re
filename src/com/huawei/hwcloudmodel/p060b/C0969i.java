package com.huawei.hwcloudmodel.p060b;

import com.huawei.hwcloudmodel.b.a;
import com.huawei.hwcloudmodel.b.d;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.login.ui.login.C1093a;
import com.huawei.p190v.C2538c;

/* compiled from: VersionConfig */
public class C0969i {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m3482a(int r7) {
        /*
        r2 = 0;
        r1 = 1;
        r3 = com.huawei.hwcloudmodel.p060b.C0969i.m3481a();
        switch(r3) {
            case 0: goto L_0x003b;
            case 1: goto L_0x004f;
            case 2: goto L_0x0063;
            default: goto L_0x0009;
        };
    L_0x0009:
        r0 = r2;
    L_0x000a:
        r4 = "VersionConfig";
        r1 = new java.lang.Object[r1];
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "isFeatureSupport(): featureId = ";
        r5 = r5.append(r6);
        r5 = r5.append(r7);
        r6 = ",account =";
        r5 = r5.append(r6);
        r3 = r5.append(r3);
        r5 = ",isSupport =";
        r3 = r3.append(r5);
        r3 = r3.append(r0);
        r3 = r3.toString();
        r1[r2] = r3;
        com.huawei.p190v.C2538c.m12677c(r4, r1);
        return r0;
    L_0x003b:
        r0 = com.huawei.hwcloudmodel.b.a.a;
        r4 = java.lang.Integer.valueOf(r7);
        r0 = r0.get(r4);
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        if (r1 != r0) goto L_0x0009;
    L_0x004d:
        r0 = r1;
        goto L_0x000a;
    L_0x004f:
        r0 = com.huawei.hwcloudmodel.b.d.a;
        r4 = java.lang.Integer.valueOf(r7);
        r0 = r0.get(r4);
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        if (r1 != r0) goto L_0x0009;
    L_0x0061:
        r0 = r1;
        goto L_0x000a;
    L_0x0063:
        r0 = com.huawei.hwcloudmodel.b.g.a;
        r4 = java.lang.Integer.valueOf(r7);
        r0 = r0.get(r4);
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        if (r1 != r0) goto L_0x0009;
    L_0x0075:
        r0 = r1;
        goto L_0x000a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hwcloudmodel.b.i.a(int):boolean");
    }

    public static String m3483b(int i) {
        String str = "";
        switch (C0969i.m3481a()) {
            case 0:
                str = (String) a.b.get(Integer.valueOf(i));
                break;
            case 1:
                str = (String) d.b.get(Integer.valueOf(i));
                break;
        }
        C2538c.m12674b("VersionConfig", "getUrl(): urlId = " + i + ",url =" + str);
        return str;
    }

    public static int m3481a() {
        C2538c.m12677c("VersionConfig", "getAccountArea(): siteID = " + C1093a.m4739a(BaseApplication.m2632b()).m4752e());
        switch (C1093a.m4739a(BaseApplication.m2632b()).m4752e()) {
            case 1:
                return 0;
            case 7:
                return 1;
            default:
                return 2;
        }
    }
}
