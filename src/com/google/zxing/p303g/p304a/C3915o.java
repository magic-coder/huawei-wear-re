package com.google.zxing.p303g.p304a;

/* compiled from: FormatInformation */
final class C3915o {
    private static final int[][] f15058a;
    private static final int[] f15059b;
    private final C3914n f15060c;
    private final byte f15061d;

    static {
        r0 = new int[32][];
        int[] iArr = new int[]{21522, iArr};
        r0[1] = new int[]{20773, 1};
        r0[2] = new int[]{24188, 2};
        r0[3] = new int[]{23371, 3};
        r0[4] = new int[]{17913, 4};
        r0[5] = new int[]{16590, 5};
        r0[6] = new int[]{20375, 6};
        r0[7] = new int[]{19104, 7};
        r0[8] = new int[]{30660, 8};
        r0[9] = new int[]{29427, 9};
        r0[10] = new int[]{32170, 10};
        r0[11] = new int[]{30877, 11};
        r0[12] = new int[]{26159, 12};
        r0[13] = new int[]{25368, 13};
        r0[14] = new int[]{27713, 14};
        r0[15] = new int[]{26998, 15};
        r0[16] = new int[]{5769, 16};
        r0[17] = new int[]{5054, 17};
        r0[18] = new int[]{7399, 18};
        r0[19] = new int[]{6608, 19};
        r0[20] = new int[]{1890, 20};
        r0[21] = new int[]{597, 21};
        r0[22] = new int[]{3340, 22};
        r0[23] = new int[]{2107, 23};
        r0[24] = new int[]{13663, 24};
        r0[25] = new int[]{12392, 25};
        r0[26] = new int[]{16177, 26};
        r0[27] = new int[]{14854, 27};
        r0[28] = new int[]{9396, 28};
        r0[29] = new int[]{8579, 29};
        r0[30] = new int[]{11994, 30};
        r0[31] = new int[]{11245, 31};
        f15058a = r0;
        int[] iArr2 = new int[16];
        iArr2[1] = 1;
        iArr2[2] = 1;
        iArr2[3] = 2;
        iArr2[4] = 1;
        iArr2[5] = 2;
        iArr2[6] = 2;
        iArr2[7] = 3;
        iArr2[8] = 1;
        iArr2[9] = 2;
        iArr2[10] = 2;
        iArr2[11] = 3;
        iArr2[12] = 2;
        iArr2[13] = 3;
        iArr2[14] = 3;
        iArr2[15] = 4;
        f15059b = iArr2;
    }

    private C3915o(int i) {
        this.f15060c = C3914n.m19492a((i >> 3) & 3);
        this.f15061d = (byte) (i & 7);
    }

    static int m19493a(int i, int i2) {
        int i3 = i ^ i2;
        return f15059b[(i3 >>> 28) & 15] + ((((((f15059b[i3 & 15] + f15059b[(i3 >>> 4) & 15]) + f15059b[(i3 >>> 8) & 15]) + f15059b[(i3 >>> 12) & 15]) + f15059b[(i3 >>> 16) & 15]) + f15059b[(i3 >>> 20) & 15]) + f15059b[(i3 >>> 24) & 15]);
    }

    static C3915o m19494b(int i, int i2) {
        C3915o c = C3915o.m19495c(i, i2);
        return c != null ? c : C3915o.m19495c(i ^ 21522, i2 ^ 21522);
    }

    private static C3915o m19495c(int i, int i2) {
        int i3 = Integer.MAX_VALUE;
        int[][] iArr = f15058a;
        int length = iArr.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int[] iArr2 = iArr[i4];
            int i6 = iArr2[0];
            if (i6 == i || i6 == i2) {
                return new C3915o(iArr2[1]);
            }
            int i7;
            int a = C3915o.m19493a(i, i6);
            if (a < i3) {
                i3 = iArr2[1];
            } else {
                a = i3;
                i3 = i5;
            }
            if (i != i2) {
                i5 = C3915o.m19493a(i2, i6);
                if (i5 < a) {
                    i3 = iArr2[1];
                    i4++;
                    i7 = i3;
                    i3 = i5;
                    i5 = i7;
                }
            }
            i5 = a;
            i4++;
            i7 = i3;
            i3 = i5;
            i5 = i7;
        }
        if (i3 <= 3) {
            return new C3915o(i5);
        }
        return null;
    }

    C3914n m19496a() {
        return this.f15060c;
    }

    byte m19497b() {
        return this.f15061d;
    }

    public int hashCode() {
        return (this.f15060c.ordinal() << 3) | this.f15061d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C3915o)) {
            return false;
        }
        C3915o c3915o = (C3915o) obj;
        if (this.f15060c == c3915o.f15060c && this.f15061d == c3915o.f15061d) {
            return true;
        }
        return false;
    }
}
