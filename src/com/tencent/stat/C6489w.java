package com.tencent.stat;

import java.util.List;

class C6489w implements Runnable {
    final /* synthetic */ List f22544a;
    final /* synthetic */ int f22545b;
    final /* synthetic */ C6487u f22546c;

    C6489w(C6487u c6487u, List list, int i) {
        this.f22546c = c6487u;
        this.f22544a = list;
        this.f22545b = i;
    }

    public void run() {
        this.f22546c.m29607b(this.f22544a, this.f22545b);
    }
}
