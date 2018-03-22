package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.C0526d;
import com.google.android.gms.wearable.C0569x;
import java.util.Set;

public class dd implements C0526d {
    private final String f1024a;
    private final Set<C0569x> f1025b;

    public dd(C0526d c0526d) {
        this(c0526d.getName(), c0526d.getNodes());
    }

    public dd(String str, Set<C0569x> set) {
        this.f1024a = str;
        this.f1025b = set;
    }

    public String getName() {
        return this.f1024a;
    }

    public Set<C0569x> getNodes() {
        return this.f1025b;
    }
}
