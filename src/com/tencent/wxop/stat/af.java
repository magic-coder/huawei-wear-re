package com.tencent.wxop.stat;

import android.content.Context;

final class af implements Runnable {
    final /* synthetic */ Context f22610a;
    final /* synthetic */ C6547y f22611b = null;

    af(Context context) {
        this.f22610a = context;
    }

    public final void run() {
        try {
            C6546x.m29858a(this.f22610a, false, this.f22611b);
        } catch (Throwable th) {
            C6546x.f22856q.m29705b(th);
        }
    }
}
