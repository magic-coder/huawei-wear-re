package com.huawei.pluginkidwatch.home;

import com.huawei.p190v.C2538c;

/* compiled from: HomeActivity */
class C1649d implements Runnable {
    final /* synthetic */ HomeActivity f4344a;

    C1649d(HomeActivity homeActivity) {
        this.f4344a = homeActivity;
    }

    public void run() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "================runnable 时间到停止定位");
        this.f4344a.m7501X();
    }
}
