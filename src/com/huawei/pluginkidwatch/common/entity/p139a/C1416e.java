package com.huawei.pluginkidwatch.common.entity.p139a;

import java.util.TimerTask;

/* compiled from: KidApi */
class C1416e extends TimerTask {
    final /* synthetic */ C1414c f3231a;

    C1416e(C1414c c1414c) {
        this.f3231a = c1414c;
    }

    public void run() {
        this.f3231a.f3229e = true;
        this.f3231a.m6543a();
    }
}
