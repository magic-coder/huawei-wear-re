package com.huawei.pluginkidwatch.home;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginmessagecenter.service.MessageObserver;

/* compiled from: HomeActivity */
class C1659n implements Runnable {
    final /* synthetic */ HomeActivity f4361a;

    C1659n(HomeActivity homeActivity) {
        this.f4361a = homeActivity;
    }

    public void run() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "========emergencyRunnable Enter");
        this.f4361a.m7456B();
        this.f4361a.f4131c.removeMessages(MessageObserver.RET_AUTH_ERROR);
        this.f4361a.bx = false;
        this.f4361a.m7631x();
        this.f4361a.m7518a(this.f4361a.f4109F, C1680l.IDS_plugin_kidwatch_main_get_status_error, false);
    }
}
