package com.google.zxing;

import android.support.v4.view.ViewCompat;

/* compiled from: PlanarYUVLuminanceSource */
public final class C3933j extends C3824g {
    private final byte[] f15117a;
    private final int f15118b;
    private final int f15119c;
    private final int f15120d;
    private final int f15121e;

    public C3933j(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        super(i5, i6);
        if (i3 + i5 > i || i4 + i6 > i2) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f15117a = bArr;
        this.f15118b = i;
        this.f15119c = i2;
        this.f15120d = i3;
        this.f15121e = i4;
        if (z) {
            m19566a(i5, i6);
        }
    }

    public byte[] mo4317a(int i, byte[] bArr) {
        if (i < 0 || i >= m19083c()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i);
        }
        int b = m19082b();
        if (bArr == null || bArr.length < b) {
            bArr = new byte[b];
        }
        System.arraycopy(this.f15117a, ((this.f15121e + i) * this.f15118b) + this.f15120d, bArr, 0, b);
        return bArr;
    }

    public byte[] mo4316a() {
        int i = 0;
        int b = m19082b();
        int c = m19083c();
        if (b == this.f15118b && c == this.f15119c) {
            return this.f15117a;
        }
        int i2 = b * c;
        byte[] bArr = new byte[i2];
        int i3 = (this.f15121e * this.f15118b) + this.f15120d;
        if (b == this.f15118b) {
            System.arraycopy(this.f15117a, i3, bArr, 0, i2);
            return bArr;
        }
        Object obj = this.f15117a;
        while (i < c) {
            System.arraycopy(obj, i3, bArr, i * b, b);
            i3 += this.f15118b;
            i++;
        }
        return bArr;
    }

    public int[] m19569f() {
        int b = m19082b() / 2;
        int c = m19083c() / 2;
        int[] iArr = new int[(b * c)];
        byte[] bArr = this.f15117a;
        int i = (this.f15121e * this.f15118b) + this.f15120d;
        for (int i2 = 0; i2 < c; i2++) {
            int i3 = i2 * b;
            for (int i4 = 0; i4 < b; i4++) {
                iArr[i3 + i4] = ((bArr[(i4 * 2) + i] & 255) * 65793) | ViewCompat.MEASURED_STATE_MASK;
            }
            i += this.f15118b * 2;
        }
        return iArr;
    }

    public int m19570g() {
        return m19082b() / 2;
    }

    public int m19571h() {
        return m19083c() / 2;
    }

    private void m19566a(int i, int i2) {
        byte[] bArr = this.f15117a;
        int i3 = this.f15120d + (this.f15121e * this.f15118b);
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i3 + (i / 2);
            int i6 = (i3 + i) - 1;
            int i7 = i3;
            while (i7 < i5) {
                byte b = bArr[i7];
                bArr[i7] = bArr[i6];
                bArr[i6] = b;
                i7++;
                i6--;
            }
            i3 += this.f15118b;
        }
    }
}
