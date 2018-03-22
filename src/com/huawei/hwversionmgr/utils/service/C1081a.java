package com.huawei.hwversionmgr.utils.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;

/* compiled from: UpdateService */
class C1081a extends BroadcastReceiver {
    final /* synthetic */ UpdateService f2199a;

    C1081a(UpdateService updateService) {
        this.f2199a = updateService;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        C2538c.m12677c("UpdateService", "onReceive: action = " + action);
    }
}
