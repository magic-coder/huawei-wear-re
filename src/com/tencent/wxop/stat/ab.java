package com.tencent.wxop.stat;

import android.content.Context;

final class ab implements Runnable {
    final /* synthetic */ Context f22603a;

    ab(Context context) {
        this.f22603a = context;
    }

    public final void run() {
        try {
            new Thread(new ah(this.f22603a), "NetworkMonitorTask").start();
        } catch (Throwable th) {
            C6546x.f22856q.m29705b(th);
            C6546x.m29866a(this.f22603a, th);
        }
    }
}
