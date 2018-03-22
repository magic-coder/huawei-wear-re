package com.google.zxing.p278b;

/* compiled from: BitMatrix */
public final class C3717b {
    private final int f14435a;
    private final int f14436b;
    private final int f14437c;
    private final int[] f14438d;

    public C3717b(int i) {
        this(i, i);
    }

    public C3717b(int i, int i2) {
        if (i < 1 || i2 < 1) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f14435a = i;
        this.f14436b = i2;
        this.f14437c = (i + 31) >> 5;
        this.f14438d = new int[(this.f14437c * i2)];
    }

    public boolean m18712a(int i, int i2) {
        return ((this.f14438d[(this.f14437c * i2) + (i >> 5)] >>> (i & 31)) & 1) != 0;
    }

    public void m18714b(int i, int i2) {
        int i3 = (this.f14437c * i2) + (i >> 5);
        int[] iArr = this.f14438d;
        iArr[i3] = iArr[i3] | (1 << (i & 31));
    }

    public void m18717c(int i, int i2) {
        int i3 = (this.f14437c * i2) + (i >> 5);
        int[] iArr = this.f14438d;
        iArr[i3] = iArr[i3] ^ (1 << (i & 31));
    }

    public void m18711a(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        } else if (i4 < 1 || i3 < 1) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        } else {
            int i5 = i + i3;
            int i6 = i2 + i4;
            if (i6 > this.f14436b || i5 > this.f14435a) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i2 < i6) {
                int i7 = i2 * this.f14437c;
                for (int i8 = i; i8 < i5; i8++) {
                    int[] iArr = this.f14438d;
                    int i9 = (i8 >> 5) + i7;
                    iArr[i9] = iArr[i9] | (1 << (i8 & 31));
                }
                i2++;
            }
        }
    }

    public C3712a m18710a(int i, C3712a c3712a) {
        if (c3712a == null || c3712a.m18676a() < this.f14435a) {
            c3712a = new C3712a(this.f14435a);
        }
        int i2 = i * this.f14437c;
        for (int i3 = 0; i3 < this.f14437c; i3++) {
            c3712a.m18677a(i3 << 5, this.f14438d[i2 + i3]);
        }
        return c3712a;
    }

    public void m18715b(int i, C3712a c3712a) {
        System.arraycopy(c3712a.m18683c(), 0, this.f14438d, this.f14437c * i, this.f14437c);
    }

    public int[] m18713a() {
        int i = this.f14435a;
        int i2 = this.f14436b;
        int i3 = i;
        i = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < this.f14436b; i5++) {
            int i6 = 0;
            while (i6 < this.f14437c) {
                int i7;
                int i8 = this.f14438d[(this.f14437c * i5) + i6];
                if (i8 != 0) {
                    if (i5 < i2) {
                        i2 = i5;
                    }
                    if (i5 > i4) {
                        i4 = i5;
                    }
                    if (i6 * 32 < i3) {
                        i7 = 0;
                        while ((i8 << (31 - i7)) == 0) {
                            i7++;
                        }
                        if ((i6 * 32) + i7 < i3) {
                            i7 = (i6 * 32) + i7;
                            if ((i6 * 32) + 31 > i) {
                                i3 = 31;
                                while ((i8 >>> i3) == 0) {
                                    i3--;
                                }
                                if ((i6 * 32) + i3 > i) {
                                    i = (i6 * 32) + i3;
                                    i3 = i2;
                                    i2 = i;
                                    i = i4;
                                }
                            }
                            i3 = i2;
                            i2 = i;
                            i = i4;
                        }
                    }
                    i7 = i3;
                    if ((i6 * 32) + 31 > i) {
                        i3 = 31;
                        while ((i8 >>> i3) == 0) {
                            i3--;
                        }
                        if ((i6 * 32) + i3 > i) {
                            i = (i6 * 32) + i3;
                            i3 = i2;
                            i2 = i;
                            i = i4;
                        }
                    }
                    i3 = i2;
                    i2 = i;
                    i = i4;
                } else {
                    i7 = i3;
                    i3 = i2;
                    i2 = i;
                    i = i4;
                }
                i6++;
                i4 = i;
                i = i2;
                i2 = i3;
                i3 = i7;
            }
        }
        i4 -= i2;
        if (i - i3 < 0 || i4 < 0) {
            return null;
        }
        return new int[]{i3, i2, i, i4};
    }

    public int[] m18716b() {
        int i = 0;
        while (i < this.f14438d.length && this.f14438d[i] == 0) {
            i++;
        }
        if (i == this.f14438d.length) {
            return null;
        }
        int i2 = i / this.f14437c;
        int i3 = (i % this.f14437c) << 5;
        int i4 = this.f14438d[i];
        i = 0;
        while ((i4 << (31 - i)) == 0) {
            i++;
        }
        i3 += i;
        return new int[]{i3, i2};
    }

    public int[] m18718c() {
        int length = this.f14438d.length - 1;
        while (length >= 0 && this.f14438d[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i = length / this.f14437c;
        int i2 = (length % this.f14437c) << 5;
        int i3 = this.f14438d[length];
        length = 31;
        while ((i3 >>> length) == 0) {
            length--;
        }
        i2 += length;
        return new int[]{i2, i};
    }

    public int m18719d() {
        return this.f14435a;
    }

    public int m18720e() {
        return this.f14436b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C3717b)) {
            return false;
        }
        C3717b c3717b = (C3717b) obj;
        if (this.f14435a != c3717b.f14435a || this.f14436b != c3717b.f14436b || this.f14437c != c3717b.f14437c || this.f14438d.length != c3717b.f14438d.length) {
            return false;
        }
        for (int i = 0; i < this.f14438d.length; i++) {
            if (this.f14438d[i] != c3717b.f14438d[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = this.f14437c + (((((this.f14435a * 31) + this.f14435a) * 31) + this.f14436b) * 31);
        for (int i2 : this.f14438d) {
            i = (i * 31) + i2;
        }
        return i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.f14436b * (this.f14435a + 1));
        for (int i = 0; i < this.f14436b; i++) {
            for (int i2 = 0; i2 < this.f14435a; i2++) {
                stringBuilder.append(m18712a(i2, i) ? "X " : "  ");
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
