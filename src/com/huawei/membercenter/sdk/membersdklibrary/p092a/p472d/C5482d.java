package com.huawei.membercenter.sdk.membersdklibrary.p092a.p472d;

import android.util.Log;

/* compiled from: LogUtil */
public class C5482d {
    private static boolean f19339a;
    private static boolean f19340b;
    private static boolean f19341c;
    private static boolean f19342d = true;
    private static boolean f19343e;
    private static boolean f19344f;

    static {
        boolean z = false;
        f19339a = false;
        f19340b = false;
        f19341c = false;
        f19343e = false;
        f19344f = false;
        f19339a = C5486h.m26199a("ro.config.hw_log", "false").equals("true");
        f19340b = C5486h.m26199a("ro.config.hw_module_log", "false").equals("true");
        f19341c = C5486h.m26206a("ro.debuggable", false);
        boolean z2 = f19339a || (f19340b && Log.isLoggable("HwMembercenterSDK", 3));
        f19344f = z2;
        if (f19341c || (f19340b && Log.isLoggable("HwMembercenterSDK", 4))) {
            z = true;
        }
        f19343e = z;
    }

    public static void m26183a(String str, String str2) {
        if (str != null && str2 != null && f19344f) {
            Log.d(str, str2);
        }
    }

    public static void m26184b(String str, String str2) {
        if (str != null && str2 != null && f19343e) {
            Log.i(str, str2);
        }
    }

    public static void m26185c(String str, String str2) {
        if (str != null && str2 != null && f19342d) {
            Log.w(str, str2);
        }
    }

    public static void m26186d(String str, String str2) {
        if (str != null && str2 != null && f19342d) {
            Log.e(str, str2);
        }
    }
}
