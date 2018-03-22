package com.google.zxing.p303g.p304a;

/* compiled from: DataMask */
final class C3911k extends C3903c {
    private C3911k() {
        super();
    }

    boolean mo4328a(int i, int i2) {
        return ((((i + i2) & 1) + ((i * i2) % 3)) & 1) == 0;
    }
}
