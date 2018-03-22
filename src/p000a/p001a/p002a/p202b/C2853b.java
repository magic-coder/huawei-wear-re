package p000a.p001a.p002a.p202b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: LocalBroadcastManager */
class C2853b extends Handler {
    final /* synthetic */ C2852a f9234a;

    C2853b(C2852a c2852a, Looper looper) {
        this.f9234a = c2852a;
        super(looper);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.f9234a.m12943a();
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
