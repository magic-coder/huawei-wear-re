package com.huawei.android.pushagent;

import com.huawei.android.pushagent.p018c.p019a.C0657e;
import java.lang.Thread.UncaughtExceptionHandler;

class C0645a implements UncaughtExceptionHandler {
    final /* synthetic */ PushService f1159a;

    C0645a(PushService pushService) {
        this.f1159a = pushService;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        C0657e.m2517b(PushService.f1145a, "catch uncaughtException, stop service");
        this.f1159a.stopService();
    }
}
