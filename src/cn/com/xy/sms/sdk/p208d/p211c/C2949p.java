package cn.com.xy.sms.sdk.p208d.p211c;

import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p208d.C2962e;
import cn.com.xy.sms.sdk.p208d.p210b.C2921a;
import cn.com.xy.sms.sdk.p229l.C3049n;
import java.util.HashMap;

public final class C2949p {
    public static long m13285a(HashMap<String, String> hashMap) {
        Throwable th;
        C2962e c2962e = null;
        C2962e c2962e2;
        try {
            if (C3049n.m13653e((String) hashMap.get("titleNo"))) {
                c2962e2 = null;
            } else {
                c2962e2 = C2922b.m13139a("tb_count_scene", new String[]{"scene_id", "count"}, "scene_id = ? ", new String[]{(String) hashMap.get("titleNo")});
            }
            if (c2962e2 != null) {
                try {
                    if (c2962e2.m13323a() > 0) {
                        c2962e2.m13327b();
                        int a = c2962e2.m13324a(c2962e2.m13325a("count")) + 1;
                        String str = "tb_count_scene";
                        String[] strArr = new String[]{r0};
                        C2922b.m13133a(str, C2921a.m13130a(null, "scene_id", r0, "count", String.valueOf(a)), "scene_id = ? ", strArr);
                        C2962e.m13322a(c2962e2, true);
                        return 0;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    C2962e.m13322a(c2962e2, true);
                    throw th;
                }
            }
            String str2 = "tb_count_scene";
            long a2 = C2922b.m13135a(str2, C2921a.m13130a(null, "scene_id", r0, "count", "1"));
            C2962e.m13322a(c2962e2, true);
            return a2;
        } catch (Throwable th3) {
            th = th3;
            c2962e2 = null;
            C2962e.m13322a(c2962e2, true);
            throw th;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<cn.com.xy.sms.sdk.p208d.p211c.af> m13286a() {
        /*
        r1 = 0;
        r6 = 1;
        r2 = new java.util.ArrayList;
        r2.<init>();
        r0 = "tb_count_scene";
        r3 = 2;
        r3 = new java.lang.String[r3];	 Catch:{ Throwable -> 0x0052 }
        r4 = 0;
        r5 = "scene_id";
        r3[r4] = r5;	 Catch:{ Throwable -> 0x0052 }
        r4 = 1;
        r5 = "count";
        r3[r4] = r5;	 Catch:{ Throwable -> 0x0052 }
        r4 = 0;
        r5 = 0;
        r1 = cn.com.xy.sms.sdk.p208d.C2922b.m13139a(r0, r3, r4, r5);	 Catch:{ Throwable -> 0x0052 }
        if (r1 == 0) goto L_0x0039;
    L_0x0020:
        r0 = r1.m13323a();	 Catch:{ Throwable -> 0x0052 }
        if (r0 <= 0) goto L_0x0039;
    L_0x0026:
        r0 = "scene_id";
        r0 = r1.m13325a(r0);	 Catch:{ Throwable -> 0x0052 }
        r3 = "count";
        r3 = r1.m13325a(r3);	 Catch:{ Throwable -> 0x0052 }
    L_0x0033:
        r4 = r1.m13327b();	 Catch:{ Throwable -> 0x0052 }
        if (r4 != 0) goto L_0x003d;
    L_0x0039:
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r1, r6);
    L_0x003c:
        return r2;
    L_0x003d:
        r4 = new cn.com.xy.sms.sdk.d.c.af;	 Catch:{ Throwable -> 0x0052 }
        r4.<init>();	 Catch:{ Throwable -> 0x0052 }
        r5 = r1.m13328c(r0);	 Catch:{ Throwable -> 0x0052 }
        r4.f9952a = r5;	 Catch:{ Throwable -> 0x0052 }
        r5 = r1.m13324a(r3);	 Catch:{ Throwable -> 0x0052 }
        r4.f9954c = r5;	 Catch:{ Throwable -> 0x0052 }
        r2.add(r4);	 Catch:{ Throwable -> 0x0052 }
        goto L_0x0033;
    L_0x0052:
        r0 = move-exception;
        r3 = "XIAOYUAN";
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x006f }
        r5 = "queryAllSceneconfig: ";
        r4.<init>(r5);	 Catch:{ all -> 0x006f }
        r5 = r0.getMessage();	 Catch:{ all -> 0x006f }
        r4 = r4.append(r5);	 Catch:{ all -> 0x006f }
        r4 = r4.toString();	 Catch:{ all -> 0x006f }
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r3, r4, r0);	 Catch:{ all -> 0x006f }
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r1, r6);
        goto L_0x003c;
    L_0x006f:
        r0 = move-exception;
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r1, r6);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.xy.sms.sdk.d.c.p.a():java.util.List<cn.com.xy.sms.sdk.d.c.af>");
    }
}
