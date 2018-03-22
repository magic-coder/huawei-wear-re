package com.google.zxing.p303g.p305b;

import com.google.zxing.C3803p;
import com.google.zxing.C3922o;
import com.google.zxing.C3932i;
import com.google.zxing.p278b.C3717b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AlignmentPatternFinder */
final class C3924b {
    private final C3717b f15091a;
    private final List<C3923a> f15092b = new ArrayList(5);
    private final int f15093c;
    private final int f15094d;
    private final int f15095e;
    private final int f15096f;
    private final float f15097g;
    private final int[] f15098h;
    private final C3803p f15099i;

    C3924b(C3717b c3717b, int i, int i2, int i3, int i4, float f, C3803p c3803p) {
        this.f15091a = c3717b;
        this.f15093c = i;
        this.f15094d = i2;
        this.f15095e = i3;
        this.f15096f = i4;
        this.f15097g = f;
        this.f15098h = new int[3];
        this.f15099i = c3803p;
    }

    C3923a m19530a() throws C3932i {
        int i = this.f15093c;
        int i2 = this.f15096f;
        int i3 = i + this.f15095e;
        int i4 = this.f15094d + (i2 >> 1);
        int[] iArr = new int[3];
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = i4 + ((i5 & 1) == 0 ? (i5 + 1) >> 1 : -((i5 + 1) >> 1));
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i7 = i;
            while (i7 < i3 && !this.f15091a.m18712a(i7, i6)) {
                i7++;
            }
            i7 = 0;
            for (int i8 = i7; i8 < i3; i8++) {
                C3923a a;
                if (!this.f15091a.m18712a(i8, i6)) {
                    if (i7 == 1) {
                        i7++;
                    }
                    iArr[i7] = iArr[i7] + 1;
                } else if (i7 == 1) {
                    iArr[i7] = iArr[i7] + 1;
                } else if (i7 == 2) {
                    if (m19529a(iArr)) {
                        a = m19528a(iArr, i6, i8);
                        if (a != null) {
                            return a;
                        }
                    }
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i7 = 1;
                } else {
                    i7++;
                    iArr[i7] = iArr[i7] + 1;
                }
            }
            if (m19529a(iArr)) {
                a = m19528a(iArr, i6, i3);
                if (a != null) {
                    return a;
                }
            }
        }
        if (!this.f15092b.isEmpty()) {
            return (C3923a) this.f15092b.get(0);
        }
        throw C3932i.m19565a();
    }

    private static float m19527a(int[] iArr, int i) {
        return ((float) (i - iArr[2])) - (((float) iArr[1]) / 2.0f);
    }

    private boolean m19529a(int[] iArr) {
        float f = this.f15097g;
        float f2 = f / 2.0f;
        for (int i = 0; i < 3; i++) {
            if (Math.abs(f - ((float) iArr[i])) >= f2) {
                return false;
            }
        }
        return true;
    }

    private float m19526a(int i, int i2, int i3, int i4) {
        C3717b c3717b = this.f15091a;
        int e = c3717b.m18720e();
        int[] iArr = this.f15098h;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i5 = i;
        while (i5 >= 0 && c3717b.m18712a(i2, i5) && iArr[1] <= i3) {
            iArr[1] = iArr[1] + 1;
            i5--;
        }
        if (i5 < 0 || iArr[1] > i3) {
            return Float.NaN;
        }
        while (i5 >= 0 && !c3717b.m18712a(i2, i5) && iArr[0] <= i3) {
            iArr[0] = iArr[0] + 1;
            i5--;
        }
        if (iArr[0] > i3) {
            return Float.NaN;
        }
        i5 = i + 1;
        while (i5 < e && c3717b.m18712a(i2, i5) && iArr[1] <= i3) {
            iArr[1] = iArr[1] + 1;
            i5++;
        }
        if (i5 == e || iArr[1] > i3) {
            return Float.NaN;
        }
        while (i5 < e && !c3717b.m18712a(i2, i5) && iArr[2] <= i3) {
            iArr[2] = iArr[2] + 1;
            i5++;
        }
        if (iArr[2] > i3 || Math.abs(((iArr[0] + iArr[1]) + iArr[2]) - i4) * 5 >= i4 * 2 || !m19529a(iArr)) {
            return Float.NaN;
        }
        return C3924b.m19527a(iArr, i5);
    }

    private C3923a m19528a(int[] iArr, int i, int i2) {
        int i3 = (iArr[0] + iArr[1]) + iArr[2];
        float a = C3924b.m19527a(iArr, i2);
        float a2 = m19526a(i, (int) a, iArr[1] * 2, i3);
        if (!Float.isNaN(a2)) {
            float f = ((float) ((iArr[0] + iArr[1]) + iArr[2])) / 3.0f;
            for (C3923a c3923a : this.f15092b) {
                if (c3923a.m19524a(f, a2, a)) {
                    return c3923a.m19525b(a2, a, f);
                }
            }
            C3922o c3923a2 = new C3923a(a, a2, f);
            this.f15092b.add(c3923a2);
            if (this.f15099i != null) {
                this.f15099i.mo4312a(c3923a2);
            }
        }
        return null;
    }
}
