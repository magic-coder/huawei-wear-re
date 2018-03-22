package com.huawei.pluginkidwatch.home;

import com.huawei.p190v.C2538c;

/* compiled from: HomeActivity */
class C1648c implements Runnable {
    final /* synthetic */ HomeActivity f4343a;

    C1648c(HomeActivity homeActivity) {
        this.f4343a = homeActivity;
    }

    public void run() {
        if (this.f4343a.f4128Y != null && this.f4343a.f4128Y.isVisible()) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "======显示位置信息 立刻=======");
            this.f4343a.f4128Y.showInfoWindow();
            this.f4343a.m7524a(this.f4343a.f4128Y.getPosition());
        }
    }
}
