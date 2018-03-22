package com.huawei.ab;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;

/* compiled from: HWUserProfileMgr */
class C3970n extends BroadcastReceiver {
    final /* synthetic */ m f15200a;

    C3970n(m mVar) {
        this.f15200a = mVar;
    }

    public void onReceive(Context context, Intent intent) {
        C2538c.c("HWUserProfileMgr", new Object[]{"mBroadcastReceiver broadcast:" + intent.getAction()});
        if ("com.huawei.plugin.account.login".equals(intent.getAction())) {
            this.f15200a.setSharedPreference("custome_define_init_flag", "false", null);
            m.a(this.f15200a).m19661a(context, null);
            C3978v.m19698a(null);
            C3978v.m19704b();
            C3978v.m19709c();
        }
    }
}
