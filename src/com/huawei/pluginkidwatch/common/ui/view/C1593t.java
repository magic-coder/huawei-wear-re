package com.huawei.pluginkidwatch.common.ui.view;

import java.util.TimerTask;

/* compiled from: CustomCircleProgress */
class C1593t extends TimerTask {
    final /* synthetic */ C1582r f3968a;

    C1593t(C1582r c1582r) {
        this.f3968a = c1582r;
    }

    public void run() {
        this.f3968a.f3917a.obtainMessage(16).sendToTarget();
    }
}
