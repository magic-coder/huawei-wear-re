package com.huawei.ab;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;

/* compiled from: HWUserProfileMgr */
class C3971o extends BroadcastReceiver {
    final /* synthetic */ m f15201a;

    C3971o(m mVar) {
        this.f15201a = mVar;
    }

    public void onReceive(Context context, Intent intent) {
        C2538c.c("HWUserProfileMgr", new Object[]{"mLogoutBroadcastReceiver broadcast:" + intent.getAction()});
        if ("com.huawei.plugin.account.logout".equals(intent.getAction())) {
            this.f15201a.setSharedPreference("custome_define_init_flag", "true", null);
            C3978v.m19710d();
        }
    }
}
