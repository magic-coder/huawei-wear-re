package com.huawei.ui.device.views.device;

import com.huawei.p190v.C2538c;

/* compiled from: RoundProgressImageView */
class C2205l implements Runnable {
    final /* synthetic */ RoundProgressImageView f7906a;
    private Thread f7907b = new Thread(this);

    public C2205l(RoundProgressImageView roundProgressImageView) {
        this.f7906a = roundProgressImageView;
        this.f7907b.start();
    }

    public void run() {
        while (this.f7906a.f7846m) {
            this.f7906a.postInvalidate();
            try {
                Thread.sleep(50);
                this.f7906a.f7840g = this.f7906a.f7840g + 10.138f;
            } catch (InterruptedException e) {
                C2538c.m12680e("ProgressBarView", "InterruptedException = " + e.getMessage());
            }
        }
    }
}
