package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: ProfileSettingActivity */
class am implements OnClickListener {
    final /* synthetic */ ProfileSettingActivity f6596a;

    am(ProfileSettingActivity profileSettingActivity) {
        this.f6596a = profileSettingActivity;
    }

    public void onClick(View view) {
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "=============Press cancle");
        this.f6596a.f6374F.cancel();
        this.f6596a.f6374F = null;
    }
}
