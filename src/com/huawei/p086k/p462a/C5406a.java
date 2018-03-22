package com.huawei.p086k.p462a;

import android.text.TextUtils;

/* compiled from: Checker */
public final class C5406a {
    public static <T> T m25991a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(str));
    }

    public static String m25992a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException(String.valueOf(str2));
    }
}
