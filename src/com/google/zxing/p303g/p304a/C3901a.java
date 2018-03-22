package com.google.zxing.p303g.p304a;

import com.google.zxing.C3900f;
import com.google.zxing.p278b.C3717b;

/* compiled from: BitMatrixParser */
final class C3901a {
    private final C3717b f15042a;
    private C3918r f15043b;
    private C3915o f15044c;
    private boolean f15045d;

    C3901a(C3717b c3717b) throws C3900f {
        int e = c3717b.m18720e();
        if (e < 21 || (e & 3) != 1) {
            throw C3900f.m19459a();
        }
        this.f15042a = c3717b;
    }

    C3915o m19461a() throws C3900f {
        int i = 0;
        if (this.f15044c != null) {
            return this.f15044c;
        }
        int i2;
        int i3 = 0;
        for (i2 = 0; i2 < 6; i2++) {
            i3 = m19460a(i2, 8, i3);
        }
        i3 = m19460a(8, 7, m19460a(8, 8, m19460a(7, 8, i3)));
        for (i2 = 5; i2 >= 0; i2--) {
            i3 = m19460a(8, i2, i3);
        }
        int e = this.f15042a.m18720e();
        int i4 = e - 7;
        for (i2 = e - 1; i2 >= i4; i2--) {
            i = m19460a(8, i2, i);
        }
        for (i2 = e - 8; i2 < e; i2++) {
            i = m19460a(i2, 8, i);
        }
        this.f15044c = C3915o.m19494b(i3, i);
        if (this.f15044c != null) {
            return this.f15044c;
        }
        throw C3900f.m19459a();
    }

    C3918r m19463b() throws C3900f {
        if (this.f15043b != null) {
            return this.f15043b;
        }
        int e = this.f15042a.m18720e();
        int i = (e - 17) >> 2;
        if (i <= 6) {
            return C3918r.m19502b(i);
        }
        int i2 = e - 11;
        int i3 = 0;
        for (int i4 = 5; i4 >= 0; i4--) {
            for (i = e - 9; i >= i2; i--) {
                i3 = m19460a(i, i4, i3);
            }
        }
        C3918r c = C3918r.m19503c(i3);
        if (c == null || c.m19509d() != e) {
            int i5 = 0;
            for (int i6 = 5; i6 >= 0; i6--) {
                for (i = e - 9; i >= i2; i--) {
                    i5 = m19460a(i6, i, i5);
                }
            }
            c = C3918r.m19503c(i5);
            if (c == null || c.m19509d() != e) {
                throw C3900f.m19459a();
            }
            this.f15043b = c;
            return c;
        }
        this.f15043b = c;
        return c;
    }

    private int m19460a(int i, int i2, int i3) {
        return this.f15045d ? this.f15042a.m18712a(i2, i) : this.f15042a.m18712a(i, i2) ? (i3 << 1) | 1 : i3 << 1;
    }

    byte[] m19464c() throws C3900f {
        C3915o a = m19461a();
        C3918r b = m19463b();
        C3903c a2 = C3903c.m19470a(a.m19497b());
        int e = this.f15042a.m18720e();
        a2.m19471a(this.f15042a, e);
        C3717b e2 = b.m19510e();
        byte[] bArr = new byte[b.m19508c()];
        int i = e - 1;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1;
        while (i > 0) {
            if (i == 6) {
                i--;
            }
            for (int i6 = 0; i6 < e; i6++) {
                int i7;
                if (i5 != 0) {
                    i7 = (e - 1) - i6;
                } else {
                    i7 = i6;
                }
                for (int i8 = 0; i8 < 2; i8++) {
                    if (!e2.m18712a(i - i8, i7)) {
                        i2++;
                        i3 <<= 1;
                        if (this.f15042a.m18712a(i - i8, i7)) {
                            i3 |= 1;
                        }
                        if (i2 == 8) {
                            i2 = i4 + 1;
                            bArr[i4] = (byte) i3;
                            i3 = 0;
                            i4 = i2;
                            i2 = 0;
                        }
                    }
                }
            }
            i -= 2;
            i5 ^= 1;
        }
        if (i4 == b.m19508c()) {
            return bArr;
        }
        throw C3900f.m19459a();
    }

    void m19465d() {
        if (this.f15044c != null) {
            C3903c.m19470a(this.f15044c.m19497b()).m19471a(this.f15042a, this.f15042a.m18720e());
        }
    }

    void m19462a(boolean z) {
        this.f15043b = null;
        this.f15044c = null;
        this.f15045d = z;
    }

    void m19466e() {
        for (int i = 0; i < this.f15042a.m18719d(); i++) {
            for (int i2 = i + 1; i2 < this.f15042a.m18720e(); i2++) {
                if (this.f15042a.m18712a(i, i2) != this.f15042a.m18712a(i2, i)) {
                    this.f15042a.m18717c(i2, i);
                    this.f15042a.m18717c(i, i2);
                }
            }
        }
    }
}
