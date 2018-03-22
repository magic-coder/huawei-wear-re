package com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.p362c.p363a;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class C4260m extends C4259l {
    private List<C4258k> f15932a = new ArrayList();
    private Map<String, C4258k> f15933b = new TreeMap();

    public C4258k m20618a(String str) {
        return str == null ? null : (C4258k) this.f15933b.get(str);
    }

    public void m20619a(C4258k c4258k) {
        if (c4258k != null) {
            this.f15932a.add(c4258k);
            if (!c4258k.m20607b()) {
                this.f15933b.put(c4258k.m20602a(), c4258k);
            }
        }
    }

    public boolean mo4394a() {
        return false;
    }

    public boolean mo4395b() {
        return this.f15932a == null || this.f15932a.size() == 0;
    }

    public List<C4258k> m20622c() {
        return this.f15932a;
    }
}
