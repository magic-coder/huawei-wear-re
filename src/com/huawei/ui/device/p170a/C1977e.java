package com.huawei.ui.device.p170a;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.c.a;
import java.util.concurrent.ExecutorService;

/* compiled from: CompatibilityInteractor */
class C1977e implements Runnable {
    final /* synthetic */ a f6908a;
    final /* synthetic */ IBaseResponseCallback f6909b;
    final /* synthetic */ ExecutorService f6910c;
    final /* synthetic */ C1975c f6911d;

    C1977e(C1975c c1975c, a aVar, IBaseResponseCallback iBaseResponseCallback, ExecutorService executorService) {
        this.f6911d = c1975c;
        this.f6908a = aVar;
        this.f6909b = iBaseResponseCallback;
        this.f6910c = executorService;
    }

    public void run() {
        this.f6911d.m10370b(this.f6908a, 700, System.currentTimeMillis(), new C1978f(this));
        this.f6910c.shutdownNow();
    }
}
