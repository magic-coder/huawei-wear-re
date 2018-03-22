package com.huawei.ui.commonui.wheelview21;

import android.os.Handler;
import android.os.Message;

/* compiled from: WheelView */
class C6090h extends Handler {
    final /* synthetic */ WheelView f21047a;

    C6090h(WheelView wheelView) {
        this.f21047a = wheelView;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        this.f21047a.f21019u.computeScrollOffset();
        int currY = this.f21047a.f21019u.getCurrY();
        int i = this.f21047a.f21020v - currY;
        this.f21047a.f21020v = currY;
        if (i != 0) {
            this.f21047a.m27777c(i);
        }
        if (Math.abs(currY - this.f21047a.f21019u.getFinalY()) < 1) {
            this.f21047a.f21019u.forceFinished(true);
        }
        if (!this.f21047a.f21019u.isFinished()) {
            this.f21047a.f20998H.sendEmptyMessage(message.what);
        } else if (message.what == 0) {
            this.f21047a.m27784f();
        } else {
            this.f21047a.m27799c();
        }
    }
}
