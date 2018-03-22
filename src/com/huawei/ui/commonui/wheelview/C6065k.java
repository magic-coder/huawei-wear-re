package com.huawei.ui.commonui.wheelview;

/* compiled from: TrackTargetWheelView */
class C6065k implements Runnable {
    final /* synthetic */ int f20955a;
    final /* synthetic */ int f20956b;
    final /* synthetic */ C6063i f20957c;

    C6065k(C6063i c6063i, int i, int i2) {
        this.f20957c = c6063i;
        this.f20955a = i;
        this.f20956b = i2;
    }

    public void run() {
        this.f20957c.f20951a.smoothScrollTo(0, this.f20957c.f20951a.f20856e - this.f20955a);
        this.f20957c.f20951a.f20855d = this.f20956b + this.f20957c.f20951a.f20853b;
        this.f20957c.f20951a.m27666c();
    }
}
