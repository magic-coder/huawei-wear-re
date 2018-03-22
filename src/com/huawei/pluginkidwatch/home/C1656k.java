package com.huawei.pluginkidwatch.home;

import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.service.MessageObserver;
import java.util.TimerTask;

/* compiled from: HomeActivity */
class C1656k extends TimerTask {
    final /* synthetic */ HomeActivity f4357a;

    C1656k(HomeActivity homeActivity) {
        this.f4357a = homeActivity;
    }

    public void run() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "=====Timer getWatchStatus");
        this.f4357a.f4131c.sendEmptyMessage(MessageObserver.RET_AUTH_ERROR);
    }
}
