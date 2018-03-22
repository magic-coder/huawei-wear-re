package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.p545b.C6452b;
import com.tencent.stat.p545b.C6463m;

public class C6471d {
    private static C6452b f22478a = C6463m.m29449b();
    private static C6449a f22479b = null;

    static C6449a m29539a(C6449a c6449a, C6449a c6449a2) {
        return (c6449a == null || c6449a2 == null) ? c6449a == null ? c6449a2 != null ? c6449a2 : null : c6449a : c6449a.m29381a(c6449a2) >= 0 ? c6449a : c6449a2;
    }

    static C6449a m29540a(C6449a c6449a, C6449a c6449a2, C6449a c6449a3) {
        return C6471d.m29539a(C6471d.m29539a(c6449a, c6449a2), C6471d.m29539a(c6449a2, c6449a3));
    }

    private static C6449a m29541a(String str) {
        return str != null ? C6449a.m29379a(C6463m.m29457d(str)) : null;
    }

    public static String m29542a(Context context) {
        if (f22479b == null) {
            C6471d.m29544b(context);
        }
        return f22479b.m29389d();
    }

    public static void m29543a(Context context, String str) {
        try {
            C6471d.m29544b(context);
            f22479b.m29388c(str);
            f22479b.m29382a(f22479b.m29380a() + 1);
            f22479b.m29383a(System.currentTimeMillis());
            String jSONObject = f22479b.m29387c().toString();
            f22478a.m29413h("save DeviceInfo:" + jSONObject);
            jSONObject = C6463m.m29454c(jSONObject).replace("\n", "");
            C6475h a = C6475h.m29567a(context);
            a.m29573c("__MTA_DEVICE_INFO__", jSONObject);
            a.m29575e("__MTA_DEVICE_INFO__", jSONObject);
            a.m29571a("__MTA_DEVICE_INFO__", jSONObject);
        } catch (Throwable th) {
            f22478a.m29411f(th);
        }
    }

    public static C6449a m29544b(Context context) {
        if (context == null) {
            f22478a.m29410e("Context for StatConfig.getDeviceInfo is null.");
            return null;
        }
        if (f22479b == null) {
            C6471d.m29545c(context);
        }
        return f22479b;
    }

    static synchronized C6449a m29545c(Context context) {
        C6449a a;
        synchronized (C6471d.class) {
            try {
                C6475h a2 = C6475h.m29567a(context);
                C6449a a3 = C6471d.m29541a(a2.m29574d("__MTA_DEVICE_INFO__", null));
                f22478a.m29413h("get device info from internal storage:" + a3);
                C6449a a4 = C6471d.m29541a(a2.m29576f("__MTA_DEVICE_INFO__", null));
                f22478a.m29413h("get device info from setting.system:" + a4);
                a = C6471d.m29541a(a2.m29572b("__MTA_DEVICE_INFO__", null));
                f22478a.m29413h("get device info from SharedPreference:" + a);
                f22479b = C6471d.m29540a(a, a4, a3);
                if (f22479b == null) {
                    f22479b = new C6449a();
                }
                a = C6487u.m29594a(context).m29618b(context);
                if (a != null) {
                    f22479b.m29390d(a.m29391e());
                    f22479b.m29392e(a.m29393f());
                    f22479b.m29385b(a.m29394g());
                }
            } catch (Throwable th) {
                f22478a.m29411f(th);
            }
            a = f22479b;
        }
        return a;
    }
}
