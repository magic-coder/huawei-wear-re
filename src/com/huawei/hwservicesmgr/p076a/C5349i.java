package com.huawei.hwservicesmgr.p076a;

import com.huawei.hwservicesmgr.a.h;

/* compiled from: PhoneListManager */
class C5349i implements Runnable {
    final /* synthetic */ h f19093a;

    C5349i(h hVar) {
        this.f19093a = hVar;
    }

    public void run() {
        h.b(this.f19093a).listen(h.a(this.f19093a), 32);
    }
}
