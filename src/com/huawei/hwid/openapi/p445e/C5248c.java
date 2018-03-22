package com.huawei.hwid.openapi.p445e;

import android.content.Context;
import android.util.Log;

public class C5248c {
    private static String f18881a = "hwid_opensdk";
    private static String f18882b = "";

    public static String m25442a(Throwable th) {
        return Log.getStackTraceString(th);
    }

    private static synchronized void m25443a(int i, String str, String str2, Throwable th, int i2) {
        synchronized (C5248c.class) {
            if (Log.isLoggable(f18881a, i)) {
                String stringBuffer = new StringBuffer().append("[").append(1007).append("|").append(Thread.currentThread().getName()).append("-").append(Thread.currentThread().getId()).append("]:").append(str2).toString();
                StackTraceElement[] stackTrace = new Throwable().getStackTrace();
                stringBuffer = stackTrace.length > i2 ? stringBuffer + new StringBuffer().append("(").append(f18882b).append("/").append(stackTrace[i2].getFileName()).append(":").append(stackTrace[i2].getLineNumber()).append(")").toString() : stringBuffer + new StringBuffer().append("(").append(f18882b).append("/unknown source)").toString();
                if (th != null) {
                    stringBuffer = stringBuffer + '\n' + C5248c.m25442a(th);
                }
                Log.println(i, str, stringBuffer);
            }
        }
    }

    public static void m25444a(Context context) {
        String packageName = context.getPackageName();
        if (packageName != null) {
            String[] split = packageName.split("\\.");
            if (split != null && split.length > 0) {
                f18882b = split[split.length - 1];
            }
        }
    }

    public static void m25445a(String str, String str2) {
        C5248c.m25443a(3, str, str2, null, 2);
    }

    public static void m25446a(String str, String str2, Throwable th) {
        C5248c.m25443a(3, str, str2, th, 2);
    }

    public static void m25447b(String str, String str2) {
        C5248c.m25443a(4, str, str2, null, 2);
    }

    public static void m25448b(String str, String str2, Throwable th) {
        C5248c.m25443a(6, str, str2, th, 2);
    }

    public static void m25449c(String str, String str2) {
        C5248c.m25443a(5, str, str2, null, 2);
    }

    public static void m25450d(String str, String str2) {
        C5248c.m25443a(6, str, str2, null, 2);
    }

    public static void m25451e(String str, String str2) {
        C5248c.m25443a(2, str, str2, null, 2);
    }
}
