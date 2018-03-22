package com.huawei.p111o.p477a;

import java.util.HashMap;
import java.util.Map;

/* compiled from: HWEncryptModelConstant */
public class C5693a {
    private static Map<Integer, Boolean> m26277a() {
        Map<Integer, Boolean> hashMap = new HashMap();
        hashMap.put(Integer.valueOf(1), Boolean.valueOf(true));
        hashMap.put(Integer.valueOf(2), Boolean.valueOf(true));
        hashMap.put(Integer.valueOf(3), Boolean.valueOf(true));
        hashMap.put(Integer.valueOf(4), Boolean.valueOf(true));
        hashMap.put(Integer.valueOf(5), Boolean.valueOf(true));
        hashMap.put(Integer.valueOf(6), Boolean.valueOf(true));
        hashMap.put(Integer.valueOf(7), Boolean.valueOf(true));
        hashMap.put(Integer.valueOf(8), Boolean.valueOf(true));
        hashMap.put(Integer.valueOf(9), Boolean.valueOf(true));
        hashMap.put(Integer.valueOf(10), Boolean.valueOf(true));
        hashMap.put(Integer.valueOf(11), Boolean.valueOf(true));
        hashMap.put(Integer.valueOf(12), Boolean.valueOf(true));
        hashMap.put(Integer.valueOf(13), Boolean.valueOf(true));
        hashMap.put(Integer.valueOf(14), Boolean.valueOf(true));
        return hashMap;
    }

    public static boolean m26278a(int i) {
        return ((Boolean) C5693a.m26277a().get(Integer.valueOf(i))).booleanValue();
    }
}
