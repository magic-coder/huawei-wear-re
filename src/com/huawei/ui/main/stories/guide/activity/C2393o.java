package com.huawei.ui.main.stories.guide.activity;

import com.huawei.hwcommonmodel.d.e;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.wheelview.WheelView;
import com.huawei.ui.commonui.wheelview.c;

/* compiled from: BasicInfoSettingActivity */
class C2393o implements c {
    final /* synthetic */ String[] f8659a;
    final /* synthetic */ String[] f8660b;
    final /* synthetic */ BasicInfoSettingActivity f8661c;

    C2393o(BasicInfoSettingActivity basicInfoSettingActivity, String[] strArr, String[] strArr2) {
        this.f8661c = basicInfoSettingActivity;
        this.f8659a = strArr;
        this.f8660b = strArr2;
    }

    public void onChanged(WheelView wheelView, int i, int i2) {
        int i3 = 250;
        C2538c.m12677c("BasicInfoSettingActivity", "setOnWheelChangedListener,onChanged.newValue = " + i2);
        if (i2 == 0) {
            C2538c.m12677c("BasicInfoSettingActivity", "setOnWheelChangedListener,onChanged.newValue = WEIGHT_UNIT_KG ");
            int f = e.f(C0977d.m3546c(this.f8661c.f8596a, this.f8661c.f8575B.getFisrtPickerValue()));
            C2538c.m12677c("BasicInfoSettingActivity", "setOnWheelChangedListener,onChanged.newValue = WEIGHT_UNIT_KG,valueLB=" + r3 + ",valueKG=" + f);
            if (10 > f) {
                f = 10;
            }
            if (250 >= f) {
                i3 = f;
            }
            this.f8661c.f8575B.a(this.f8659a, i3 - 10, true);
            return;
        }
        C2538c.m12677c("BasicInfoSettingActivity", "setOnWheelChangedListener,onChanged.newValue = WEIGHT_UNIT_LB ");
        i3 = e.g(C0977d.m3546c(this.f8661c.f8596a, this.f8661c.f8575B.getFisrtPickerValue()));
        C2538c.m12677c("BasicInfoSettingActivity", "initWeightPicker setOnWheelChangedListener,onChanged.newValue = WEIGHT_UNIT_LB,valueKG=" + r2 + ",valueLB=" + i3);
        if (22 > i3) {
            i3 = 22;
        }
        if (552 < i3) {
            i3 = 552;
        }
        this.f8661c.f8575B.a(this.f8660b, i3 - 22, true);
    }
}
