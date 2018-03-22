package com.google.zxing.client.android;

import android.graphics.Bitmap;
import com.google.zxing.C3824g;

/* compiled from: RGBLuminanceSource */
public class C3825w extends C3824g {
    private final byte[] f14839a;

    public C3825w(Bitmap bitmap) {
        super(bitmap.getWidth(), bitmap.getHeight());
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[(width * height)];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        this.f14839a = new byte[(width * height)];
        for (int i = 0; i < height; i++) {
            int i2 = i * width;
            for (int i3 = 0; i3 < width; i3++) {
                int i4 = iArr[i2 + i3];
                int i5 = (i4 >> 16) & 255;
                int i6 = (i4 >> 8) & 255;
                i4 &= 255;
                if (i5 == i6 && i6 == i4) {
                    this.f14839a[i2 + i3] = (byte) i5;
                } else {
                    this.f14839a[i2 + i3] = (byte) ((i4 + ((i5 + i6) + i6)) >> 2);
                }
            }
        }
    }

    public byte[] mo4316a() {
        return this.f14839a;
    }

    public byte[] mo4317a(int i, byte[] bArr) {
        if (i < 0 || i >= m19083c()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i);
        }
        int b = m19082b();
        if (bArr == null || bArr.length < b) {
            bArr = new byte[b];
        }
        System.arraycopy(this.f14839a, i * b, bArr, 0, b);
        return bArr;
    }
}
