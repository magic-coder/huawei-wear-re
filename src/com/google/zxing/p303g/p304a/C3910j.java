package com.google.zxing.p303g.p304a;

/* compiled from: DataMask */
final class C3910j extends C3903c {
    private C3910j() {
        super();
    }

    boolean mo4328a(int i, int i2) {
        int i3 = i * i2;
        return (((i3 % 3) + (i3 & 1)) & 1) == 0;
    }
}
