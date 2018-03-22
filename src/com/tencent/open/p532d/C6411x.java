package com.tencent.open.p532d;

/* compiled from: ProGuard */
class C6411x implements Runnable {
    final /* synthetic */ Runnable f22260a;
    final /* synthetic */ C6410w f22261b;

    C6411x(C6410w c6410w, Runnable runnable) {
        this.f22261b = c6410w;
        this.f22260a = runnable;
    }

    public void run() {
        try {
            this.f22260a.run();
        } finally {
            this.f22261b.m29233a();
        }
    }
}
