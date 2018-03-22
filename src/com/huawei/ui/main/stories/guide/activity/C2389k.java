package com.huawei.ui.main.stories.guide.activity;

import com.huawei.hwcommonmodel.d.e;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.wheelview.WheelView;
import com.huawei.ui.commonui.wheelview.c;
import com.huawei.ui.main.j;

/* compiled from: BasicInfoSettingActivity */
class C2389k implements c {
    final /* synthetic */ String[] f8652a;
    final /* synthetic */ String[] f8653b;
    final /* synthetic */ String[] f8654c;
    final /* synthetic */ BasicInfoSettingActivity f8655d;

    C2389k(BasicInfoSettingActivity basicInfoSettingActivity, String[] strArr, String[] strArr2, String[] strArr3) {
        this.f8655d = basicInfoSettingActivity;
        this.f8652a = strArr;
        this.f8653b = strArr2;
        this.f8654c = strArr3;
    }

    public void onChanged(WheelView wheelView, int i, int i2) {
        int i3 = 250;
        int i4 = 50;
        C2538c.m12677c("BasicInfoSettingActivity", "setOnWheelChangedListener,onChanged.newValue = " + i2);
        if (1 == i2) {
            int b;
            C2538c.m12677c("BasicInfoSettingActivity", "setOnWheelChangedListener,onChanged.newValue = HEIGHT_UNIT_FT ");
            i3 = C0977d.m3546c(this.f8655d.f8596a, this.f8655d.f8574A.getFisrtPickerValue());
            i4 = e.a(i3);
            C2538c.m12677c("BasicInfoSettingActivity", "setOnWheelChangedListener,onChanged.newValue = HEIGHT_UNIT_FT,value=" + i3 + ",iHeightFeet=" + i4 + ",iRemainderHeightInches=" + e.d(i3));
            this.f8655d.f8574A.b();
            this.f8655d.f8574A.a(this.f8652a, i4 - 1, true);
            this.f8655d.f8574A.setFirstWheelPickValueUnit(this.f8655d.f8596a.getString(j.IDS_ft));
            this.f8655d.f8574A.b(this.f8653b, b + 0, true);
            this.f8655d.f8574A.setSecondWheelPickValueUnit(this.f8655d.f8596a.getString(j.IDS_ins));
            return;
        }
        C2538c.m12677c("BasicInfoSettingActivity", "setOnWheelChangedListener,onChanged.newValue = HEIGHT_UNIT_CM ");
        b = e.b(C0977d.m3546c(this.f8655d.f8596a, this.f8655d.f8574A.getFisrtPickerValue()), C0977d.m3546c(this.f8655d.f8596a, this.f8655d.f8574A.getSecondPickerValue()));
        C2538c.m12677c("BasicInfoSettingActivity", "initHeightWheelView setOnWheelChangedListener,onChanged.newValue = HEIGHT_UNIT_CM,feetInteger=" + r3 + ",feetRemainder=" + r4 + ",ftToCM=" + b);
        if (50 <= b) {
            i4 = b;
        }
        if (250 >= i4) {
            i3 = i4;
        }
        this.f8655d.f8574A.a();
        this.f8655d.f8574A.a(this.f8654c, i3 - 50, true);
        this.f8655d.f8574A.setFirstWheelPickValueUnit("");
        this.f8655d.f8574A.setSecondWheelPickValueUnit("");
    }
}
