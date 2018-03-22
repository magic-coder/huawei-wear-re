package com.huawei.common.applog;

import android.content.Context;
import android.os.Handler;
import com.huawei.common.applog.p380a.C4345a;

/* compiled from: ReportEventManager */
final class C4356e implements Runnable {
    final /* synthetic */ Context f16190a;
    final /* synthetic */ Handler f16191b;

    C4356e(Context context, Handler handler) {
        this.f16190a = context;
        this.f16191b = handler;
    }

    public void run() {
        C4345a.m20886a(this.f16190a, this.f16191b);
    }
}
