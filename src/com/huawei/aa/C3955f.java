package com.huawei.aa;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: HWStressMgr */
class C3955f implements Runnable {
    IBaseResponseCallback f15166a;
    final /* synthetic */ a f15167b;

    C3955f(a aVar, IBaseResponseCallback iBaseResponseCallback) {
        this.f15167b = aVar;
        this.f15166a = iBaseResponseCallback;
    }

    public void run() {
        C2538c.c("HWStressMgr", new Object[]{"enter syncStressDetailDataRunnable run !!!!"});
        a.a(this.f15167b, this.f15166a);
    }
}
