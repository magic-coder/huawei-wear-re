package com.p252d.p253a.p254a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: AsyncHttpResponseHandler */
class C3551h extends Handler {
    private final C3550g f13559a;

    C3551h(C3550g c3550g, Looper looper) {
        super(looper);
        this.f13559a = c3550g;
    }

    public void handleMessage(Message message) {
        this.f13559a.m17843a(message);
    }
}
