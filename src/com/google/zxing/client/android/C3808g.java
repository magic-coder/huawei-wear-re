package com.google.zxing.client.android;

import android.graphics.Bitmap;
import com.google.zxing.client.android.p290c.C3787e;

/* compiled from: CaptureActivity */
class C3808g implements C3787e {
    final /* synthetic */ CaptureActivity f14815a;

    C3808g(CaptureActivity captureActivity) {
        this.f14815a = captureActivity;
    }

    public void mo4313a(Bitmap bitmap, int i) {
        if (this.f14815a.f14670r != null && this.f14815a.f14671s != null) {
            if (bitmap != null) {
                this.f14815a.f14670r.setImageBitmap(bitmap);
                this.f14815a.f14671s.setVisibility(8);
                return;
            }
            if (i == 1) {
                this.f14815a.m18945k();
            }
            this.f14815a.f14671s.setVisibility(0);
        }
    }
}
