package com.huawei.p091m;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcloudmodel.c.w;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.login.ui.login.a;
import com.huawei.m.d;
import com.huawei.p190v.C2538c;

/* compiled from: HwCoreSleepMgr */
class C5465n implements Runnable {
    IBaseResponseCallback f19316a;
    int f19317b;
    int f19318c;
    boolean f19319d;
    final /* synthetic */ d f19320e;

    C5465n(d dVar, int i, int i2, IBaseResponseCallback iBaseResponseCallback) {
        this.f19320e = dVar;
        this.f19316a = iBaseResponseCallback;
        this.f19317b = i;
        this.f19318c = i2;
    }

    public void run() {
        C2538c.c("HwCoreSleepMgr", new Object[]{"enter syncCoreSleepDetailDataRunable run !!!!"});
        C2538c.c("HwCoreSleepMgr", new Object[]{"syncCoreSleepDetailDataRunable isDatalogin:" + w.a(a.a(BaseApplication.b()).c())});
        if (w.a(a.a(BaseApplication.b()).c())) {
            d.a(this.f19320e, this.f19317b, this.f19318c, this.f19319d, this.f19316a);
        } else if (this.f19316a != null) {
            this.f19316a.onResponse(100009, " hihealth don't login.");
        }
    }
}
