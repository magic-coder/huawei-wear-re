package com.amap.api.mapcore.util;

/* compiled from: AMapThrowException */
public final class au extends Exception {
    public static <T> T m15519a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException("null reference");
    }

    public static <T> T m15520a(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void m15521a(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void m15523b(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void m15522a(boolean z, String str, Object[] objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    private au() {
        throw new AssertionError("Uninstantiable");
    }
}
