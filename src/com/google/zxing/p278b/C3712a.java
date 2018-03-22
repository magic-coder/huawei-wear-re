package com.google.zxing.p278b;

/* compiled from: BitArray */
public final class C3712a {
    private int[] f14414a;
    private int f14415b;

    public C3712a() {
        this.f14415b = 0;
        this.f14414a = new int[1];
    }

    public C3712a(int i) {
        this.f14415b = i;
        this.f14414a = C3712a.m18675e(i);
    }

    public int m18676a() {
        return this.f14415b;
    }

    public boolean m18678a(int i) {
        return (this.f14414a[i / 32] & (1 << (i & 31))) != 0;
    }

    public void m18681b(int i) {
        int[] iArr = this.f14414a;
        int i2 = i / 32;
        iArr[i2] = iArr[i2] | (1 << (i & 31));
    }

    public int m18682c(int i) {
        if (i >= this.f14415b) {
            return this.f14415b;
        }
        int i2 = i / 32;
        int i3 = this.f14414a[i2] & (((1 << (i & 31)) - 1) ^ -1);
        while (i3 == 0) {
            i2++;
            if (i2 == this.f14414a.length) {
                return this.f14415b;
            }
            i3 = this.f14414a[i2];
        }
        i3 = Integer.numberOfTrailingZeros(i3) + (i2 * 32);
        if (i3 > this.f14415b) {
            return this.f14415b;
        }
        return i3;
    }

    public int m18684d(int i) {
        if (i >= this.f14415b) {
            return this.f14415b;
        }
        int i2 = i / 32;
        int i3 = (this.f14414a[i2] ^ -1) & (((1 << (i & 31)) - 1) ^ -1);
        while (i3 == 0) {
            i2++;
            if (i2 == this.f14414a.length) {
                return this.f14415b;
            }
            i3 = this.f14414a[i2] ^ -1;
        }
        i3 = Integer.numberOfTrailingZeros(i3) + (i2 * 32);
        if (i3 > this.f14415b) {
            return this.f14415b;
        }
        return i3;
    }

    public void m18677a(int i, int i2) {
        this.f14414a[i / 32] = i2;
    }

    public void m18680b() {
        int length = this.f14414a.length;
        for (int i = 0; i < length; i++) {
            this.f14414a[i] = 0;
        }
    }

    public boolean m18679a(int i, int i2, boolean z) {
        if (i2 < i) {
            throw new IllegalArgumentException();
        } else if (i2 == i) {
            return true;
        } else {
            int i3 = i2 - 1;
            int i4 = i / 32;
            int i5 = i3 / 32;
            int i6 = i4;
            while (i6 <= i5) {
                int i7;
                int i8 = i6 > i4 ? 0 : i & 31;
                int i9 = i6 < i5 ? 31 : i3 & 31;
                if (i8 == 0 && i9 == 31) {
                    i8 = -1;
                } else {
                    i7 = i8;
                    i8 = 0;
                    while (i7 <= i9) {
                        int i10 = (1 << i7) | i8;
                        i7++;
                        i8 = i10;
                    }
                }
                i7 = this.f14414a[i6] & i8;
                if (!z) {
                    i8 = 0;
                }
                if (i7 != i8) {
                    return false;
                }
                i6++;
            }
            return true;
        }
    }

    public int[] m18683c() {
        return this.f14414a;
    }

    public void m18685d() {
        int i;
        int i2 = 1;
        int[] iArr = new int[this.f14414a.length];
        int i3 = (this.f14415b - 1) / 32;
        int i4 = i3 + 1;
        for (i = 0; i < i4; i++) {
            long j = (long) this.f14414a[i];
            j = ((j & 1431655765) << 1) | ((j >> 1) & 1431655765);
            j = ((j & 858993459) << 2) | ((j >> 2) & 858993459);
            j = ((j & 252645135) << 4) | ((j >> 4) & 252645135);
            j = ((j & 16711935) << 8) | ((j >> 8) & 16711935);
            iArr[i3 - i] = (int) (((j & 65535) << 16) | ((j >> 16) & 65535));
        }
        if (this.f14415b != i4 * 32) {
            int i5 = (i4 * 32) - this.f14415b;
            i3 = 1;
            for (i = 0; i < 31 - i5; i++) {
                i3 = (i3 << 1) | 1;
            }
            i = (iArr[0] >> i5) & i3;
            while (i2 < i4) {
                int i6 = iArr[i2];
                iArr[i2 - 1] = i | (i6 << (32 - i5));
                i = (i6 >> i5) & i3;
                i2++;
            }
            iArr[i4 - 1] = i;
        }
        this.f14414a = iArr;
    }

    private static int[] m18675e(int i) {
        return new int[((i + 31) / 32)];
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.f14415b);
        for (int i = 0; i < this.f14415b; i++) {
            if ((i & 7) == 0) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(m18678a(i) ? 'X' : '.');
        }
        return stringBuilder.toString();
    }
}
