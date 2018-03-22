package cn.com.xy.sms.sdk.p216h.p217a;

import android.database.sqlite.SQLiteDatabase;
import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p208d.p211c.C2944k;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p229l.C3049n;

public final class C2988f {
    private static void m13429a(C2986d c2986d) {
        String[] c = c2986d.m13426c();
        if (c != null && c.length > 0) {
            for (String str : c) {
                if (!C3049n.m13653e(str)) {
                    C2944k.m13267a(str, System.currentTimeMillis());
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m13430a(java.lang.String r5) {
        /*
        r0 = cn.com.xy.sms.sdk.p216h.p217a.C2983a.m13417a(r5);	 Catch:{ Throwable -> 0x0057 }
        r1 = r0.iterator();	 Catch:{ Throwable -> 0x0057 }
    L_0x0008:
        r0 = r1.hasNext();	 Catch:{ Throwable -> 0x0057 }
        if (r0 != 0) goto L_0x000f;
    L_0x000e:
        return;
    L_0x000f:
        r0 = r1.next();	 Catch:{ Throwable -> 0x0057 }
        r0 = (cn.com.xy.sms.sdk.p216h.p217a.C2986d) r0;	 Catch:{ Throwable -> 0x0057 }
        if (r0 == 0) goto L_0x0008;
    L_0x0017:
        r2 = r0.m13424a();	 Catch:{ Throwable -> 0x003d }
        switch(r2) {
            case 0: goto L_0x0008;
            case 1: goto L_0x0008;
            case 2: goto L_0x0008;
            case 3: goto L_0x0008;
            case 4: goto L_0x0008;
            case 5: goto L_0x001f;
            case 6: goto L_0x008b;
            case 7: goto L_0x0008;
            case 8: goto L_0x0008;
            case 9: goto L_0x0008;
            case 10: goto L_0x0090;
            case 11: goto L_0x0095;
            default: goto L_0x001e;
        };	 Catch:{ Throwable -> 0x003d }
    L_0x001e:
        goto L_0x0008;
    L_0x001f:
        cn.com.xy.sms.sdk.p208d.p211c.p212a.C2928f.m13187b();	 Catch:{ Throwable -> 0x003d }
        r2 = cn.com.xy.sms.sdk.p207c.C2917a.m13105a();	 Catch:{ Throwable -> 0x003d }
        r2 = cn.com.xy.sms.sdk.p208d.p211c.C2943j.m13258a(r2);	 Catch:{ Throwable -> 0x003d }
        r0 = r0.m13426c();	 Catch:{ Throwable -> 0x003d }
        if (r2 == 0) goto L_0x0079;
    L_0x0030:
        if (r0 == 0) goto L_0x0071;
    L_0x0032:
        r3 = r0.length;	 Catch:{ Throwable -> 0x003d }
        if (r3 <= 0) goto L_0x0071;
    L_0x0035:
        r3 = r2.f9987i;	 Catch:{ Throwable -> 0x003d }
        r2 = r2.f9980b;	 Catch:{ Throwable -> 0x003d }
        cn.com.xy.sms.sdk.p220j.p224d.C3030f.m13575a(r0);	 Catch:{ Throwable -> 0x003d }
        goto L_0x0008;
    L_0x003d:
        r0 = move-exception;
        r2 = "XIAOYUAN";
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0057 }
        r4 = "EmergencyActionUtil doNoWait";
        r3.<init>(r4);	 Catch:{ Throwable -> 0x0057 }
        r4 = r0.getMessage();	 Catch:{ Throwable -> 0x0057 }
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x0057 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x0057 }
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r2, r3, r0);	 Catch:{ Throwable -> 0x0057 }
        goto L_0x0008;
    L_0x0057:
        r0 = move-exception;
        r1 = "XIAOYUAN";
        r2 = new java.lang.StringBuilder;
        r3 = "EmergencyActionUtil doEmAction";
        r2.<init>(r3);
        r3 = r0.getMessage();
        r2 = r2.append(r3);
        r2 = r2.toString();
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r1, r2, r0);
        goto L_0x000e;
    L_0x0071:
        r0 = r2.f9987i;	 Catch:{ Throwable -> 0x003d }
        r2 = r2.f9980b;	 Catch:{ Throwable -> 0x003d }
        cn.com.xy.sms.sdk.p220j.p224d.C3030f.m13576b(r0, r2);	 Catch:{ Throwable -> 0x003d }
        goto L_0x0008;
    L_0x0079:
        if (r0 == 0) goto L_0x0082;
    L_0x007b:
        r2 = r0.length;	 Catch:{ Throwable -> 0x003d }
        if (r2 <= 0) goto L_0x0082;
    L_0x007e:
        cn.com.xy.sms.sdk.p220j.p224d.C3030f.m13575a(r0);	 Catch:{ Throwable -> 0x003d }
        goto L_0x0008;
    L_0x0082:
        r0 = "";
        r2 = "";
        cn.com.xy.sms.sdk.p220j.p224d.C3030f.m13576b(r0, r2);	 Catch:{ Throwable -> 0x003d }
        goto L_0x0008;
    L_0x008b:
        cn.com.xy.sms.sdk.p229l.C3048m.m13631a();	 Catch:{ Throwable -> 0x003d }
        goto L_0x0008;
    L_0x0090:
        cn.com.xy.sms.sdk.p216h.p217a.C2988f.m13429a(r0);	 Catch:{ Throwable -> 0x003d }
        goto L_0x0008;
    L_0x0095:
        cn.com.xy.sms.sdk.p216h.p217a.C2988f.m13431b(r0);	 Catch:{ Throwable -> 0x003d }
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.xy.sms.sdk.h.a.f.a(java.lang.String):void");
    }

    private static void m13431b(C2986d c2986d) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            String b = c2986d.m13425b();
            sQLiteDatabase = C2922b.m13136a();
            sQLiteDatabase.execSQL(b);
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "executeCmd11: " + th.getMessage(), th);
        } finally {
            C2922b.m13143a(sQLiteDatabase);
        }
    }
}
