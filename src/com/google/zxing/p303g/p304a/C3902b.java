package com.google.zxing.p303g.p304a;

/* compiled from: DataBlock */
final class C3902b {
    private final int f15046a;
    private final byte[] f15047b;

    private C3902b(int i, byte[] bArr) {
        this.f15046a = i;
        this.f15047b = bArr;
    }

    static C3902b[] m19467a(byte[] bArr, C3918r c3918r, C3914n c3914n) {
        if (bArr.length != c3918r.m19508c()) {
            throw new IllegalArgumentException();
        }
        int i;
        C3920t a = c3918r.m19506a(c3914n);
        C3919s[] b = a.m19514b();
        int i2 = 0;
        for (C3919s a2 : b) {
            i2 += a2.m19511a();
        }
        C3902b[] c3902bArr = new C3902b[i2];
        int length = b.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            C3919s c3919s = b[i3];
            i2 = i4;
            i4 = 0;
            while (i4 < c3919s.m19511a()) {
                int b2 = c3919s.m19512b();
                i = i2 + 1;
                c3902bArr[i2] = new C3902b(b2, new byte[(a.m19513a() + b2)]);
                i4++;
                i2 = i;
            }
            i3++;
            i4 = i2;
        }
        i = c3902bArr[0].f15047b.length;
        i2 = c3902bArr.length - 1;
        while (i2 >= 0 && c3902bArr[i2].f15047b.length != i) {
            i2--;
        }
        length = i2 + 1;
        i -= a.m19513a();
        int i5 = 0;
        i2 = 0;
        while (i5 < i) {
            i3 = i2;
            i2 = 0;
            while (i2 < i4) {
                int i6 = i3 + 1;
                c3902bArr[i2].f15047b[i5] = bArr[i3];
                i2++;
                i3 = i6;
            }
            i5++;
            i2 = i3;
        }
        i3 = length;
        while (i3 < i4) {
            i6 = i2 + 1;
            c3902bArr[i3].f15047b[i] = bArr[i2];
            i3++;
            i2 = i6;
        }
        int length2 = c3902bArr[0].f15047b.length;
        while (i < length2) {
            i3 = 0;
            i6 = i2;
            while (i3 < i4) {
                i5 = i6 + 1;
                c3902bArr[i3].f15047b[i3 < length ? i : i + 1] = bArr[i6];
                i3++;
                i6 = i5;
            }
            i++;
            i2 = i6;
        }
        return c3902bArr;
    }

    int m19468a() {
        return this.f15046a;
    }

    byte[] m19469b() {
        return this.f15047b;
    }
}
