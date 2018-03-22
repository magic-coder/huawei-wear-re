package com.google.analytics.tracking.android;

/* compiled from: Log */
public class ar {
    private static ao f14138a;

    public static void m18264a(String str) {
        as b = m18266b();
        if (b != null) {
            b.mo4259d(str);
        }
    }

    public static void m18267b(String str) {
        as b = m18266b();
        if (b != null) {
            b.mo4257b(str);
        }
    }

    public static void m18268c(String str) {
        as b = m18266b();
        if (b != null) {
            b.mo4256a(str);
        }
    }

    public static void m18269d(String str) {
        as b = m18266b();
        if (b != null) {
            b.mo4258c(str);
        }
    }

    public static boolean m18265a() {
        if (m18266b() != null) {
            return at.VERBOSE.equals(m18266b().mo4254a());
        }
        return false;
    }

    private static as m18266b() {
        if (f14138a == null) {
            f14138a = ao.m18246a();
        }
        if (f14138a != null) {
            return f14138a.m18254d();
        }
        return null;
    }
}
