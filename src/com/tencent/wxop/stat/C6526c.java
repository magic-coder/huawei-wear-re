package com.tencent.wxop.stat;

final class C6526c implements Runnable {
    final /* synthetic */ int f22741a;
    final /* synthetic */ am f22742b;

    C6526c(am amVar, int i) {
        this.f22742b = amVar;
        this.f22741a = i;
    }

    public final void run() {
        am.m29672a(this.f22742b, this.f22741a, true);
        am.m29672a(this.f22742b, this.f22741a, false);
    }
}
