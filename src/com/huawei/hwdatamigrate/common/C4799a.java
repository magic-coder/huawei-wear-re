package com.huawei.hwdatamigrate.common;

import android.content.Context;

/* compiled from: AesCryptUtils */
public class C4799a {
    private static final Object f17741a = new Object();

    public static String m22980a(Context context, String str) {
        String str2;
        synchronized (f17741a) {
            str2 = null;
            if (!(context == null || str == null)) {
                C4804j.m23008a(context);
                str2 = C4801c.m22995a(str);
            }
        }
        return str2;
    }

    public static String m22981b(Context context, String str) {
        String str2;
        synchronized (f17741a) {
            str2 = null;
            if (!(context == null || str == null)) {
                C4804j.m23008a(context);
                str2 = C4801c.m22997b(str);
            }
        }
        return str2;
    }
}
