package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

/* compiled from: ProfileSettingActivity */
class ar implements OnDismissListener {
    final /* synthetic */ ProfileSettingActivity f6602a;

    ar(ProfileSettingActivity profileSettingActivity) {
        this.f6602a = profileSettingActivity;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f6602a.f6409p = null;
    }
}
