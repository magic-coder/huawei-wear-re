package com.tencent.open.p532d;

import java.util.HashMap;

/* compiled from: ProGuard */
public class C6407t {
    private static HashMap<String, Object> f22253a = new HashMap();

    public static Object m29227a(String str, Object obj) {
        return f22253a.put(str, obj);
    }

    public static Object m29226a(String str) {
        return f22253a.remove(str);
    }

    public static void m29228b(String str) {
        f22253a.remove(str);
    }
}
