package com.google.zxing.p278b;

import com.google.zxing.C3723b;
import com.google.zxing.C3824g;
import com.google.zxing.C3932i;

/* compiled from: GlobalHistogramBinarizer */
public class C3724h extends C3723b {
    private static final byte[] f14483a = new byte[0];
    private byte[] f14484b = f14483a;
    private final int[] f14485c = new int[32];

    public C3724h(C3824g c3824g) {
        super(c3824g);
    }

    public C3712a mo4305a(int i, C3712a c3712a) throws C3932i {
        int i2;
        int i3;
        int i4 = 1;
        C3824g a = m18742a();
        int b = a.m19082b();
        if (c3712a == null || c3712a.m18676a() < b) {
            c3712a = new C3712a(b);
        } else {
            c3712a.m18680b();
        }
        m18747a(b);
        byte[] a2 = a.mo4317a(i, this.f14484b);
        int[] iArr = this.f14485c;
        for (i2 = 0; i2 < b; i2++) {
            i3 = (a2[i2] & 255) >> 3;
            iArr[i3] = iArr[i3] + 1;
        }
        i3 = C3724h.m18746a(iArr);
        i2 = a2[1] & 255;
        int i5 = a2[0] & 255;
        while (i4 < b - 1) {
            int i6 = a2[i4 + 1] & 255;
            if (((((i2 << 2) - i5) - i6) >> 1) < i3) {
                c3712a.m18681b(i4);
            }
            i4++;
            i5 = i2;
            i2 = i6;
        }
        return c3712a;
    }

    public C3717b mo4307b() throws C3932i {
        int i;
        int i2;
        C3824g a = m18742a();
        int b = a.m19082b();
        int c = a.m19083c();
        C3717b c3717b = new C3717b(b, c);
        m18747a(b);
        int[] iArr = this.f14485c;
        for (i = 1; i < 5; i++) {
            byte[] a2 = a.mo4317a((c * i) / 5, this.f14484b);
            int i3 = (b << 2) / 5;
            for (i2 = b / 5; i2 < i3; i2++) {
                int i4 = (a2[i2] & 255) >> 3;
                iArr[i4] = iArr[i4] + 1;
            }
        }
        int a3 = C3724h.m18746a(iArr);
        byte[] a4 = a.mo4316a();
        for (i = 0; i < c; i++) {
            int i5 = i * b;
            for (i2 = 0; i2 < b; i2++) {
                if ((a4[i5 + i2] & 255) < a3) {
                    c3717b.m18714b(i2, i);
                }
            }
        }
        return c3717b;
    }

    public C3723b mo4306a(C3824g c3824g) {
        return new C3724h(c3824g);
    }

    private void m18747a(int i) {
        if (this.f14484b.length < i) {
            this.f14484b = new byte[i];
        }
        for (int i2 = 0; i2 < 32; i2++) {
            this.f14485c[i2] = 0;
        }
    }

    private static int m18746a(int[] iArr) throws C3932i {
        int i;
        int i2;
        int i3 = 0;
        int length = iArr.length;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (i = 0; i < length; i++) {
            if (iArr[i] > i4) {
                i4 = iArr[i];
                i5 = i;
            }
            if (iArr[i] > i6) {
                i6 = iArr[i];
            }
        }
        i = 0;
        int i7 = 0;
        while (i3 < length) {
            i4 = i3 - i5;
            i4 *= iArr[i3] * i4;
            if (i4 > i) {
                i = i3;
            } else {
                i4 = i;
                i = i7;
            }
            i3++;
            i7 = i;
            i = i4;
        }
        if (i5 > i7) {
            i2 = i7;
            i7 = i5;
        } else {
            i2 = i5;
        }
        if (i7 - i2 <= (length >> 4)) {
            throw C3932i.m19565a();
        }
        i3 = i7 - 1;
        i5 = -1;
        i = i7 - 1;
        while (i > i2) {
            i4 = i - i2;
            i4 = ((i4 * i4) * (i7 - i)) * (i6 - iArr[i]);
            if (i4 > i5) {
                i5 = i;
            } else {
                i4 = i5;
                i5 = i3;
            }
            i--;
            i3 = i5;
            i5 = i4;
        }
        return i3 << 3;
    }
}
