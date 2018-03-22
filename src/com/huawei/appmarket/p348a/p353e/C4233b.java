package com.huawei.appmarket.p348a.p353e;

public class C4233b extends C4232a {
    private static C4233b f15873b = null;

    private C4233b() {
    }

    public static synchronized C4233b m20517a() {
        C4233b c4233b;
        synchronized (C4233b.class) {
            if (f15873b == null) {
                f15873b = new C4233b();
            }
            c4233b = f15873b;
        }
        return c4233b;
    }
}
