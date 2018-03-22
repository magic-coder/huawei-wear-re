package com.huawei.hwservicesmgr.p076a;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import com.huawei.hwservicesmgr.a.h;
import com.huawei.p190v.C2538c;

/* compiled from: PhoneListManager */
class C5354n extends BroadcastReceiver {
    final /* synthetic */ h f19098a;

    C5354n(h hVar) {
        this.f19098a = hVar;
    }

    @TargetApi(3)
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            if ("android.intent.action.PHONE_STATE".equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra("state");
                C2538c.c("PhoneListManager", new Object[]{"onReceive() state=" + stringExtra + ", incomingNumber=" + intent.getStringExtra("incoming_number")});
                if (TelephonyManager.EXTRA_STATE_RINGING.equals(stringExtra)) {
                    h.a(this.f19098a, r1);
                } else {
                    h.e(this.f19098a);
                }
            }
        }
    }
}
