package com.huawei.ui.commonui.wheelview;

import android.util.Log;

/* compiled from: TrackTargetWheelView */
class C6063i implements Runnable {
    final /* synthetic */ TrackTargetWheelView f20951a;

    C6063i(TrackTargetWheelView trackTargetWheelView) {
        this.f20951a = trackTargetWheelView;
    }

    public void run() {
        Log.i(TrackTargetWheelView.f20852a, "scrollerTask");
        if (this.f20951a.f20856e - this.f20951a.getScrollY() == 0) {
            int i = this.f20951a.f20856e % this.f20951a.f20859h;
            int i2 = this.f20951a.f20856e / this.f20951a.f20859h;
            if (i == 0) {
                this.f20951a.f20855d = i2 + this.f20951a.f20853b;
                this.f20951a.m27666c();
                return;
            } else if (i > this.f20951a.f20859h / 2) {
                this.f20951a.post(new C6064j(this, i, i2));
                return;
            } else {
                this.f20951a.post(new C6065k(this, i, i2));
                return;
            }
        }
        this.f20951a.f20856e = this.f20951a.getScrollY();
        this.f20951a.postDelayed(this.f20951a.f20857f, (long) this.f20951a.f20858g);
    }
}
