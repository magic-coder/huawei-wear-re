package com.huawei.pluginkidwatch.plugin.p152a;

import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1620b;

/* compiled from: KWBtDevice */
class C1731l implements Runnable {
    final /* synthetic */ int f4674a;
    final /* synthetic */ C1620b f4675b;
    final /* synthetic */ C1723d f4676c;

    C1731l(C1723d c1723d, int i, C1620b c1620b) {
        this.f4676c = c1723d;
        this.f4674a = i;
        this.f4675b = c1620b;
    }

    public void run() {
        if (2 == this.f4676c.f4663y) {
            this.f4676c.f4651m.m7844a(this.f4674a, this.f4675b);
        }
    }
}
