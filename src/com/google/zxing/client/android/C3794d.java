package com.google.zxing.client.android;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: CaptureActivity */
class C3794d implements OnClickListener {
    final /* synthetic */ CaptureActivity f14751a;

    C3794d(CaptureActivity captureActivity) {
        this.f14751a = captureActivity;
    }

    public void onClick(View view) {
        boolean z = false;
        if (this.f14751a.f14673u) {
            this.f14751a.f14654b.m18992a(false);
            this.f14751a.f14669q.setBackgroundResource(this.f14751a.f14676x.m19059b("sns_torch_off"));
        } else {
            this.f14751a.f14654b.m18992a(true);
            this.f14751a.f14669q.setBackgroundResource(this.f14751a.f14676x.m19059b("sns_torch_on"));
        }
        CaptureActivity captureActivity = this.f14751a;
        if (!this.f14751a.f14673u) {
            z = true;
        }
        captureActivity.f14673u = z;
    }
}
