package com.huawei.pluginkidwatch.plugin.setting.activity;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.ui.wheelview.C1603c;
import com.huawei.pluginkidwatch.common.ui.wheelview.WheelView;

/* compiled from: ProfileSettingActivity */
class az implements C1603c {
    final /* synthetic */ String[] f6610a;
    final /* synthetic */ ProfileSettingActivity f6611b;

    az(ProfileSettingActivity profileSettingActivity, String[] strArr) {
        this.f6611b = profileSettingActivity;
        this.f6610a = strArr;
    }

    public void mo2553a(WheelView wheelView, int i, int i2) {
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "initWeightPicker setOnWheelChangedListener,onChanged.newValue = " + i2);
        this.f6611b.f6415v.m7426a(this.f6610a, C1492l.m6920d(this.f6611b.f6415v.m7424a()) - 3, true);
    }
}
