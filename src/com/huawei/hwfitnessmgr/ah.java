package com.huawei.hwfitnessmgr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;

/* compiled from: HWFitnessMgr */
class ah extends BroadcastReceiver {
    final /* synthetic */ q f18149a;

    ah(q qVar) {
        this.f18149a = qVar;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        C2538c.a("05", 1, "HWFitnessMgr", new Object[]{"onReceive local broadcast:" + action});
        if (action != null) {
            if (action.equals("com.huawei.plugin.account.login")) {
                q.b(this.f18149a);
            } else if (action.equals("com.huawei.bone.action.FITNESS_USERINFO_UPDATED")) {
                q.c(this.f18149a);
            }
        }
    }
}
