package com.tencent.wxop.stat;

import android.content.Context;

final class aa implements Runnable {
    final /* synthetic */ Context f22601a;
    final /* synthetic */ int f22602b = -1;

    aa(Context context) {
        this.f22601a = context;
    }

    public final void run() {
        try {
            C6546x.m29879e(this.f22601a);
            am.m29668a(this.f22601a).m29693a(this.f22602b);
        } catch (Throwable th) {
            C6546x.f22856q.m29705b(th);
            C6546x.m29866a(this.f22601a, th);
        }
    }
}
