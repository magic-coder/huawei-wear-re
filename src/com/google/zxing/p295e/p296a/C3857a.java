package com.google.zxing.p295e.p296a;

import com.google.zxing.C3932i;
import com.google.zxing.p295e.C3856k;

/* compiled from: AbstractRSSReader */
public abstract class C3857a extends C3856k {
    private final int[] f14885a = new int[4];
    private final int[] f14886b = new int[8];
    private final float[] f14887c = new float[4];
    private final float[] f14888d = new float[4];
    private final int[] f14889e = new int[(this.f14886b.length / 2)];
    private final int[] f14890f = new int[(this.f14886b.length / 2)];

    protected C3857a() {
    }

    protected final int[] m19194b() {
        return this.f14885a;
    }

    protected final int[] m19195c() {
        return this.f14886b;
    }

    protected final float[] m19196d() {
        return this.f14887c;
    }

    protected final float[] m19197e() {
        return this.f14888d;
    }

    protected final int[] m19198f() {
        return this.f14889e;
    }

    protected final int[] m19199g() {
        return this.f14890f;
    }

    protected static int m19190a(int[] iArr, int[][] iArr2) throws C3932i {
        for (int i = 0; i < iArr2.length; i++) {
            if (C3856k.m19182a(iArr, iArr2[i], 115) < 51) {
                return i;
            }
        }
        throw C3932i.m19565a();
    }

    protected static int m19189a(int[] iArr) {
        int i = 0;
        int i2 = 0;
        while (i < iArr.length) {
            i2 += iArr[i];
            i++;
        }
        return i2;
    }

    protected static void m19191a(int[] iArr, float[] fArr) {
        int i = 0;
        float f = fArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (fArr[i2] > f) {
                f = fArr[i2];
                i = i2;
            }
        }
        iArr[i] = iArr[i] + 1;
    }

    protected static void m19192b(int[] iArr, float[] fArr) {
        int i = 0;
        float f = fArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (fArr[i2] < f) {
                f = fArr[i2];
                i = i2;
            }
        }
        iArr[i] = iArr[i] - 1;
    }

    protected static boolean m19193b(int[] iArr) {
        int i = iArr[0] + iArr[1];
        float f = ((float) i) / ((float) ((iArr[2] + i) + iArr[3]));
        if (f < 0.7916667f || f > 0.89285713f) {
            return false;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        int length = iArr.length;
        int i4 = 0;
        while (i4 < length) {
            i = iArr[i4];
            if (i > i3) {
                i3 = i;
            }
            if (i >= i2) {
                i = i2;
            }
            i4++;
            i2 = i;
        }
        if (i3 < i2 * 10) {
            return true;
        }
        return false;
    }
}
