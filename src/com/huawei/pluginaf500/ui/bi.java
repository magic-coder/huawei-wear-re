package com.huawei.pluginaf500.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

/* compiled from: ResetBraceletActivity */
class bi extends BroadcastReceiver {
    final /* synthetic */ ResetBraceletActivity f19929a;

    bi(ResetBraceletActivity resetBraceletActivity) {
        this.f19929a = resetBraceletActivity;
    }

    public void onReceive(Context context, Intent intent) {
        if ("com.fenda.hwbracelet.INTENT_FACTORY_RESET".equals(intent.getAction())) {
            this.f19929a.sendBroadcast(new Intent("com.fenda.hwbracelet.intent.prevent.reconnect"), "com.af500.permission.MYBRODCAST");
            new Handler().postDelayed(new bj(this), 8000);
        }
    }
}
