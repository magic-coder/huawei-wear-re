package com.huawei.hwdevicefontmgr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import com.huawei.p190v.C2538c;

public class LanguageChangedBR extends BroadcastReceiver {
    private HandlerThread f1820a = new HandlerThread("LanguageChangedBR");
    private Handler f1821b = null;

    public void onReceive(Context context, Intent intent) {
        C2538c.m12680e("LanguageChangedBR", "mLocalLanuageChangedReceiver() context = " + context + " intent = " + intent.getAction());
        if (context != null && "android.intent.action.LOCALE_CHANGED".equals(intent.getAction())) {
            this.f1820a.start();
            this.f1821b = new Handler(this.f1820a.getLooper());
            this.f1821b.post(new C1022d(this, context));
        }
    }
}
