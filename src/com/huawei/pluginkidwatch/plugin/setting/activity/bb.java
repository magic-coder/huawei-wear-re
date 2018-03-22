package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ProfileSettingActivity */
class bb implements OnClickListener {
    final /* synthetic */ ProfileSettingActivity f6615a;

    bb(ProfileSettingActivity profileSettingActivity) {
        this.f6615a = profileSettingActivity;
    }

    public void onClick(View view) {
        this.f6615a.f6374F.cancel();
        this.f6615a.f6374F = null;
    }
}
