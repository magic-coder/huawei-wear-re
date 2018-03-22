package com.google.zxing.p299f.p300a;

import com.google.zxing.p299f.C3895a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: BarcodeValue */
final class C3885b {
    private final Map<Integer, Integer> f14993a = new HashMap();

    C3885b() {
    }

    void m19343a(int i) {
        Integer num = (Integer) this.f14993a.get(Integer.valueOf(i));
        if (num == null) {
            num = Integer.valueOf(0);
        }
        this.f14993a.put(Integer.valueOf(i), Integer.valueOf(num.intValue() + 1));
    }

    int[] m19344a() {
        Collection arrayList = new ArrayList();
        int i = -1;
        for (Entry entry : this.f14993a.entrySet()) {
            if (((Integer) entry.getValue()).intValue() > i) {
                int intValue = ((Integer) entry.getValue()).intValue();
                arrayList.clear();
                arrayList.add((Integer) entry.getKey());
                i = intValue;
            } else if (((Integer) entry.getValue()).intValue() == i) {
                arrayList.add((Integer) entry.getKey());
            }
        }
        return C3895a.m19435a(arrayList);
    }
}
