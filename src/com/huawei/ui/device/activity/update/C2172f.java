package com.huawei.ui.device.activity.update;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;

/* compiled from: UpdateVersionActivity */
class C2172f extends BroadcastReceiver {
    final /* synthetic */ UpdateVersionActivity f7752a;

    C2172f(UpdateVersionActivity updateVersionActivity) {
        this.f7752a = updateVersionActivity;
    }

    public void onReceive(Context context, Intent intent) {
        C2538c.m12677c("UpdateVersionActivity", "onReceive: action = " + intent.getAction());
        if ("action_app_check_new_version_state".equals(intent.getAction())) {
            this.f7752a.m11132a(intent);
        }
    }
}
