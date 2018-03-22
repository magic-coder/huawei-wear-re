package com.google.zxing.p303g.p305b;

import java.io.Serializable;
import java.util.Comparator;

/* compiled from: FinderPatternFinder */
final class C3928f implements Serializable, Comparator<C3926d> {
    private final float f15109a;

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m19555a((C3926d) obj, (C3926d) obj2);
    }

    private C3928f(float f) {
        this.f15109a = f;
    }

    public int m19555a(C3926d c3926d, C3926d c3926d2) {
        if (c3926d2.m19544d() != c3926d.m19544d()) {
            return c3926d2.m19544d() - c3926d.m19544d();
        }
        float abs = Math.abs(c3926d2.m19543c() - this.f15109a);
        float abs2 = Math.abs(c3926d.m19543c() - this.f15109a);
        if (abs < abs2) {
            return 1;
        }
        return abs == abs2 ? 0 : -1;
    }
}
