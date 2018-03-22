package com.p252d.p253a.p254a;

/* compiled from: Utils */
class C3564v {
    public static void m17895a(boolean z, String str) {
        if (!z) {
            throw new AssertionError(str);
        }
    }

    public static <T> T m17894a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(str + " should not be null!");
    }
}
