package com.tencent.open.p532d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.open.p541a.C6367n;

/* compiled from: ProGuard */
class C6393e extends Handler {
    final /* synthetic */ C6392d f22226a;

    C6393e(C6392d c6392d, Looper looper) {
        this.f22226a = c6392d;
        super(looper);
    }

    public void handleMessage(Message message) {
        C6367n.m29104a("AsynLoadImg", "handleMessage:" + message.arg1);
        if (message.arg1 == 0) {
            this.f22226a.f22222b.mo5300a(message.arg1, (String) message.obj);
        } else {
            this.f22226a.f22222b.mo5300a(message.arg1, null);
        }
    }
}
