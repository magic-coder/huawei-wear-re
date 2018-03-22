package com.tencent.open;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.open.p541a.C6367n;

/* compiled from: ProGuard */
class C6417f extends Handler {
    final /* synthetic */ C6371a f22279a;
    private C6416e f22280b;

    public C6417f(C6371a c6371a, C6416e c6416e, Looper looper) {
        this.f22279a = c6371a;
        super(looper);
        this.f22280b = c6416e;
    }

    public void handleMessage(Message message) {
        C6367n.m29107b("TAG", "--handleMessage--msg.WHAT = " + message.what);
        switch (message.what) {
            case 1:
                this.f22280b.m29273a((String) message.obj);
                return;
            case 2:
                this.f22280b.mo5286a();
                return;
            case 3:
                if (this.f22279a.f22160e != null && this.f22279a.f22160e.get() != null) {
                    C6371a.m29129c((Context) this.f22279a.f22160e.get(), (String) message.obj);
                    return;
                }
                return;
            case 5:
                if (this.f22279a.f22160e != null && this.f22279a.f22160e.get() != null) {
                    C6371a.m29130d((Context) this.f22279a.f22160e.get(), (String) message.obj);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
