package com.huawei.android.pushagent.p018c.p019a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hwid.core.constants.HwAccountConstants;

public class C0657e {
    private static String f1186a = "";
    private static String f1187b = "hwpush";
    private static String f1188c = "PushLog";
    private static C0657e f1189d = null;

    private C0657e() {
    }

    public static synchronized C0657e m2508a() {
        C0657e c0657e;
        synchronized (C0657e.class) {
            if (f1189d == null) {
                f1189d = new C0657e();
            }
            c0657e = f1189d;
        }
        return c0657e;
    }

    public static String m2509a(Throwable th) {
        return Log.getStackTraceString(th);
    }

    private synchronized void m2510a(int i, String str, String str2, Throwable th, int i2) {
        try {
            if (C0657e.m2515a(i)) {
                String str3 = "[" + Thread.currentThread().getName() + "-" + Thread.currentThread().getId() + "]" + str2;
                StackTraceElement[] stackTrace = new Throwable().getStackTrace();
                str3 = stackTrace.length > i2 ? str3 + "(" + f1186a + "/" + stackTrace[i2].getFileName() + ":" + stackTrace[i2].getLineNumber() + ")" : str3 + "(" + f1186a + "/unknown source)";
                if (th != null) {
                    str3 = str3 + '\n' + C0657e.m2509a(th);
                }
                Log.println(i, f1188c, str3);
            }
        } catch (Throwable e) {
            Log.e("PushLogSC2712", "call writeLog cause:" + e.toString(), e);
        }
    }

    public static synchronized void m2511a(Context context) {
        synchronized (C0657e.class) {
            if (f1189d == null) {
                C0657e.m2508a();
            }
            if (TextUtils.isEmpty(f1186a)) {
                String packageName = context.getPackageName();
                if (packageName != null) {
                    String[] split = packageName.split("\\.");
                    if (split.length > 0) {
                        f1186a = split[split.length - 1];
                    }
                }
                f1188c = C0657e.m2516b(context);
            }
        }
    }

    public static void m2512a(String str, String str2) {
        C0657e.m2508a().m2510a(3, str, str2, null, 2);
    }

    public static void m2513a(String str, String str2, Throwable th) {
        C0657e.m2508a().m2510a(3, str, str2, th, 2);
    }

    public static void m2514a(String str, String str2, Object... objArr) {
        try {
            C0657e.m2508a().m2510a(3, str, String.format(str2, objArr), null, 2);
        } catch (Throwable e) {
            Log.e("PushLogSC2712", "call writeLog cause:" + e.toString(), e);
        }
    }

    private static boolean m2515a(int i) {
        return Log.isLoggable(f1187b, i);
    }

    public static String m2516b(Context context) {
        String str = "PushLogSC2712";
        return context == null ? str : "com.huawei.android.pushagent".equals(context.getPackageName()) ? str.replace("SC", "AC") : "android".equals(context.getPackageName()) ? str.replace("SC", "") : !TextUtils.isEmpty(f1186a) ? str + HwAccountConstants.SPLIIT_UNDERLINE + f1186a : str;
    }

    public static void m2517b(String str, String str2) {
        C0657e.m2508a().m2510a(4, str, str2, null, 2);
    }

    public static void m2518b(String str, String str2, Throwable th) {
        C0657e.m2508a().m2510a(4, str, str2, th, 2);
    }

    public static void m2519b(String str, String str2, Object... objArr) {
        try {
            C0657e.m2508a().m2510a(2, str, String.format(str2, objArr), null, 2);
        } catch (Throwable e) {
            Log.e("PushLogSC2712", "call writeLog cause:" + e.toString(), e);
        }
    }

    public static void m2520c(String str, String str2) {
        C0657e.m2508a().m2510a(5, str, str2, null, 2);
    }

    public static void m2521c(String str, String str2, Throwable th) {
        C0657e.m2508a().m2510a(6, str, str2, th, 2);
    }

    public static void m2522d(String str, String str2) {
        C0657e.m2508a().m2510a(6, str, str2, null, 2);
    }

    public static void m2523d(String str, String str2, Throwable th) {
        C0657e.m2508a().m2510a(2, str, str2, th, 2);
    }

    public static void m2524e(String str, String str2) {
        C0657e.m2508a().m2510a(2, str, str2, null, 2);
    }
}
