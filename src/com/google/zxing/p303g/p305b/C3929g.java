package com.google.zxing.p303g.p305b;

import java.io.Serializable;
import java.util.Comparator;

/* compiled from: FinderPatternFinder */
final class C3929g implements Serializable, Comparator<C3926d> {
    private final float f15110a;

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m19556a((C3926d) obj, (C3926d) obj2);
    }

    private C3929g(float f) {
        this.f15110a = f;
    }

    public int m19556a(C3926d c3926d, C3926d c3926d2) {
        float abs = Math.abs(c3926d2.m19543c() - this.f15110a);
        float abs2 = Math.abs(c3926d.m19543c() - this.f15110a);
        if (abs < abs2) {
            return -1;
        }
        return abs == abs2 ? 0 : 1;
    }
}
