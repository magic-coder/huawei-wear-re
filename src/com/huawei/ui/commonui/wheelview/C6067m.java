package com.huawei.ui.commonui.wheelview;

/* compiled from: TrackTargetWheelView */
class C6067m implements Runnable {
    final /* synthetic */ TrackTargetWheelView f20959a;

    C6067m(TrackTargetWheelView trackTargetWheelView) {
        this.f20959a = trackTargetWheelView;
    }

    public void run() {
        this.f20959a.smoothScrollTo(0, this.f20959a.f20855d * this.f20959a.f20859h);
    }
}
