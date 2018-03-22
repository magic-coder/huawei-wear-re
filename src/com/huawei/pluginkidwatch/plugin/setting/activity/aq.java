package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.huawei.pluginkidwatch.common.ui.wheelview.C1608i;

/* compiled from: ProfileSettingActivity */
class aq implements OnClickListener {
    final /* synthetic */ C1608i f6600a;
    final /* synthetic */ ProfileSettingActivity f6601b;

    aq(ProfileSettingActivity profileSettingActivity, C1608i c1608i) {
        this.f6601b = profileSettingActivity;
        this.f6600a = c1608i;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f6601b.m9878a(this.f6600a);
    }
}
