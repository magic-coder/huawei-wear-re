package com.huawei.multisimsdk.multidevicemanager.p105e;

import android.util.Log;

/* compiled from: LogUtils */
public class C1183h {
    public static final Boolean f2599a = Boolean.valueOf(false);

    public static int m5278a(String str, String str2) {
        return C1183h.m5279a(str, str2, false);
    }

    public static int m5279a(String str, String str2, boolean z) {
        return Log.d("HwMultiSIM", C1183h.m5288e(str, str2, z));
    }

    public static int m5282b(String str, String str2) {
        return C1183h.m5283b(str, str2, false);
    }

    public static int m5283b(String str, String str2, boolean z) {
        return Log.i("HwMultiSIM", C1183h.m5288e(str, str2, z));
    }

    public static int m5284c(String str, String str2) {
        return C1183h.m5285c(str, str2, false);
    }

    public static int m5285c(String str, String str2, boolean z) {
        return Log.w("HwMultiSIM", C1183h.m5288e(str, str2, z));
    }

    public static int m5286d(String str, String str2) {
        return C1183h.m5287d(str, str2, false);
    }

    public static int m5287d(String str, String str2, boolean z) {
        return Log.e("HwMultiSIM", C1183h.m5288e(str, str2, z));
    }

    private static String m5288e(String str, String str2, boolean z) {
        String str3 = "";
        if (z) {
            str3 = C1183h.m5281a() + "->";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("->");
        stringBuilder.append(str3);
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }

    private static String m5281a() {
        return "thread id = " + Thread.currentThread().getId();
    }

    public static int m5280a(String str, String str2, Object... objArr) {
        return Log.i("HwMultiSIM", C1183h.m5288e(str, String.format(str2, objArr), false));
    }
}
