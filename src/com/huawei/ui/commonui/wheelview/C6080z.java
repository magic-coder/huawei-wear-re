package com.huawei.ui.commonui.wheelview;

import android.os.Handler;
import android.os.Message;

/* compiled from: WheelView */
class C6080z extends Handler {
    final /* synthetic */ WheelView f20990a;

    C6080z(WheelView wheelView) {
        this.f20990a = wheelView;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        this.f20990a.f20878D.computeScrollOffset();
        int currY = this.f20990a.f20878D.getCurrY();
        int i = this.f20990a.f20879E - currY;
        this.f20990a.f20879E = currY;
        if (i != 0) {
            this.f20990a.m27679b(i);
        }
        if (Math.abs(currY - this.f20990a.f20878D.getFinalY()) < 1) {
            this.f20990a.f20878D.forceFinished(true);
        }
        if (!this.f20990a.f20878D.isFinished()) {
            this.f20990a.f20888N.sendEmptyMessage(message.what);
        } else if (message.what == 0) {
            this.f20990a.m27691f();
        } else {
            this.f20990a.m27705c();
        }
    }
}
