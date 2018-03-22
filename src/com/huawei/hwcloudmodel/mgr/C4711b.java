package com.huawei.hwcloudmodel.mgr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;

/* compiled from: HWCloudMgr */
class C4711b extends BroadcastReceiver {
    final /* synthetic */ C4710a f17165a;

    C4711b(C4710a c4710a) {
        this.f17165a = c4710a;
    }

    public void onReceive(Context context, Intent intent) {
        C2538c.c("HWCloudMgr", new Object[]{"onReceive local broadcast:" + intent.getAction()});
        if ("com.huawei.plugin.account.login".equals(intent.getAction()) && this.f17165a.f17163c != null) {
            this.f17165a.f17163c.m22485a();
        }
    }
}
