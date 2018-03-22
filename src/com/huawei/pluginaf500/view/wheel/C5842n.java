package com.huawei.pluginaf500.view.wheel;

import android.os.Handler;
import android.os.Message;

/* compiled from: WheelView */
class C5842n extends Handler {
    final /* synthetic */ WheelView f20108a;

    C5842n(WheelView wheelView) {
        this.f20108a = wheelView;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        this.f20108a.f20042C.computeScrollOffset();
        int currY = this.f20108a.f20042C.getCurrY();
        int i = this.f20108a.f20043D - currY;
        this.f20108a.f20043D = currY;
        if (i != 0) {
            this.f20108a.m26943b(i);
        }
        if (Math.abs(currY - this.f20108a.f20042C.getFinalY()) < 1) {
            this.f20108a.f20042C.forceFinished(true);
        }
        if (!this.f20108a.f20042C.isFinished()) {
            this.f20108a.f20055Q.sendEmptyMessage(message.what);
        } else if (message.what == 0) {
            this.f20108a.m26958g();
        } else {
            this.f20108a.m26970c();
        }
    }
}
