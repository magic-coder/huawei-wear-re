package com.huawei.pluginkidwatch.home;

import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;

/* compiled from: HomeActivity */
class C1652g implements Runnable {
    final /* synthetic */ HomeActivity f4347a;

    C1652g(HomeActivity homeActivity) {
        this.f4347a = homeActivity;
    }

    public void run() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "=========== Enter circleRunnable run ");
        this.f4347a.f4131c.postDelayed(this.f4347a.cn, LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME);
        this.f4347a.m7551a(false, false, true);
    }
}
