package com.huawei.hwfitnessmgr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.huawei.p190v.C2538c;

/* compiled from: HWFitnessMgr */
class am extends BroadcastReceiver {
    final /* synthetic */ q f18154a;

    am(q qVar) {
        this.f18154a = qVar;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        C2538c.a("05", 1, "HWFitnessMgr", new Object[]{"onReceive hiHealthCloudSyncReceiver:" + action});
        if (action != null && action.equals("com.huawei.hihealth.action_sync")) {
            int intExtra = intent.getIntExtra("com.huawei.hihealth.action_sync_status", 6);
            C2538c.c("HWFitnessMgr", new Object[]{"onReceive hiHealthCloudSyncReceiver:", Integer.valueOf(intExtra)});
            if (2 == intExtra || 3 == intExtra) {
                this.f18154a.a.execute(new as(this.f18154a));
                LocalBroadcastManager instance = LocalBroadcastManager.getInstance(q.d(this.f18154a));
                if (instance != null) {
                    instance.unregisterReceiver(q.f(this.f18154a));
                }
            }
        }
    }
}
