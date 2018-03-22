package com.huawei.ui.device.activity.adddevice;

import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.ui.device.p170a.C1988p;
import java.util.concurrent.ExecutorService;

/* compiled from: AddDeviceActivity */
class C2000b implements Runnable {
    final /* synthetic */ ExecutorService f7037a;
    final /* synthetic */ AddDeviceActivity f7038b;

    C2000b(AddDeviceActivity addDeviceActivity, ExecutorService executorService) {
        this.f7038b = addDeviceActivity;
        this.f7037a = executorService;
    }

    public void run() {
        this.f7038b.m10505c();
        C1988p.m10381a(BaseApplication.m2632b()).m10385a(2, new C2001c(this));
    }
}
