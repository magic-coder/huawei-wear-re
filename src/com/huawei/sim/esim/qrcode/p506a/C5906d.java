package com.huawei.sim.esim.qrcode.p506a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.support.v4.view.ViewCompat;
import com.google.zxing.C3824g;

/* compiled from: PlanarYUVLuminanceSource */
public final class C5906d extends C3824g {
    private final byte[] f20244a;
    private final int f20245b;
    private final int f20246c;
    private final int f20247d;
    private final int f20248e;

    public C5906d(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6) {
        super(i5, i6);
        if (i3 + i5 > i || i4 + i6 > i2) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        if (bArr != null) {
            this.f20244a = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.f20244a, 0, bArr.length);
        } else {
            this.f20244a = null;
        }
        this.f20247d = i;
        this.f20248e = i2;
        this.f20245b = i3;
        this.f20246c = i4;
    }

    public byte[] mo4316a() {
        int i = 0;
        int b = m19082b();
        int c = m19083c();
        if (b != this.f20247d || c != this.f20248e) {
            int i2 = b * c;
            byte[] bArr = new byte[i2];
            int i3 = (this.f20246c * this.f20247d) + this.f20245b;
            if (b == this.f20247d) {
                System.arraycopy(this.f20244a, i3, bArr, 0, i2);
                return bArr;
            }
            Object obj = this.f20244a;
            while (i < c) {
                System.arraycopy(obj, i3, bArr, i * b, b);
                i3 += this.f20247d;
                i++;
            }
            return bArr;
        } else if (this.f20244a == null) {
            return null;
        } else {
            Object obj2 = new byte[this.f20244a.length];
            System.arraycopy(this.f20244a, 0, obj2, 0, this.f20244a.length);
            return obj2;
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
        System.arraycopy(this.f20244a, ((this.f20246c + i) * this.f20247d) + this.f20245b, bArr, 0, b);
        return bArr;
    }

    public Bitmap m27173f() {
        int b = m19082b();
        int c = m19083c();
        int[] iArr = new int[(b * c)];
        byte[] bArr = this.f20244a;
        int i = (this.f20246c * this.f20247d) + this.f20245b;
        for (int i2 = 0; i2 < c; i2++) {
            int i3 = i2 * b;
            for (int i4 = 0; i4 < b; i4++) {
                iArr[i3 + i4] = ((bArr[i + i4] & 255) * 65793) | ViewCompat.MEASURED_STATE_MASK;
            }
            i += this.f20247d;
        }
        Bitmap createBitmap = Bitmap.createBitmap(b, c, Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, b, 0, 0, b, c);
        return createBitmap;
    }
}
