package com.huawei.hwfitnessmgr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;

/* compiled from: HWFitnessMgr */
class ak extends BroadcastReceiver {
    final /* synthetic */ q f18152a;

    ak(q qVar) {
        this.f18152a = qVar;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        C2538c.a("05", 1, "HWFitnessMgr", new Object[]{"onReceive hiHealthCloudSyncReceiver:" + action});
        if (action != null) {
            if (action.equals("com.huawei.hihealth.action_user_goal_change")) {
                this.f18152a.b();
            } else if (action.equals("com.huawei.hihealth.action_receive_push")) {
                C2538c.c("HWFitnessMgr", new Object[]{"receive push and start sync"});
                this.f18152a.b(new al(this));
            }
        }
    }
}
