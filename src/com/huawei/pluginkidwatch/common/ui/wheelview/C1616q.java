package com.huawei.pluginkidwatch.common.ui.wheelview;

import android.os.Handler;
import android.os.Message;

/* compiled from: WheelView */
class C1616q extends Handler {
    final /* synthetic */ WheelView f4101a;

    C1616q(WheelView wheelView) {
        this.f4101a = wheelView;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        this.f4101a.f4019E.computeScrollOffset();
        int currY = this.f4101a.f4019E.getCurrY();
        int i = this.f4101a.f4020F - currY;
        this.f4101a.f4020F = currY;
        if (i != 0) {
            this.f4101a.m7380b(i);
        }
        if (Math.abs(currY - this.f4101a.f4019E.getFinalY()) < 1) {
            this.f4101a.f4019E.forceFinished(true);
        }
        if (!this.f4101a.f4019E.isFinished()) {
            this.f4101a.ac.sendEmptyMessage(message.what);
        } else if (message.what == 0) {
            this.f4101a.m7395g();
        } else {
            this.f4101a.m7408c();
        }
    }
}
