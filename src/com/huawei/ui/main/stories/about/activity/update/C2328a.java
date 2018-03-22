package com.huawei.ui.main.stories.about.activity.update;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;

/* compiled from: AppUpdateDialogActivity */
class C2328a extends BroadcastReceiver {
    final /* synthetic */ AppUpdateDialogActivity f8449a;

    C2328a(AppUpdateDialogActivity appUpdateDialogActivity) {
        this.f8449a = appUpdateDialogActivity;
    }

    public void onReceive(Context context, Intent intent) {
        C2538c.m12677c("AppUpdateDialogActivity", "onReceive: action = " + intent.getAction());
        if ("action_app_check_new_version_state".equals(intent.getAction())) {
            this.f8449a.m11854a(intent);
        }
    }
}
