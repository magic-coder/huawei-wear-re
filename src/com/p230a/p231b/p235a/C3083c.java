package com.p230a.p231b.p235a;

import java.util.HashMap;

public class C3083c {
    private static C3083c f10345a;
    private HashMap f10346b = null;

    public static C3083c m13791a() {
        if (f10345a == null) {
            synchronized (C3083c.class) {
                f10345a = new C3083c();
            }
        }
        return f10345a;
    }

    public HashMap m13792b() {
        if (this.f10346b == null) {
            this.f10346b = new HashMap(5);
        }
        return this.f10346b;
    }
}
