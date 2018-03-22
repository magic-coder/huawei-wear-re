package com.tencent.stat;

class ac implements Runnable {
    final /* synthetic */ int f22377a;
    final /* synthetic */ C6487u f22378b;

    ac(C6487u c6487u, int i) {
        this.f22378b = c6487u;
        this.f22377a = i;
    }

    public void run() {
        int f = C6470c.m29523f();
        int i = this.f22377a == -1 ? this.f22378b.f22539b : this.f22377a;
        int i2 = i / f;
        int i3 = i % f;
        for (i = 0; i < i2 + 1; i++) {
            this.f22378b.m29603b(f);
        }
        if (i3 > 0) {
            this.f22378b.m29603b(i3);
        }
    }
}
