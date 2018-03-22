package com.huawei.pluginkidwatch.common.ui.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.lib.p148c.C1467b;
import com.huawei.pluginkidwatch.common.p138a.C1392h;

/* compiled from: KidWatchBaseActivity */
class C1511a extends BroadcastReceiver {
    final /* synthetic */ KidWatchBaseActivity f3529a;

    C1511a(KidWatchBaseActivity kidWatchBaseActivity) {
        this.f3529a = kidWatchBaseActivity;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        C2538c.m12674b("KidWatchBaseActivity", "onReceive() action = " + action);
        if (action == null) {
            C2538c.m12680e("KidWatchBaseActivity", "onReceive() return with action=null");
        } else if (action.equals("golbal_finish_all_kidwatch_activity")) {
            C2538c.m12674b("KidWatchBaseActivity", "GOLBAL_FINISH_ALL_KIDWATCH_ACTIVITY onReceive() finish()");
            this.f3529a.finish();
        } else if (action.equals("com.huawei.plugin.account.logout")) {
            C2538c.m12677c("KidWatchBaseActivity", "ACTION_LOGOUT_SUCCESSFUL onReceive() finish()");
            C1467b.m6785b(this.f3529a.getApplicationContext());
            C1392h.m6298b(KidWatchBaseActivity.f3521b, C1462f.m6744i());
            this.f3529a.finish();
        }
    }
}
