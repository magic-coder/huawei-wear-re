package com.huawei.ui.device.p170a;

import android.os.Handler;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.application.BaseApplication;
import java.util.concurrent.ExecutorService;

/* compiled from: CompatibilityInteractor */
class C1983k implements Runnable {
    final /* synthetic */ Handler f6926a;
    final /* synthetic */ IBaseResponseCallback f6927b;
    final /* synthetic */ ExecutorService f6928c;
    final /* synthetic */ C1975c f6929d;

    C1983k(C1975c c1975c, Handler handler, IBaseResponseCallback iBaseResponseCallback, ExecutorService executorService) {
        this.f6929d = c1975c;
        this.f6926a = handler;
        this.f6927b = iBaseResponseCallback;
        this.f6928c = executorService;
    }

    public void run() {
        C1988p.m10381a(BaseApplication.m2632b()).m10385a(1, new C1984l(this));
    }
}
