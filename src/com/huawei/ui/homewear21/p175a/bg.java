package com.huawei.ui.homewear21.p175a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;

/* compiled from: HomeFragment */
class bg extends BroadcastReceiver {
    final /* synthetic */ C2217a f8078a;

    bg(C2217a c2217a) {
        this.f8078a = c2217a;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null && "com.huawei.bone.action.FITNESS_DATA_TODAY_SYNC".equals(intent.getAction())) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "mUpdateHealthDataReceiver is enter");
            this.f8078a.bu.sendEmptyMessage(17);
        }
    }
}
