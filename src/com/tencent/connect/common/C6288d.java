package com.tencent.connect.common;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.tauth.C6494d;

/* compiled from: ProGuard */
class C6288d extends Handler {
    final /* synthetic */ C6245a f21873a;
    final /* synthetic */ C6287c f21874b;

    C6288d(C6287c c6287c, Looper looper, C6245a c6245a) {
        this.f21874b = c6287c;
        this.f21873a = c6245a;
        super(looper);
    }

    public void handleMessage(Message message) {
        if (message.what == 0) {
            this.f21874b.f21871b.mo5288a(message.obj);
        } else {
            this.f21874b.f21871b.mo5287a(new C6494d(message.what, (String) message.obj, null));
        }
    }
}
