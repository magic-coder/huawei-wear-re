package com.amap.api.mapcore.util;

/* compiled from: EarClippingTriangulator */
public class az {
    private final bj f11445a = new bj();
    private short[] f11446b;
    private float[] f11447c;
    private int f11448d;
    private final be f11449e = new be();
    private final bj f11450f = new bj();

    public bj m15539a(float[] fArr) {
        return m15540a(fArr, 0, fArr.length);
    }

    public bj m15540a(float[] fArr, int i, int i2) {
        int i3;
        this.f11447c = fArr;
        int i4 = i2 / 2;
        this.f11448d = i4;
        int i5 = i / 2;
        bj bjVar = this.f11445a;
        bjVar.m15632a();
        bjVar.m15635c(i4);
        bjVar.f11500b = i4;
        short[] sArr = bjVar.f11499a;
        this.f11446b = sArr;
        if (m15535b(fArr, i, i2)) {
            for (i3 = 0; i3 < i4; i3 = (short) (i3 + 1)) {
                sArr[i3] = (short) (i5 + i3);
            }
        } else {
            int i6 = i4 - 1;
            for (i3 = 0; i3 < i4; i3++) {
                sArr[i3] = (short) ((i5 + i6) - i3);
            }
        }
        be beVar = this.f11449e;
        beVar.m15622a();
        beVar.m15625c(i4);
        for (i3 = 0; i3 < i4; i3++) {
            beVar.m15623a(m15531a(i3));
        }
        bjVar = this.f11450f;
        bjVar.m15632a();
        bjVar.m15635c(Math.max(0, i4 - 2) * 3);
        m15532a();
        return bjVar;
    }

    private void m15532a() {
        int[] iArr = this.f11449e.f11494a;
        while (this.f11448d > 3) {
            int b = m15533b();
            m15536c(b);
            int d = m15537d(b);
            if (b == this.f11448d) {
                b = 0;
            }
            iArr[d] = m15531a(d);
            iArr[b] = m15531a(b);
        }
        if (this.f11448d == 3) {
            bj bjVar = this.f11450f;
            short[] sArr = this.f11446b;
            bjVar.m15633a(sArr[0]);
            bjVar.m15633a(sArr[1]);
            bjVar.m15633a(sArr[2]);
        }
    }

    private int m15531a(int i) {
        short[] sArr = this.f11446b;
        int i2 = sArr[m15537d(i)] * 2;
        int i3 = sArr[i] * 2;
        int i4 = sArr[m15538e(i)] * 2;
        float[] fArr = this.f11447c;
        return m15530a(fArr[i2], fArr[i2 + 1], fArr[i3], fArr[i3 + 1], fArr[i4], fArr[i4 + 1]);
    }

    private int m15533b() {
        int i;
        int i2 = this.f11448d;
        for (i = 0; i < i2; i++) {
            if (m15534b(i)) {
                return i;
            }
        }
        int[] iArr = this.f11449e.f11494a;
        for (i = 0; i < i2; i++) {
            if (iArr[i] != -1) {
                return i;
            }
        }
        return 0;
    }

    private boolean m15534b(int i) {
        int[] iArr = this.f11449e.f11494a;
        if (iArr[i] == -1) {
            return false;
        }
        int d = m15537d(i);
        int e = m15538e(i);
        short[] sArr = this.f11446b;
        int i2 = sArr[d] * 2;
        int i3 = sArr[i] * 2;
        int i4 = sArr[e] * 2;
        float[] fArr = this.f11447c;
        float f = fArr[i2];
        float f2 = fArr[i2 + 1];
        float f3 = fArr[i3];
        float f4 = fArr[i3 + 1];
        float f5 = fArr[i4];
        float f6 = fArr[i4 + 1];
        int e2 = m15538e(e);
        while (e2 != d) {
            if (iArr[e2] != 1) {
                i4 = sArr[e2] * 2;
                float f7 = fArr[i4];
                float f8 = fArr[i4 + 1];
                if (m15530a(f5, f6, f, f2, f7, f8) >= 0 && m15530a(f, f2, f3, f4, f7, f8) >= 0 && m15530a(f3, f4, f5, f6, f7, f8) >= 0) {
                    return false;
                }
            }
            e2 = m15538e(e2);
        }
        return true;
    }

    private void m15536c(int i) {
        short[] sArr = this.f11446b;
        bj bjVar = this.f11450f;
        bjVar.m15633a(sArr[m15537d(i)]);
        bjVar.m15633a(sArr[i]);
        bjVar.m15633a(sArr[m15538e(i)]);
        this.f11445a.m15634b(i);
        this.f11449e.m15624b(i);
        this.f11448d--;
    }

    private int m15537d(int i) {
        if (i == 0) {
            i = this.f11448d;
        }
        return i - 1;
    }

    private int m15538e(int i) {
        return (i + 1) % this.f11448d;
    }

    private static boolean m15535b(float[] fArr, int i, int i2) {
        if (i2 <= 2) {
            return false;
        }
        int i3 = (i + i2) - 3;
        float f = 0.0f;
        for (int i4 = i; i4 < i3; i4 += 2) {
            f += (fArr[i4] * fArr[i4 + 3]) - (fArr[i4 + 1] * fArr[i4 + 2]);
        }
        float f2 = fArr[(i + i2) - 2];
        float f3 = fArr[(i + i2) - 1];
        if (((f2 * fArr[i + 1]) + f) - (fArr[i] * f3) < 0.0f) {
            return true;
        }
        return false;
    }

    private static int m15530a(float f, float f2, float f3, float f4, float f5, float f6) {
        return (int) Math.signum((((f6 - f4) * f) + ((f2 - f6) * f3)) + ((f4 - f2) * f5));
    }
}
