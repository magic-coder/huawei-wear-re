package com.huawei.pluginkidwatch.home;

import java.util.TimerTask;

/* compiled from: HomeActivity */
class aa extends TimerTask {
    final /* synthetic */ int f4162a;
    final /* synthetic */ HomeActivity f4163b;

    aa(HomeActivity homeActivity, int i) {
        this.f4163b = homeActivity;
        this.f4162a = i;
    }

    public void run() {
        this.f4163b.m7580d(this.f4162a - 1);
    }
}
