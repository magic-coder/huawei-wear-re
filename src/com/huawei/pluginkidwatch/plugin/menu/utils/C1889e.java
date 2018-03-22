package com.huawei.pluginkidwatch.plugin.menu.utils;

import android.os.Handler;

/* compiled from: CommonUtil */
public class C1889e {
    private static boolean f6213a = true;

    public static void m9655a(boolean z) {
        f6213a = z;
        if (!z) {
            new Handler().postDelayed(new C1890f(), 500);
        }
    }

    public static boolean m9656a() {
        return f6213a;
    }

    public static boolean m9657a(String str) {
        if (str == null || "".equals(str)) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                return false;
            }
        }
        return true;
    }
}
