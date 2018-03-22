package com.google.zxing.client.android.decode;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: InactivityTimer */
final class C3801g extends BroadcastReceiver {
    final /* synthetic */ C3799e f14783a;

    private C3801g(C3799e c3799e) {
        this.f14783a = c3799e;
    }

    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
            if ((intent.getIntExtra("plugged", -1) <= 0 ? 1 : null) != null) {
                this.f14783a.m19036a();
            } else {
                this.f14783a.m19035f();
            }
        }
    }
}
