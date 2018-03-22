package com.google.zxing.p282c.p283a;

/* compiled from: DataBlock */
final class C3729b {
    private final int f14501a;
    private final byte[] f14502b;

    private C3729b(int i, byte[] bArr) {
        this.f14501a = i;
        this.f14502b = bArr;
    }

    static C3729b[] m18774a(byte[] bArr, C3733f c3733f) {
        int i;
        int i2;
        C3735h g = c3733f.m18797g();
        C3734g[] b = g.m18801b();
        int i3 = 0;
        for (C3734g a : b) {
            i3 += a.m18798a();
        }
        C3729b[] c3729bArr = new C3729b[i3];
        int length = b.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            C3734g c3734g = b[i4];
            i3 = i5;
            i5 = 0;
            while (i5 < c3734g.m18798a()) {
                int b2 = c3734g.m18799b();
                i = i3 + 1;
                c3729bArr[i3] = new C3729b(b2, new byte[(g.m18800a() + b2)]);
                i5++;
                i3 = i;
            }
            i4++;
            i5 = i3;
        }
        i = c3729bArr[0].f14502b.length - g.m18800a();
        length = i - 1;
        int i6 = 0;
        for (i2 = 0; i2 < length; i2++) {
            i3 = 0;
            while (i3 < i5) {
                i4 = i6 + 1;
                c3729bArr[i3].f14502b[i2] = bArr[i6];
                i3++;
                i6 = i4;
            }
        }
        if (c3733f.m18791a() == 24) {
            length = 1;
        } else {
            length = 0;
        }
        if (length != 0) {
            i3 = 8;
        } else {
            i3 = i5;
        }
        i4 = 0;
        while (i4 < i3) {
            i2 = i6 + 1;
            c3729bArr[i4].f14502b[i - 1] = bArr[i6];
            i4++;
            i6 = i2;
        }
        int length2 = c3729bArr[0].f14502b.length;
        i3 = i6;
        while (i < length2) {
            i4 = 0;
            i6 = i3;
            while (i4 < i5) {
                if (length == 0 || i4 <= 7) {
                    i3 = i;
                } else {
                    i3 = i - 1;
                }
                i2 = i6 + 1;
                c3729bArr[i4].f14502b[i3] = bArr[i6];
                i4++;
                i6 = i2;
            }
            i++;
            i3 = i6;
        }
        if (i3 == bArr.length) {
            return c3729bArr;
        }
        throw new IllegalArgumentException();
    }

    int m18775a() {
        return this.f14501a;
    }

    byte[] m18776b() {
        return this.f14502b;
    }
}
