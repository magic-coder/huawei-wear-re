package com.huawei.pluginkidwatch.plugin.setting.activity;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.ui.wheelview.C1603c;
import com.huawei.pluginkidwatch.common.ui.wheelview.WheelView;

/* compiled from: ProfileSettingActivity */
class ba implements C1603c {
    final /* synthetic */ String[] f6613a;
    final /* synthetic */ ProfileSettingActivity f6614b;

    ba(ProfileSettingActivity profileSettingActivity, String[] strArr) {
        this.f6614b = profileSettingActivity;
        this.f6613a = strArr;
    }

    public void mo2553a(WheelView wheelView, int i, int i2) {
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "initHeightPicker setOnWheelChangedListener,onChanged.newValue = " + i2);
        int a = ProfileSettingActivity.m9865a(C1492l.m6920d(this.f6614b.f6416w.m7424a()), C1492l.m6920d(this.f6614b.f6416w.m7427b()));
        this.f6614b.f6416w.m7426a(this.f6613a, 50, true);
        this.f6614b.f6416w.m7426a(this.f6613a, a - 50, true);
    }
}
