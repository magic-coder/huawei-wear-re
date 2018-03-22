package com.huawei.hwservicesmgr.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import com.huawei.p190v.C2538c;

public class ScreenReceiver extends BroadcastReceiver {
    private HandlerThread f2076a = new HandlerThread("ScreenReceiver");
    private Handler f2077b = null;

    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            C2538c.m12680e("ScreenReceiver", "onReceive(): intent is null!");
            return;
        }
        String action = intent.getAction();
        this.f2076a.start();
        this.f2077b = new Handler(this.f2076a.getLooper());
        this.f2077b.post(new C1058a(this, action, context));
    }
}
