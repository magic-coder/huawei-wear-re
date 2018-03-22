package com.huawei.pluginkidwatch.common.lib.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/* compiled from: K1SharedPreferencesUtil */
public class C1491k {
    private static SharedPreferences f3463a;
    private static Editor f3464b;

    private static void m6894a(Context context) {
        f3463a = context.getSharedPreferences("k1sharedPreferences", 0);
        f3464b = f3463a.edit();
    }

    public static void m6897a(Context context, String str, String str2) {
        synchronized (C1491k.class) {
            C1491k.m6894a(context);
            f3464b.putString(str, str2);
            f3464b.commit();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m6899b(android.content.Context r3, java.lang.String r4, java.lang.String r5) {
        /*
        r1 = com.huawei.pluginkidwatch.common.lib.utils.C1491k.class;
        monitor-enter(r1);
        com.huawei.pluginkidwatch.common.lib.utils.C1491k.m6894a(r3);	 Catch:{ all -> 0x0019 }
        r0 = f3463a;	 Catch:{ all -> 0x0019 }
        r0 = r0.getString(r4, r5);	 Catch:{ all -> 0x0019 }
        if (r0 == 0) goto L_0x0014;
    L_0x000e:
        r2 = r0.equals(r5);	 Catch:{ all -> 0x0019 }
        if (r2 == 0) goto L_0x0016;
    L_0x0014:
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
    L_0x0015:
        return r5;
    L_0x0016:
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        r5 = r0;
        goto L_0x0015;
    L_0x0019:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.pluginkidwatch.common.lib.utils.k.b(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    public static Boolean m6893a(Context context, String str) {
        Boolean valueOf;
        synchronized (C1491k.class) {
            C1491k.m6894a(context);
            valueOf = Boolean.valueOf(f3463a.getBoolean(str, false));
        }
        return valueOf;
    }

    public static void m6896a(Context context, String str, Boolean bool) {
        synchronized (C1491k.class) {
            C1491k.m6894a(context);
            f3464b.putBoolean(str, bool.booleanValue());
            f3464b.commit();
        }
    }

    public static int m6898b(Context context, String str) {
        int i;
        synchronized (C1491k.class) {
            C1491k.m6894a(context);
            i = f3463a.getInt(str, 5);
        }
        return i;
    }

    public static void m6895a(Context context, String str, int i) {
        synchronized (C1491k.class) {
            C1491k.m6894a(context);
            f3464b.putInt(str, i);
            f3464b.commit();
        }
    }
}
