package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

/* compiled from: ProfileSettingActivity */
class ay implements OnDismissListener {
    final /* synthetic */ ProfileSettingActivity f6609a;

    ay(ProfileSettingActivity profileSettingActivity) {
        this.f6609a = profileSettingActivity;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f6609a.f6407n = null;
    }
}
