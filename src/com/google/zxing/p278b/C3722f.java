package com.google.zxing.p278b;

import com.google.zxing.C3932i;

/* compiled from: DefaultGridSampler */
public final class C3722f extends C3721i {
    public C3717b mo4303a(C3717b c3717b, int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) throws C3932i {
        return mo4304a(c3717b, i, i2, C3726k.m18758a(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16));
    }

    public C3717b mo4304a(C3717b c3717b, int i, int i2, C3726k c3726k) throws C3932i {
        if (i <= 0 || i2 <= 0) {
            throw C3932i.m19565a();
        }
        C3717b c3717b2 = new C3717b(i, i2);
        float[] fArr = new float[(i << 1)];
        for (int i3 = 0; i3 < i2; i3++) {
            int i4;
            int length = fArr.length;
            float f = ((float) i3) + 0.5f;
            for (i4 = 0; i4 < length; i4 += 2) {
                fArr[i4] = ((float) (i4 >> 1)) + 0.5f;
                fArr[i4 + 1] = f;
            }
            c3726k.m18762a(fArr);
            C3721i.m18735a(c3717b, fArr);
            i4 = 0;
            while (i4 < length) {
                try {
                    if (c3717b.m18712a((int) fArr[i4], (int) fArr[i4 + 1])) {
                        c3717b2.m18714b(i4 >> 1, i3);
                    }
                    i4 += 2;
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw C3932i.m19565a();
                }
            }
        }
        return c3717b2;
    }
}
