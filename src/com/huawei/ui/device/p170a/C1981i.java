package com.huawei.ui.device.p170a;

import android.os.Handler;
import android.os.Message;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.application.BaseApplication;
import java.util.concurrent.ExecutorService;

/* compiled from: CompatibilityInteractor */
class C1981i implements Runnable {
    final /* synthetic */ IBaseResponseCallback f6919a;
    final /* synthetic */ Handler f6920b;
    final /* synthetic */ long f6921c;
    final /* synthetic */ long f6922d;
    final /* synthetic */ ExecutorService f6923e;
    final /* synthetic */ C1975c f6924f;

    C1981i(C1975c c1975c, IBaseResponseCallback iBaseResponseCallback, Handler handler, long j, long j2, ExecutorService executorService) {
        this.f6924f = c1975c;
        this.f6919a = iBaseResponseCallback;
        this.f6920b = handler;
        this.f6921c = j;
        this.f6922d = j2;
        this.f6923e = executorService;
    }

    public void run() {
        Message message = new Message();
        message.what = 101;
        message.obj = this.f6919a;
        this.f6920b.sendMessageDelayed(message, 500);
        C1988p.m10381a(BaseApplication.m2632b()).m10395c(new C1982j(this));
        this.f6923e.shutdownNow();
    }
}
