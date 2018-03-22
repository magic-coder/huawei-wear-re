package com.google.android.gms.internal;

import java.io.IOException;

public final class et {
    static final int f761a = m1449a(1, 3);
    static final int f762b = m1449a(1, 4);
    static final int f763c = m1449a(2, 0);
    static final int f764d = m1449a(3, 2);
    public static final int[] f765e = new int[0];
    public static final long[] f766f = new long[0];
    public static final float[] f767g = new float[0];
    public static final double[] f768h = new double[0];
    public static final boolean[] f769i = new boolean[0];
    public static final String[] f770j = new String[0];
    public static final byte[][] f771k = new byte[0][];
    public static final byte[] f772l = new byte[0];

    static int m1448a(int i) {
        return i & 7;
    }

    public static int m1449a(int i, int i2) {
        return (i << 3) | i2;
    }

    public static final int m1450a(eh ehVar, int i) throws IOException {
        int i2 = 1;
        int q = ehVar.m1344q();
        ehVar.m1325b(i);
        while (ehVar.m1320a() == i) {
            ehVar.m1325b(i);
            i2++;
        }
        ehVar.m1332f(q);
        return i2;
    }

    public static int m1451b(int i) {
        return i >>> 3;
    }
}
