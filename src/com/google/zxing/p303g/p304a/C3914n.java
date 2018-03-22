package com.google.zxing.p303g.p304a;

/* compiled from: ErrorCorrectionLevel */
public enum C3914n {
    L(1),
    f15052b(0),
    Q(3),
    H(2);
    
    private static final C3914n[] f15055e = null;
    private final int f15057f;

    static {
        f15055e = new C3914n[]{f15052b, L, H, Q};
    }

    private C3914n(int i) {
        this.f15057f = i;
    }

    public static C3914n m19492a(int i) {
        if (i >= 0 && i < f15055e.length) {
            return f15055e[i];
        }
        throw new IllegalArgumentException();
    }
}
