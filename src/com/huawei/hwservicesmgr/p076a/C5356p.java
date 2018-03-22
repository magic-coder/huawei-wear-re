package com.huawei.hwservicesmgr.p076a;

import com.huawei.hwservicesmgr.a.h;
import com.huawei.p190v.C2538c;

/* compiled from: PhoneListManager */
class C5356p implements Runnable {
    final /* synthetic */ String f19101a;
    final /* synthetic */ h f19102b;

    C5356p(h hVar, String str) {
        this.f19102b = hVar;
        this.f19101a = str;
    }

    public void run() {
        try {
            Thread.sleep(3000);
            h.b(this.f19102b, this.f19101a);
        } catch (InterruptedException e) {
            C2538c.e("PhoneListManager", new Object[]{"InterruptedException e : " + e.getMessage()});
        }
    }
}
