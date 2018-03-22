package com.huawei.openalliance.ad.p112a.p125g;

import android.content.Context;
import java.util.HashSet;
import java.util.Set;

public abstract class C1277a {
    private static Set<String> f2722a = new HashSet();

    static {
        f2722a.add("click");
        f2722a.add("imp");
    }

    public abstract void mo2441a(Context context);

    public boolean m5634a(String str) {
        return f2722a.contains(str);
    }
}
