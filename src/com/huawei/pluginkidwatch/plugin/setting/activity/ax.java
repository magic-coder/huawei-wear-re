package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: ProfileSettingActivity */
class ax implements OnClickListener {
    final /* synthetic */ ProfileSettingActivity f6608a;

    ax(ProfileSettingActivity profileSettingActivity) {
        this.f6608a = profileSettingActivity;
    }

    public void onClick(View view) {
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "=============Press Sure");
        this.f6608a.f6375G = this.f6608a.f6370B;
        this.f6608a.m9872a(this.f6608a.f6370B);
        this.f6608a.f6374F.cancel();
        this.f6608a.f6374F = null;
    }
}
