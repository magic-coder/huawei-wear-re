package com.tencent.connect.p193b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: ProGuard */
class C6280r extends Handler {
    final /* synthetic */ C6273k f21845a;
    private C6279q f21846b;

    public C6280r(C6273k c6273k, C6279q c6279q, Looper looper) {
        this.f21845a = c6273k;
        super(looper);
        this.f21846b = c6279q;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.f21846b.m28834a((String) message.obj);
                return;
            case 2:
                this.f21846b.mo5286a();
                return;
            case 3:
                C6273k.m28812b(this.f21845a.f21826k, (String) message.obj);
                return;
            default:
                return;
        }
    }
}
