package com.google.zxing.p295e.p296a.p297a;

import java.util.ArrayList;
import java.util.List;

/* compiled from: ExpandedRow */
final class C3855c {
    private final List<C3854b> f14882a;
    private final int f14883b;
    private final boolean f14884c;

    C3855c(List<C3854b> list, int i, boolean z) {
        this.f14882a = new ArrayList(list);
        this.f14883b = i;
        this.f14884c = z;
    }

    List<C3854b> m19179a() {
        return this.f14882a;
    }

    int m19181b() {
        return this.f14883b;
    }

    boolean m19180a(List<C3854b> list) {
        return this.f14882a.equals(list);
    }

    public String toString() {
        return "{ " + this.f14882a + " }";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C3855c)) {
            return false;
        }
        C3855c c3855c = (C3855c) obj;
        if (this.f14882a.equals(c3855c.m19179a()) && this.f14884c == c3855c.f14884c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f14882a.hashCode() ^ Boolean.valueOf(this.f14884c).hashCode();
    }
}
