package com.huawei.pluginkidwatch.home;

import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.p190v.C2538c;

/* compiled from: HomeActivity */
class C1650e implements Runnable {
    final /* synthetic */ HomeActivity f4345a;

    C1650e(HomeActivity homeActivity) {
        this.f4345a = homeActivity;
    }

    public void run() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "========timeoutRunnable Enter");
        this.f4345a.f4131c.sendEmptyMessage(HwAccountConstants.MY_PERMISSIONS_REQUEST_READ_PHONE_STATE);
    }
}
