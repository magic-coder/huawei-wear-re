package com.huawei.pluginkidwatch.common.lib.utils;

import android.content.Context;

/* compiled from: AesCryptUtils */
public class C1482b {
    private static final byte[] f3456a = new byte[0];

    public static String m6817a(Context context, String str) {
        String str2;
        synchronized (f3456a) {
            str2 = null;
            if (!(context == null || str == null)) {
                C1497q.m6946b(context);
                str2 = C1484d.m6838a(str);
            }
        }
        return str2;
    }

    public static String m6818b(Context context, String str) {
        String str2;
        synchronized (f3456a) {
            str2 = null;
            if (!(context == null || str == null)) {
                C1497q.m6946b(context);
                str2 = C1484d.m6840b(str);
            }
        }
        return str2;
    }
}
