package com.huawei.ui.homewear21.p175a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;

/* compiled from: HomeFragment */
class bh extends BroadcastReceiver {
    final /* synthetic */ C2217a f8079a;

    bh(C2217a c2217a) {
        this.f8079a = c2217a;
    }

    public void onReceive(Context context, Intent intent) {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "mDialogDismissBroadcastReceiver() intent = " + intent.getAction());
        String action = intent.getAction();
        if (action != null && action.equals("com.huawei.bone.action.ACTION_DIALOG_DISMISS")) {
            this.f8079a.bu.sendEmptyMessage(19);
        }
    }
}
