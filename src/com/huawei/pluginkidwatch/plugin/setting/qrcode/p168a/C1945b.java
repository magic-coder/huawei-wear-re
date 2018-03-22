package com.huawei.pluginkidwatch.plugin.setting.qrcode.p168a;

import android.graphics.Bitmap;
import com.google.zxing.g;

/* compiled from: BitmapLuminanceSource */
public class C1945b extends g {
    private byte[] f6753a;

    public C1945b(Bitmap bitmap) {
        int i = 0;
        super(bitmap.getWidth(), bitmap.getHeight());
        int[] iArr = new int[(bitmap.getWidth() * bitmap.getHeight())];
        this.f6753a = new byte[(bitmap.getWidth() * bitmap.getHeight())];
        bitmap.getPixels(iArr, 0, b(), 0, 0, b(), c());
        while (i < iArr.length) {
            this.f6753a[i] = (byte) iArr[i];
            i++;
        }
    }

    public byte[] m10179a() {
        if (this.f6753a == null) {
            return null;
        }
        Object obj = new byte[this.f6753a.length];
        System.arraycopy(this.f6753a, 0, obj, 0, this.f6753a.length);
        return obj;
    }

    public byte[] m10180a(int i, byte[] bArr) {
        System.arraycopy(this.f6753a, b() * i, bArr, 0, b());
        return bArr;
    }
}
