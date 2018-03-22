package com.tencent.stat;

import java.util.List;

class C6479m implements Runnable {
    final /* synthetic */ List f22523a;
    final /* synthetic */ C6450j f22524b;
    final /* synthetic */ C6477k f22525c;

    C6479m(C6477k c6477k, List list, C6450j c6450j) {
        this.f22525c = c6477k;
        this.f22523a = list;
        this.f22524b = c6450j;
    }

    public void run() {
        try {
            this.f22525c.m29583a(this.f22523a, this.f22524b);
        } catch (Throwable th) {
            C6477k.f22516c.m29411f(th);
        }
    }
}
