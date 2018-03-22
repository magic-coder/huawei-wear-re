package com.huawei.pluginkidwatch.plugin.feature.antiloss;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;

/* compiled from: AntilossActivity */
class C1780d extends BroadcastReceiver {
    final /* synthetic */ AntilossActivity f4929a;

    C1780d(AntilossActivity antilossActivity) {
        this.f4929a = antilossActivity;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        C2538c.m12674b("AntilossActivity", "btAdapter.getState() = " + this.f4929a.f4901t.getState());
        if (!"android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
            return;
        }
        if (12 == this.f4929a.f4901t.getState()) {
            C2538c.m12674b("AntilossActivity", "BluetoothAdapter ACTION_STATE_CHANGED STATE_ON go connect device !!!!");
            this.f4929a.runOnUiThread(new C1781e(this));
            this.f4929a.m8523m();
            this.f4929a.f4880K.postDelayed(new C1782f(this), 6000);
        } else if (10 == this.f4929a.f4901t.getState()) {
            C2538c.m12674b("AntilossActivity", "BluetoothAdapter ACTION_STATE_CHANGED STATE_OFF reset antiloss state !!!!");
            if (4 == this.f4929a.f4904w.m8302i()) {
                this.f4929a.f4904w.m8296e();
            }
            this.f4929a.f4904w.m8288b(0);
            this.f4929a.f4904w.m8292c(9);
            this.f4929a.runOnUiThread(new C1783g(this));
        }
    }
}
