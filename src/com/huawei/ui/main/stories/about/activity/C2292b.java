package com.huawei.ui.main.stories.about.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.p190v.C2538c;

/* compiled from: AboutActivity */
class C2292b extends BroadcastReceiver {
    final /* synthetic */ AboutActivity f8335a;

    C2292b(AboutActivity aboutActivity) {
        this.f8335a = aboutActivity;
    }

    public void onReceive(Context context, Intent intent) {
        C2538c.m12677c("AboutActivity", "mNonLocalBroadcastReceiver(): intent = " + intent.getAction());
        String action = intent.getAction();
        if (action != null && action.equals("com.huawei.bone.action.CONNECTION_STATE_CHANGED") && ((DeviceInfo) intent.getParcelableExtra("deviceinfo")) != null) {
            this.f8335a.f8303D.post(new C2293c(this));
        }
    }
}
