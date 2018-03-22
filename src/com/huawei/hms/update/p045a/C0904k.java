package com.huawei.hms.update.p045a;

import com.huawei.hms.update.p045a.p046a.C0891b;
import com.huawei.hms.update.p045a.p046a.C0892c;

/* compiled from: ThreadWrapper */
class C0904k implements Runnable {
    final /* synthetic */ C0891b f1487a;
    final /* synthetic */ C0892c f1488b;
    final /* synthetic */ C0902i f1489c;

    C0904k(C0902i c0902i, C0891b c0891b, C0892c c0892c) {
        this.f1489c = c0902i;
        this.f1487a = c0891b;
        this.f1488b = c0892c;
    }

    public void run() {
        this.f1489c.f1484a.mo2266a(C0902i.m3166c(this.f1487a), this.f1488b);
    }
}
