package com.google.zxing.p303g.p304a;

/* compiled from: DataMask */
final class C3909i extends C3903c {
    private C3909i() {
        super();
    }

    boolean mo4328a(int i, int i2) {
        int i3 = i * i2;
        return (i3 % 3) + (i3 & 1) == 0;
    }
}
