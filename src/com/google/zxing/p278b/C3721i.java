package com.google.zxing.p278b;

import com.google.zxing.C3932i;

/* compiled from: GridSampler */
public abstract class C3721i {
    private static C3721i f14481a = new C3722f();

    public abstract C3717b mo4303a(C3717b c3717b, int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) throws C3932i;

    public abstract C3717b mo4304a(C3717b c3717b, int i, int i2, C3726k c3726k) throws C3932i;

    public static C3721i m18734a() {
        return f14481a;
    }

    protected static void m18735a(C3717b c3717b, float[] fArr) throws C3932i {
        int i;
        int d = c3717b.m18719d();
        int e = c3717b.m18720e();
        Object obj = 1;
        for (i = 0; i < fArr.length && r2 != null; i += 2) {
            int i2 = (int) fArr[i];
            int i3 = (int) fArr[i + 1];
            if (i2 < -1 || i2 > d || i3 < -1 || i3 > e) {
                throw C3932i.m19565a();
            }
            if (i2 == -1) {
                fArr[i] = 0.0f;
                obj = 1;
            } else if (i2 == d) {
                fArr[i] = (float) (d - 1);
                i2 = 1;
            } else {
                obj = null;
            }
            if (i3 == -1) {
                fArr[i + 1] = 0.0f;
                obj = 1;
            } else if (i3 == e) {
                fArr[i + 1] = (float) (e - 1);
                i2 = 1;
            }
        }
        Object obj2 = 1;
        for (i2 = fArr.length - 2; i2 >= 0 && r0 != null; i2 -= 2) {
            i = (int) fArr[i2];
            i3 = (int) fArr[i2 + 1];
            if (i < -1 || i > d || i3 < -1 || i3 > e) {
                throw C3932i.m19565a();
            }
            if (i == -1) {
                fArr[i2] = 0.0f;
                obj2 = 1;
            } else if (i == d) {
                fArr[i2] = (float) (d - 1);
                i = 1;
            } else {
                obj2 = null;
            }
            if (i3 == -1) {
                fArr[i2 + 1] = 0.0f;
                obj2 = 1;
            } else if (i3 == e) {
                fArr[i2 + 1] = (float) (e - 1);
                i = 1;
            }
        }
    }
}
