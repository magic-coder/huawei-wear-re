package com.huawei.ui.commonui.wheelview;

/* compiled from: TrackTargetWheelView */
class C6064j implements Runnable {
    final /* synthetic */ int f20952a;
    final /* synthetic */ int f20953b;
    final /* synthetic */ C6063i f20954c;

    C6064j(C6063i c6063i, int i, int i2) {
        this.f20954c = c6063i;
        this.f20952a = i;
        this.f20953b = i2;
    }

    public void run() {
        this.f20954c.f20951a.smoothScrollTo(0, (this.f20954c.f20951a.f20856e - this.f20952a) + this.f20954c.f20951a.f20859h);
        this.f20954c.f20951a.f20855d = (this.f20953b + this.f20954c.f20951a.f20853b) + 1;
        this.f20954c.f20951a.m27666c();
    }
}
