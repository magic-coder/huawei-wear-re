package com.huawei.bone.root;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.pluginkidwatch.a.f;
import com.huawei.p190v.C2538c;

/* compiled from: MainActivity */
class C6786e extends BroadcastReceiver {
    final /* synthetic */ MainActivity f23324a;

    C6786e(MainActivity mainActivity) {
        this.f23324a = mainActivity;
    }

    public void onReceive(Context context, Intent intent) {
        C2538c.a("MainUI", 0, "MainActivity", new Object[]{"mBroadcastReceiver: intent = ", intent.getAction()});
        String action = intent.getAction();
        if (action != null && !action.equals("com.huawei.plugin.account.login")) {
            if (action.equals("com.huawei.plugin.account.login.st.to.at")) {
                f.a(context).c();
            } else if ("com.huawei.migrate.action.migrate.success".equals(action)) {
                this.f23324a.m30129j();
            } else {
                C2538c.a("MainUI", 0, "MainActivity", new Object[]{"mBroadcastReceiver receive unknown localBroadCast action =" + action});
            }
        }
    }
}
