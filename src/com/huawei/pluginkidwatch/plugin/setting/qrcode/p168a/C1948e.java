package com.huawei.pluginkidwatch.plugin.setting.qrcode.p168a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.support.v4.view.ViewCompat;
import com.google.zxing.g;

/* compiled from: PlanarYUVLuminanceSource */
public final class C1948e extends g {
    private final byte[] f6773a;
    private final int f6774b;
    private final int f6775c;
    private final int f6776d;
    private final int f6777e;

    public C1948e(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6) {
        super(i5, i6);
        if (i3 + i5 > i || i4 + i6 > i2) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        if (bArr != null) {
            this.f6773a = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.f6773a, 0, bArr.length);
        } else {
            this.f6773a = null;
        }
        this.f6774b = i;
        this.f6775c = i2;
        this.f6776d = i3;
        this.f6777e = i4;
    }

    public byte[] m10206a(int i, byte[] bArr) {
        if (i < 0 || i >= c()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i);
        }
        int b = b();
        if (bArr == null || bArr.length < b) {
            bArr = new byte[b];
        }
        System.arraycopy(this.f6773a, ((this.f6777e + i) * this.f6774b) + this.f6776d, bArr, 0, b);
        return bArr;
    }

    public byte[] m10205a() {
        int i = 0;
        int b = b();
        int c = c();
        if (b != this.f6774b || c != this.f6775c) {
            int i2 = b * c;
            byte[] bArr = new byte[i2];
            int i3 = (this.f6777e * this.f6774b) + this.f6776d;
            if (b == this.f6774b) {
                System.arraycopy(this.f6773a, i3, bArr, 0, i2);
                return bArr;
            }
            Object obj = this.f6773a;
            while (i < c) {
                System.arraycopy(obj, i3, bArr, i * b, b);
                i3 += this.f6774b;
                i++;
            }
            return bArr;
        } else if (this.f6773a == null) {
            return null;
        } else {
            Object obj2 = new byte[this.f6773a.length];
            System.arraycopy(this.f6773a, 0, obj2, 0, this.f6773a.length);
            return obj2;
        }
    }

    public Bitmap m10207f() {
        int b = b();
        int c = c();
        int[] iArr = new int[(b * c)];
        byte[] bArr = this.f6773a;
        int i = (this.f6777e * this.f6774b) + this.f6776d;
        for (int i2 = 0; i2 < c; i2++) {
            int i3 = i2 * b;
            for (int i4 = 0; i4 < b; i4++) {
                iArr[i3 + i4] = ((bArr[i + i4] & 255) * 65793) | ViewCompat.MEASURED_STATE_MASK;
            }
            i += this.f6774b;
        }
        Bitmap createBitmap = Bitmap.createBitmap(b, c, Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, b, 0, 0, b, c);
        return createBitmap;
    }
}
