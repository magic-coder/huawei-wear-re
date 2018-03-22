package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.g;

/* compiled from: ProfileSettingActivity */
class bh implements OnClickListener {
    final /* synthetic */ ProfileSettingActivity f6629a;

    bh(ProfileSettingActivity profileSettingActivity) {
        this.f6629a = profileSettingActivity;
    }

    public void onClick(View view) {
        if (g.setting_profile_lly_birthday == view.getId()) {
            this.f6629a.m9919m();
        } else if (g.setting_profile_lly_height == view.getId()) {
            C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "=======Enter mHeightArea onClick");
            this.f6629a.m9935u();
        } else if (g.setting_profile_lly_weight == view.getId()) {
            C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "=======Enter mWeightArea onClick");
            this.f6629a.m9932s();
        } else if (g.setting_profile_lly_sex == view.getId()) {
            this.f6629a.m9905f();
        }
    }
}
