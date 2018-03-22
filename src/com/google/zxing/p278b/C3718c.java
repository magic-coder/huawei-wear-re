package com.google.zxing.p278b;

/* compiled from: BitSource */
public final class C3718c {
    private final byte[] f14439a;
    private int f14440b;
    private int f14441c;

    public C3718c(byte[] bArr) {
        this.f14439a = bArr;
    }

    public int m18721a() {
        return this.f14441c;
    }

    public int m18723b() {
        return this.f14440b;
    }

    public int m18722a(int i) {
        if (i < 1 || i > 32 || i > m18724c()) {
            throw new IllegalArgumentException(String.valueOf(i));
        }
        int i2;
        int i3;
        if (this.f14441c > 0) {
            i2 = 8 - this.f14441c;
            i3 = i < i2 ? i : i2;
            i2 -= i3;
            i2 = (((255 >> (8 - i3)) << i2) & this.f14439a[this.f14440b]) >> i2;
            i -= i3;
            this.f14441c = i3 + this.f14441c;
            if (this.f14441c == 8) {
                this.f14441c = 0;
                this.f14440b++;
            }
            i3 = i2;
            i2 = i;
        } else {
            i3 = 0;
            i2 = i;
        }
        if (i2 <= 0) {
            return i3;
        }
        while (i2 >= 8) {
            i3 = (i3 << 8) | (this.f14439a[this.f14440b] & 255);
            this.f14440b++;
            i2 -= 8;
        }
        if (i2 <= 0) {
            return i3;
        }
        int i4 = 8 - i2;
        i3 = (i3 << i2) | ((((255 >> i4) << i4) & this.f14439a[this.f14440b]) >> i4);
        this.f14441c = i2 + this.f14441c;
        return i3;
    }

    public int m18724c() {
        return ((this.f14439a.length - this.f14440b) * 8) - this.f14441c;
    }
}
