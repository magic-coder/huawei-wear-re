package com.huawei.pluginkidwatch.plugin.p152a;

import com.huawei.p190v.C2538c;

/* compiled from: KWBtDevice */
class C1742w implements Runnable {
    final /* synthetic */ C1723d f4687a;

    C1742w(C1723d c1723d) {
        this.f4687a = c1723d;
    }

    public void run() {
        if (this.f4687a.f4662x) {
            C2538c.m12674b("KWBtDevice", "exceptionConnectFailTimeout run !!!!!!!!!!!");
            this.f4687a.m8258h(3);
            this.f4687a.f4662x = false;
        }
    }
}
