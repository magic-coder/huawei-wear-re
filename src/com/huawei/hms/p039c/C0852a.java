package com.huawei.hms.p039c;

import android.os.Looper;

/* compiled from: Checker */
public final class C0852a {
    public static <T> T m3001a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(str));
    }

    public static void m3002a(String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException(str);
        }
    }

    public static <T> T m3003b(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(str));
    }
}
