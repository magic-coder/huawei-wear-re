package com.huawei.bone.p552b;

import com.huawei.p190v.C2538c;

/* compiled from: MainInterators */
class ab implements Runnable {
    final /* synthetic */ C6756a f23140a;

    ab(C6756a c6756a) {
        this.f23140a = c6756a;
    }

    public void run() {
        if (this.f23140a.f23129l && this.f23140a.f23130m) {
            this.f23140a.m30035a(this.f23140a.f23119a);
            this.f23140a.f23129l = false;
            this.f23140a.f23130m = false;
            return;
        }
        C2538c.b("MainInterators", new Object[]{"splash not ready ,wait.isAdSplashFinish=" + this.f23140a.f23129l + ",isSplashFinish=" + this.f23140a.f23130m});
    }
}
