package com.google.zxing.p299f.p300a;

import android.support.v4.widget.AutoScrollHelper;
import com.android.volley.DefaultRetryPolicy;
import com.google.zxing.p299f.C3895a;
import java.lang.reflect.Array;

/* compiled from: PDF417CodewordDecoder */
final class C3893j {
    private static final float[][] f15026a = ((float[][]) Array.newInstance(Float.TYPE, new int[]{C3895a.f15028a.length, 8}));

    static {
        for (int i = 0; i < C3895a.f15028a.length; i++) {
            int i2 = C3895a.f15028a[i];
            int i3 = i2 & 1;
            for (int i4 = 0; i4 < 8; i4++) {
                float f = 0.0f;
                while ((i2 & 1) == i3) {
                    f += DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
                    i2 >>= 1;
                }
                i3 = i2 & 1;
                f15026a[i][(8 - i4) - 1] = f / 17.0f;
            }
        }
    }

    static int m19405a(int[] iArr) {
        int c = C3893j.m19407c(C3893j.m19406b(iArr));
        return c != -1 ? c : C3893j.m19409e(iArr);
    }

    private static int[] m19406b(int[] iArr) {
        int i = 0;
        float a = (float) C3895a.m19434a(iArr);
        int[] iArr2 = new int[8];
        int i2 = 0;
        for (int i3 = 0; i3 < 17; i3++) {
            if (((float) (iArr[i2] + i)) <= (a / 34.0f) + ((((float) i3) * a) / 17.0f)) {
                i += iArr[i2];
                i2++;
            }
            iArr2[i2] = iArr2[i2] + 1;
        }
        return iArr2;
    }

    private static int m19407c(int[] iArr) {
        int d = C3893j.m19408d(iArr);
        if (C3895a.m19433a((long) d) == -1) {
            return -1;
        }
        return d;
    }

    private static int m19408d(int[] iArr) {
        long j = 0;
        for (int i = 0; i < iArr.length; i++) {
            int i2 = 0;
            while (i2 < iArr[i]) {
                int i3;
                long j2 = j << 1;
                if (i % 2 == 0) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                i2++;
                j = j2 | ((long) i3);
            }
        }
        return (int) j;
    }

    private static int m19409e(int[] iArr) {
        int i;
        int a = C3895a.m19434a(iArr);
        float[] fArr = new float[8];
        for (i = 0; i < fArr.length; i++) {
            fArr[i] = ((float) iArr[i]) / ((float) a);
        }
        float f = AutoScrollHelper.NO_MAX;
        a = -1;
        for (i = 0; i < f15026a.length; i++) {
            float f2 = 0.0f;
            float[] fArr2 = f15026a[i];
            for (int i2 = 0; i2 < 8; i2++) {
                float f3 = fArr2[i2] - fArr[i2];
                f2 += f3 * f3;
                if (f2 >= f) {
                    break;
                }
            }
            if (f2 < f) {
                a = C3895a.f15028a[i];
                f = f2;
            }
        }
        return a;
    }
}
