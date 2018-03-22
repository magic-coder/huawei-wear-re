package com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: DataTransferStateMachine */
class ad extends Handler {
    final /* synthetic */ C1719y f4444a;

    public ad(C1719y c1719y, Looper looper) {
        this.f4444a = c1719y;
        super(looper);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f4444a.f4623o != null) {
            this.f4444a.f4623o.mo2567a(message);
        }
    }
}
