package com.huawei.feedback.logic;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: FeedbackSubmitTask */
class C4419j extends Handler {
    final /* synthetic */ C4418i f16421a;

    C4419j(C4418i c4418i) {
        this.f16421a = c4418i;
    }

    public void handleMessage(Message message) {
        Handler handler = new Handler(Looper.getMainLooper());
        switch (message.what) {
            case 1:
                handler.post(new C4420k(this));
                return;
            case 2:
                handler.post(new C4421l(this));
                return;
            case 3:
                handler.post(new C4422m(this));
                return;
            default:
                return;
        }
    }
}
