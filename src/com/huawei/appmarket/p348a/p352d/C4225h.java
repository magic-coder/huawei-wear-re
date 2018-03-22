package com.huawei.appmarket.p348a.p352d;

import java.util.concurrent.ConcurrentHashMap;

public class C4225h extends ConcurrentHashMap<String, C4220c> {
    private int f15860a;

    public C4220c m20498a(String str, C4220c c4220c) {
        return m20499a(str, c4220c, true);
    }

    public C4220c m20499a(String str, C4220c c4220c, boolean z) {
        if (c4220c == null) {
            return null;
        }
        Object obj;
        if (-1 != c4220c.f15837a) {
            int i = this.f15860a + 1;
            this.f15860a = i;
            c4220c.f15837a = i;
        }
        if (c4220c.f15844h == C4224g.INSTALL) {
            obj = "pre_hispace_install_" + str;
        }
        super.remove(obj);
        return (C4220c) super.put(obj, c4220c);
    }

    public C4220c m20500a(String str, C4226i c4226i) {
        Object obj;
        if (c4226i == C4226i.INSTALL_TYPE) {
            obj = "pre_hispace_install_" + str;
        }
        return (C4220c) super.get(obj);
    }

    public /* synthetic */ Object put(Object obj, Object obj2) {
        return m20498a((String) obj, (C4220c) obj2);
    }
}
