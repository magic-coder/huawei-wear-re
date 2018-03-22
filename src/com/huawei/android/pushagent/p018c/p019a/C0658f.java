package com.huawei.android.pushagent.p018c.p019a;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.pushagent.c.a.a.f;
import java.util.Map.Entry;

public class C0658f {
    public static String m2525a(Context context, String str) {
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            try {
                str2 = f.b(context, new C0659h(context, "pclient_info_v2").m2540b(str));
            } catch (Throwable e) {
                C0657e.m2521c("PushLogSC2712", e.toString(), e);
            }
            if (TextUtils.isEmpty(str2)) {
                C0657e.m2512a("PushLogSC2712", "not exist for:" + str);
            }
        }
        return str2;
    }

    public static String m2526a(Context context, String str, String str2) {
        String str3 = "";
        if (!(TextUtils.isEmpty(str) || TextUtils.isEmpty(str2))) {
            try {
                str3 = f.b(context, new C0659h(context, str).m2540b(str2 + "_v2"));
            } catch (Throwable e) {
                C0657e.m2521c("PushLogSC2712", e.toString(), e);
            }
            if (TextUtils.isEmpty(str3)) {
                C0657e.m2512a("PushLogSC2712", "not exist for:" + str2);
            }
        }
        return str3;
    }

    public static boolean m2527a(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return new C0659h(context, str).m2539a(str2 + "_v2", f.a(context, str3));
    }

    public static void m2528b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            C0657e.m2522d("PushLogSC2712", "removeUnRegisterToken token is empty");
            return;
        }
        try {
            C0659h c0659h = new C0659h(context, "pclient_unRegist_info_v2");
            for (Entry key : c0659h.m2541b().entrySet()) {
                String str2 = (String) key.getKey();
                if (str.equals(f.b(context, str2))) {
                    c0659h.m2546f(str2);
                    return;
                }
            }
        } catch (Throwable e) {
            C0657e.m2521c("PushLogSC2712", e.toString(), e);
        }
    }

    public static boolean m2529b(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new C0659h(context, "pclient_info_v2").m2539a(str, f.a(context, str2));
    }

    public static boolean m2530c(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return new C0659h(context, "pclient_unRegist_info_v2").m2539a(f.a(context, str), str2);
    }
}
