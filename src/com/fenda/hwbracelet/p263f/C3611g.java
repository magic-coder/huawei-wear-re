package com.fenda.hwbracelet.p263f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.fenda.hwbracelet.p260c.C3581a;
import com.huawei.p190v.C2538c;

/* compiled from: XbService */
class C3611g extends BroadcastReceiver {
    final /* synthetic */ C3609e f13848a;

    C3611g(C3609e c3609e) {
        this.f13848a = c3609e;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action == null) {
            C2538c.e("XbService", new Object[]{"null == action"});
        } else if (action.equals("com.fenda.hwbracelet.INTENT_START_RSSI")) {
            C3581a.m17953a(this.f13848a.f13839h);
        } else if (action.equals("com.fenda.hwbracelet.INTENT_STOP_RSSI")) {
            C3581a.m17969d();
        } else if (action.equals("com.fenda.hwbracelet.intent.prevent.reconnect")) {
            this.f13848a.m18115c();
        }
    }
}
