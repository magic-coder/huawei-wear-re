package com.tencent.wxop.stat;

import java.util.List;

final class ao implements Runnable {
    final /* synthetic */ List f22643a;
    final /* synthetic */ boolean f22644b;
    final /* synthetic */ boolean f22645c = true;
    final /* synthetic */ am f22646d;

    ao(am amVar, List list, boolean z) {
        this.f22646d = amVar;
        this.f22643a = list;
        this.f22644b = z;
    }

    public final void run() {
        this.f22646d.m29684c(this.f22643a, this.f22644b);
        if (this.f22645c) {
            this.f22643a.clear();
        }
    }
}
