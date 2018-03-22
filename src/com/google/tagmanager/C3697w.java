package com.google.tagmanager;

import com.google.analytics.p273b.p274a.p275a.C3644b;
import java.util.Map;
import java.util.Set;

/* compiled from: FunctionCallImplementation */
abstract class C3697w {
    private final Set<String> f14357a;

    public abstract C3644b m18614a(Map<String, C3644b> map);

    public abstract boolean m18615a();

    public Set<String> m18617b() {
        return this.f14357a;
    }

    boolean m18616a(Set<String> set) {
        return set.containsAll(this.f14357a);
    }
}
