package com.google.zxing.p303g.p304a;

import com.google.zxing.C3922o;

/* compiled from: QRCodeDecoderMetaData */
public final class C3917q {
    private final boolean f15075a;

    C3917q(boolean z) {
        this.f15075a = z;
    }

    public void m19500a(C3922o[] c3922oArr) {
        if (this.f15075a && c3922oArr != null && c3922oArr.length >= 3) {
            C3922o c3922o = c3922oArr[0];
            c3922oArr[0] = c3922oArr[2];
            c3922oArr[2] = c3922o;
        }
    }
}
