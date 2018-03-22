package com.huawei.ui.main.stories.settings.p185a;

import com.huawei.hwcommonmodel.d.e;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.wheelview.WheelView;
import com.huawei.ui.commonui.wheelview.c;
import com.huawei.ui.main.j;

/* compiled from: UserProfileSettingsInteractors */
class C2470k implements c {
    final /* synthetic */ C2465f f8878a;

    C2470k(C2465f c2465f) {
        this.f8878a = c2465f;
    }

    public void onChanged(WheelView wheelView, int i, int i2) {
        int i3 = 250;
        int i4 = 50;
        C2538c.m12677c("UserProfileSettingsInteractors", "setOnWheelChangedListener,onChanged.newValue = " + i2);
        int b;
        if (1 == i2) {
            C2538c.m12677c("UserProfileSettingsInteractors", "setOnWheelChangedListener,onChanged.newValue = HEIGHT_UNIT_FT ");
            i3 = C0977d.m3546c(this.f8878a.f8859m, this.f8878a.f8854h.getFisrtPickerValue());
            i4 = e.a(i3);
            C2538c.m12677c("UserProfileSettingsInteractors", "setOnWheelChangedListener,onChanged.newValue = HEIGHT_UNIT_FT,value=" + i3 + ",iHeightFeet=" + i4 + ",iRemainderHeightInches=" + e.d(i3));
            this.f8878a.f8854h.b();
            this.f8878a.f8854h.a(this.f8878a.f8848b, i4 - 1, true);
            this.f8878a.f8854h.setFirstWheelPickValueUnit(this.f8878a.f8859m.getString(j.IDS_ft));
            this.f8878a.f8854h.b(this.f8878a.f8849c, b + 0, true);
            this.f8878a.f8854h.setSecondWheelPickValueUnit(this.f8878a.f8859m.getString(j.IDS_ins));
            return;
        }
        C2538c.m12677c("UserProfileSettingsInteractors", "setOnWheelChangedListener,onChanged.newValue = HEIGHT_UNIT_CM ");
        b = e.b(C0977d.m3546c(this.f8878a.f8859m, this.f8878a.f8854h.getFisrtPickerValue()), C0977d.m3546c(this.f8878a.f8859m, this.f8878a.f8854h.getSecondPickerValue()));
        C2538c.m12677c("UserProfileSettingsInteractors", "initHeightWheelView setOnWheelChangedListener,onChanged.newValue = HEIGHT_UNIT_CM,feetInteger=" + r3 + ",feetRemainder=" + r4 + ",ftToCM=" + b);
        if (50 <= b) {
            i4 = b;
        }
        if (250 >= i4) {
            i3 = i4;
        }
        this.f8878a.f8854h.a();
        this.f8878a.f8854h.a(this.f8878a.f8847a, i3 - 50, true);
        this.f8878a.f8854h.setFirstWheelPickValueUnit("");
        this.f8878a.f8854h.setSecondWheelPickValueUnit("");
    }
}
