package com.huawei.android.pushselfshow.richpush.p341c.p343b;

import com.huawei.android.pushagent.c.a.e;

class C4185f implements Runnable {
    final /* synthetic */ C4183c f15748a;

    C4185f(C4183c c4183c) {
        this.f15748a = c4183c;
    }

    public void run() {
        boolean a = this.f15748a.f15745c.m20370b();
        e.a("PushSelfShowLog", "bEmptyMsg is " + a);
        if (!a) {
            this.f15748a.f15743a = !this.f15748a.f15743a;
            this.f15748a.f15745c.f15738a.setNetworkAvailable(this.f15748a.f15743a);
            e.a("PushSelfShowLog", "setNetworkAvailable ： " + this.f15748a.f15743a);
        }
    }
}
