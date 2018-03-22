package com.huawei.ui.main.stories.settings.p185a;

import com.huawei.hwcommonmodel.d.e;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.wheelview.WheelView;
import com.huawei.ui.commonui.wheelview.c;

/* compiled from: UserProfileSettingsInteractors */
class C2476q implements c {
    final /* synthetic */ C2465f f8886a;

    C2476q(C2465f c2465f) {
        this.f8886a = c2465f;
    }

    public void onChanged(WheelView wheelView, int i, int i2) {
        int i3 = 250;
        C2538c.m12677c("UserProfileSettingsInteractors", "setOnWheelChangedListener,onChanged.newValue = " + i2);
        if (i2 == 0) {
            C2538c.m12677c("UserProfileSettingsInteractors", "setOnWheelChangedListener,onChanged.newValue = WEIGHT_UNIT_KG ");
            int f = e.f(C0977d.m3546c(this.f8886a.f8859m, this.f8886a.f8856j.getFisrtPickerValue()));
            C2538c.m12677c("UserProfileSettingsInteractors", "setOnWheelChangedListener,onChanged.newValue = WEIGHT_UNIT_KG,valueLB=" + r3 + ",valueKG=" + f);
            if (10 > f) {
                f = 10;
            }
            if (250 >= f) {
                i3 = f;
            }
            this.f8886a.f8856j.a(this.f8886a.f8851e, i3 - 10, true);
            return;
        }
        C2538c.m12677c("UserProfileSettingsInteractors", "setOnWheelChangedListener,onChanged.newValue = WEIGHT_UNIT_LB ");
        i3 = e.g(C0977d.m3546c(this.f8886a.f8859m, this.f8886a.f8856j.getFisrtPickerValue()));
        C2538c.m12677c("UserProfileSettingsInteractors", "initWeightPicker setOnWheelChangedListener,onChanged.newValue = WEIGHT_UNIT_LB,valueKG=" + r2 + ",valueLB=" + i3);
        if (22 > i3) {
            i3 = 22;
        }
        if (552 < i3) {
            i3 = 552;
        }
        this.f8886a.f8856j.a(this.f8886a.f8852f, i3 - 22, true);
    }
}
