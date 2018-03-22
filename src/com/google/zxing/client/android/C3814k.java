package com.google.zxing.client.android;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: CaptureActivity */
class C3814k extends Handler {
    private WeakReference<CaptureActivity> f14819a;

    public C3814k(CaptureActivity captureActivity) {
        this.f14819a = new WeakReference(captureActivity);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        CaptureActivity captureActivity = (CaptureActivity) this.f14819a.get();
        if (captureActivity != null && !captureActivity.isFinishing() && message.what == 1) {
            captureActivity.m18951o();
        }
    }
}
