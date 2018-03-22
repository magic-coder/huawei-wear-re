package com.tencent.wxop.stat;

import com.tencent.wxop.stat.p546a.C6495d;

final class aq implements Runnable {
    final /* synthetic */ C6495d f22648a;
    final /* synthetic */ C6505k f22649b;
    final /* synthetic */ boolean f22650c;
    final /* synthetic */ boolean f22651d;
    final /* synthetic */ am f22652e;

    aq(am amVar, C6495d c6495d, C6505k c6505k, boolean z, boolean z2) {
        this.f22652e = amVar;
        this.f22648a = c6495d;
        this.f22649b = c6505k;
        this.f22650c = z;
        this.f22651d = z2;
    }

    public final void run() {
        this.f22652e.m29681b(this.f22648a, this.f22649b, this.f22650c, this.f22651d);
    }
}
