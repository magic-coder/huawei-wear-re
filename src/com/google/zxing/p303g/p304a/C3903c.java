package com.google.zxing.p303g.p304a;

import com.google.zxing.p278b.C3717b;

/* compiled from: DataMask */
abstract class C3903c {
    private static final C3903c[] f15048a = new C3903c[]{new C3904d(), new C3905e(), new C3906f(), new C3907g(), new C3908h(), new C3909i(), new C3910j(), new C3911k()};

    abstract boolean mo4328a(int i, int i2);

    private C3903c() {
    }

    final void m19471a(C3717b c3717b, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < i; i3++) {
                if (mo4328a(i2, i3)) {
                    c3717b.m18717c(i3, i2);
                }
            }
        }
    }

    static C3903c m19470a(int i) {
        if (i >= 0 && i <= 7) {
            return f15048a[i];
        }
        throw new IllegalArgumentException();
    }
}
