package com.p230a.p231b.p232b.p233a;

import android.util.Log;
import java.util.Locale;

public class C3121x {
    public static String f10469a = "Volley";
    public static boolean f10470b = false;

    public static void m13905a(String str, Object... objArr) {
        if (f10470b) {
            Log.v(f10469a, C3121x.m13909d(str, objArr));
        }
    }

    public static void m13906a(Throwable th, String str, Object... objArr) {
        Log.e(f10469a, C3121x.m13909d(str, objArr), th);
    }

    public static void m13907b(String str, Object... objArr) {
        Log.d(f10469a, C3121x.m13909d(str, objArr));
    }

    public static void m13908c(String str, Object... objArr) {
        Log.e(f10469a, C3121x.m13909d(str, objArr));
    }

    private static String m13909d(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        String str3 = "<unknown>";
        for (int i = 2; i < stackTrace.length; i++) {
            if (!stackTrace[i].getClass().equals(C3121x.class)) {
                str3 = stackTrace[i].getClassName();
                str3 = str3.substring(str3.lastIndexOf(46) + 1);
                str2 = str3.substring(str3.lastIndexOf(36) + 1) + "." + stackTrace[i].getMethodName();
                break;
            }
        }
        str2 = str3;
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str2, str});
    }
}
