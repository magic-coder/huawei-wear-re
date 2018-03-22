package com.google.zxing.p295e.p296a;

import com.google.zxing.C3922o;

/* compiled from: FinderPattern */
public final class C3860c {
    private final int f14903a;
    private final int[] f14904b;
    private final C3922o[] f14905c;

    public C3860c(int i, int[] iArr, int i2, int i3, int i4) {
        this.f14903a = i;
        this.f14904b = iArr;
        this.f14905c = new C3922o[]{new C3922o((float) i2, (float) i4), new C3922o((float) i3, (float) i4)};
    }

    public int m19221a() {
        return this.f14903a;
    }

    public int[] m19222b() {
        return this.f14904b;
    }

    public C3922o[] m19223c() {
        return this.f14905c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C3860c)) {
            return false;
        }
        if (this.f14903a == ((C3860c) obj).f14903a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f14903a;
    }
}
