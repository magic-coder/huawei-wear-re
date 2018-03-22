package com.huawei.openalliance.ad.utils.p129b;

import android.util.SparseArray;
import java.util.HashMap;
import java.util.Map;

public enum C1339f {
    ALL(0),
    VERBOSE(2),
    DEBUG(3),
    INFO(4),
    WARN(5),
    ERROR(6),
    ASSERT(7),
    OUT(100),
    NONE(255);
    
    private static final SparseArray<C1339f> f2904j = null;
    private static final Map<String, C1339f> f2905k = null;
    private final int f2907l;

    static {
        f2904j = new SparseArray();
        f2905k = new HashMap();
        C1339f[] values = C1339f.values();
        int length = values.length;
        int i;
        while (i < length) {
            C1339f c1339f = values[i];
            f2904j.put(c1339f.m5911a(), c1339f);
            f2905k.put(c1339f.name(), c1339f);
            i++;
        }
    }

    private C1339f(int i) {
        this.f2907l = i;
    }

    public static C1339f m5910a(int i) {
        return (C1339f) f2904j.get(i);
    }

    public int m5911a() {
        return this.f2907l;
    }
}
