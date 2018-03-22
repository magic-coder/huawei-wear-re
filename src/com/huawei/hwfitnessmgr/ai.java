package com.huawei.hwfitnessmgr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;

/* compiled from: HWFitnessMgr */
class ai extends BroadcastReceiver {
    final /* synthetic */ q f18150a;

    ai(q qVar) {
        this.f18150a = qVar;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        C2538c.a("05", 1, "HWFitnessMgr", new Object[]{"onReceive action:" + action});
        if (action != null && action.equals("action_change_core_sleep_button")) {
            action = intent.getStringExtra("status");
            C2538c.c("HWFitnessMgr", new Object[]{"onReceive status:" + action});
            if (action == null) {
                return;
            }
            if (action.equalsIgnoreCase("1")) {
                this.f18150a.b(true);
            } else {
                this.f18150a.b(false);
            }
        }
    }
}
