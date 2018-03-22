package com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.p360b;

import java.util.HashMap;
import java.util.Map;

public enum C4242a {
    ALL(0),
    VERBOSE(2),
    DEBUG(3),
    INFO(4),
    WARN(5),
    ERROR(6),
    ASSERT(7),
    OUT(100),
    NONE(255),
    UNKNOWN(-1);
    
    private static final Map<Integer, C4242a> f15899k = null;
    private static final Map<String, C4242a> f15900l = null;
    private final int f15902m;

    static {
        f15899k = new HashMap();
        f15900l = new HashMap();
        C4242a[] values = C4242a.values();
        int length = values.length;
        int i;
        while (i < length) {
            C4242a c4242a = values[i];
            f15899k.put(Integer.valueOf(c4242a.m20533a()), c4242a);
            f15900l.put(c4242a.name(), c4242a);
            i++;
        }
    }

    private C4242a(int i) {
        this.f15902m = i;
    }

    public int m20533a() {
        return this.f15902m;
    }
}
