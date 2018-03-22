package com.huawei.multisimsdk.multidevicemanager.p104c;

import android.content.Context;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1183h;
import com.huawei.multisimsdk.p099b.p100a.C1128a;
import com.huawei.multisimsdk.p099b.p101b.C1129a;

/* compiled from: CardPartManager */
public class C1135b {
    private static final String f2401a = C1135b.class.getSimpleName();
    private static Context f2402b;

    static void m5057a(Context context) {
        if (context != null) {
            f2402b = context.getApplicationContext();
        }
    }

    public static String m5056a(String str, String str2) {
        String b;
        if ("MSISDN".equals(str)) {
            b = C1136c.m5058a().m5062b(f2402b, str2);
        } else {
            b = null;
        }
        if (b == null) {
            C1183h.m5282b(f2401a, "simOperator is null");
            return null;
        }
        C1128a a = C1129a.m5029a(f2402b, b);
        if (a != null) {
            return a.m5023a();
        }
        return null;
    }

    static int m5055a(Context context, int i) {
        return 300000;
    }
}
