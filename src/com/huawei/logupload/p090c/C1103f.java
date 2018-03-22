package com.huawei.logupload.p090c;

import android.util.Log;

/* compiled from: LogUtil */
public class C1103f {
    public static boolean m4877a(int i) {
        return i >= 6;
    }

    public static int m4876a(String str, String str2) {
        return Log.v(str, str2);
    }

    public static int m4878b(String str, String str2) {
        return Log.d(str, str2);
    }

    public static int m4879c(String str, String str2) {
        return Log.i(str, str2);
    }

    public static int m4880d(String str, String str2) {
        return Log.e(str, str2);
    }

    public static void m4881e(String str, String str2) {
        if (C1103f.m4877a(4)) {
            Log.e(str, str2);
        }
    }
}
