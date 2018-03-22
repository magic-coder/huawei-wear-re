package com.huawei.pluginkidwatch.home;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;

/* compiled from: HomeActivity */
class bk extends BroadcastReceiver {
    final /* synthetic */ HomeActivity f4276a;

    bk(HomeActivity homeActivity) {
        this.f4276a = homeActivity;
    }

    public void onReceive(Context context, Intent intent) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==========Enter SosLocatReceiver ");
        if (!this.f4276a.isFinishing()) {
            String action = intent.getAction();
            if ("com.huawei.kone.broadcast.get.watch.status".equals(action)) {
                C2538c.m12674b("KIDWATCH_HomeActivity", "========收到低电的广播，需要刷新状态");
                this.f4276a.m7551a(false, true, true);
            } else if ("com.huawei.kone.broadcast.get.bind.device".equals(action)) {
                C2538c.m12674b("KIDWATCH_HomeActivity", "========收到主管理员确认的广播，需要刷新状态");
                this.f4276a.m7640a(true, true);
            } else if ("com.huawei.pluginkidwatch.homeactivity.emergency_locat".equals(action)) {
                C2538c.m12674b("KIDWATCH_HomeActivity", "========收到紧急定位的回调，但是不使用其结果");
            } else if ("com.huawei.pluginkidwatch.homeactivity.no.privalage".equals(action)) {
                C2538c.m12674b("KIDWATCH_HomeActivity", "========收到被删除管理员广播");
                this.f4276a.m7607l();
            } else if ("com.huawei.plugin.account.login.st.to.at".equals(action)) {
                C2538c.m12674b("KIDWATCH_HomeActivity", "========收到ST换AT成功的广播， 去刷新当前位置: goingRefreshLocationPosition!");
                this.f4276a.m7624u();
            }
        }
    }
}
