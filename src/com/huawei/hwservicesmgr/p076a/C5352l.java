package com.huawei.hwservicesmgr.p076a;

import com.huawei.hwservicesmgr.a.h;

/* compiled from: PhoneListManager */
class C5352l implements Runnable {
    final /* synthetic */ h f19096a;

    C5352l(h hVar) {
        this.f19096a = hVar;
    }

    public void run() {
        h.b(this.f19096a).listen(h.a(this.f19096a), 0);
        h.b(this.f19096a).listen(h.a(this.f19096a), 32);
    }
}
