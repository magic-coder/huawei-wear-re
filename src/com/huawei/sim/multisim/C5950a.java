package com.huawei.sim.multisim;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;

/* compiled from: MultiSimConfigActivity */
class C5950a extends BroadcastReceiver {
    final /* synthetic */ MultiSimConfigActivity f20523a;

    C5950a(MultiSimConfigActivity multiSimConfigActivity) {
        this.f20523a = multiSimConfigActivity;
    }

    public void onReceive(Context context, Intent intent) {
        C2538c.c("MultiSimConfigActivity", new Object[]{"connectedChanged mNonLocalBroadcastReceiver(): intent = " + intent.getAction()});
        this.f20523a.f20490T.sendEmptyMessage(1);
    }
}
