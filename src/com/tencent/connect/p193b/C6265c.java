package com.tencent.connect.p193b;

/* compiled from: ProGuard */
class C6265c implements Runnable {
    final /* synthetic */ C6264b f21794a;

    C6265c(C6264b c6264b) {
        this.f21794a = c6264b;
    }

    public void run() {
        C6273k c6273k = new C6273k(this.f21794a.f21793c.f21790m, "action_login", this.f21794a.f21791a, this.f21794a.f21792b, this.f21794a.f21793c.c);
        if (this.f21794a.f21793c.f21790m != null && !this.f21794a.f21793c.f21790m.isFinishing()) {
            c6273k.show();
        }
    }
}
