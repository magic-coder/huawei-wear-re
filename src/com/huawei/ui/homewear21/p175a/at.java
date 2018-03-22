package com.huawei.ui.homewear21.p175a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;

/* compiled from: HomeFragment */
class at extends BroadcastReceiver {
    final /* synthetic */ C2217a f8063a;

    at(C2217a c2217a) {
        this.f8063a = c2217a;
    }

    public void onReceive(Context context, Intent intent) {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter mGetKidWatchSuccessReceiver()");
        if (context != null && "com.huawei.bone.action.ACTION_GET_KIDWATCH_SUCCESS".equals(intent.getAction())) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", " mGetKidWatchSuccessReceiver(): get kidwatch success");
            this.f8063a.bu.removeMessages(1020);
            this.f8063a.bu.sendEmptyMessage(1020);
        }
    }
}
