package com.huawei.pluginkidwatch.home;

import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.p190v.C2538c;

/* compiled from: HomeActivity */
class C1651f implements Runnable {
    final /* synthetic */ HomeActivity f4346a;

    C1651f(HomeActivity homeActivity) {
        this.f4346a = homeActivity;
    }

    public void run() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "===========watchStatusNum = " + this.f4346a.aU);
        if (this.f4346a.aU <= 0 || this.f4346a.isFinishing()) {
            this.f4346a.f4131c.sendEmptyMessage(HwAccountConstants.MY_PERMISSIONS_REQUEST_READ_PHONE_STATE);
            return;
        }
        this.f4346a.m7551a(true, true, true);
        this.f4346a.aU = this.f4346a.aU - 1;
    }
}
