package com.google.zxing.p295e.p296a.p297a.p298a;

import com.google.zxing.C3900f;

/* compiled from: DecodedNumeric */
final class C3850q extends C3847r {
    private final int f14868a;
    private final int f14869b;

    C3850q(int i, int i2, int i3) throws C3900f {
        super(i);
        if (i2 < 0 || i2 > 10 || i3 < 0 || i3 > 10) {
            throw C3900f.m19459a();
        }
        this.f14868a = i2;
        this.f14869b = i3;
    }

    int m19148a() {
        return this.f14868a;
    }

    int m19149b() {
        return this.f14869b;
    }

    boolean m19150c() {
        return this.f14868a == 10;
    }

    boolean m19151d() {
        return this.f14869b == 10;
    }
}
