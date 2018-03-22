package com.huawei.hwservicesmgr.p076a;

import com.huawei.hwservicesmgr.a.h;

/* compiled from: PhoneListManager */
class C5351k implements Runnable {
    final /* synthetic */ h f19095a;

    C5351k(h hVar) {
        this.f19095a = hVar;
    }

    public void run() {
        h.b(this.f19095a).listen(h.a(this.f19095a), 0);
    }
}
