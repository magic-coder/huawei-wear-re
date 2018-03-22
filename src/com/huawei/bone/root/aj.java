package com.huawei.bone.root;

import com.huawei.openalliance.ad.inter.listener.SplashListener;
import com.huawei.p190v.C2538c;

/* compiled from: SplashActivity */
class aj implements SplashListener {
    final /* synthetic */ SplashActivity f23306a;

    aj(SplashActivity splashActivity) {
        this.f23306a = splashActivity;
    }

    public void onAdDismissed() {
        C2538c.c("SplashActivity", new Object[]{"onAdDismissed"});
        this.f23306a.m30201b();
    }

    public void onAdFailed(int i) {
        C2538c.e("SplashActivity", new Object[]{"errorcode is :" + i});
        this.f23306a.m30201b();
    }

    public void onNoSupport() {
        C2538c.e("SplashActivity", new Object[]{"onNoSupport"});
        this.f23306a.m30201b();
    }
}
