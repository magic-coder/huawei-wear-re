package com.tencent.open.p542b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: ProGuard */
class C6379h extends Handler {
    final /* synthetic */ C6378g f22188a;

    C6379h(C6378g c6378g, Looper looper) {
        this.f22188a = c6378g;
        super(looper);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                this.f22188a.m29163b();
                break;
            case 1001:
                this.f22188a.m29166e();
                break;
        }
        super.handleMessage(message);
    }
}
