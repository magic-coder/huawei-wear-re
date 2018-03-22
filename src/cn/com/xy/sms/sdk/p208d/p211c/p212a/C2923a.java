package cn.com.xy.sms.sdk.p208d.p211c.p212a;

import android.content.ContentValues;
import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p208d.C2962e;
import cn.com.xy.sms.sdk.p208d.p211c.C2948o;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p229l.C3049n;
import java.util.HashMap;
import java.util.Map;

public final class C2923a {
    private static final Map<String, C2948o> f9914a = new HashMap();

    public static C2948o m13153a(String str) {
        return (C2948o) f9914a.get(str);
    }

    public static void m13154a(String str, C2948o c2948o) {
        f9914a.put(str, c2948o);
    }

    public static boolean m13155a(C2948o c2948o) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("cnum", c2948o.f10011b);
            if (!C3049n.m13653e(c2948o.f10012c)) {
                contentValues.put("areaCode", c2948o.f10012c);
            }
            if (!C3049n.m13653e(c2948o.f10014e)) {
                contentValues.put("city", c2948o.f10014e);
            }
            if (!C3049n.m13653e(c2948o.f10015f)) {
                contentValues.put("operator", c2948o.f10015f);
            }
            contentValues.put("checkTime", Long.valueOf(c2948o.f10016g));
            long a = (long) C2922b.m13133a("tb_centernum_location_info", contentValues, "cnum = ?", new String[]{String.valueOf(c2948o.f10011b)});
            if (a < 1) {
                a = C2922b.m13135a("tb_centernum_location_info", contentValues);
            }
            return a > 0;
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "saveCNumLocationInfo: " + th.getMessage(), th);
            return false;
        }
    }

    public static C2948o m13156b(String str) {
        C2962e a;
        Throwable th;
        Throwable th2;
        C2948o c2948o = null;
        try {
            a = C2922b.m13139a("tb_centernum_location_info", new String[]{"cnum", "areaCode", "city", "operator", "checkTime"}, "cnum = ? ", new String[]{new StringBuilder(String.valueOf(C3049n.m13641a(str))).toString()});
            if (a != null) {
                try {
                    if (a.m13323a() > 0) {
                        int a2 = a.m13325a("areaCode");
                        int a3 = a.m13325a("city");
                        int a4 = a.m13325a("operator");
                        int a5 = a.m13325a("checkTime");
                        while (a.m13327b()) {
                            C2948o c2948o2 = new C2948o();
                            try {
                                c2948o2.f10011b = r3;
                                c2948o2.f10012c = a.m13328c(a2);
                                c2948o2.f10014e = a.m13328c(a3);
                                c2948o2.f10015f = a.m13328c(a4);
                                c2948o2.f10016g = a.m13326b(a5);
                                c2948o = c2948o2;
                            } catch (Throwable th3) {
                                Throwable th4 = th3;
                                c2948o = c2948o2;
                                th2 = th4;
                            }
                        }
                    }
                } catch (Throwable th5) {
                    th2 = th5;
                }
            }
            C2962e.m13322a(a, true);
        } catch (Throwable th22) {
            a = null;
            th3 = th22;
            C2962e.m13322a(a, true);
            throw th3;
        }
        return c2948o;
    }
}
