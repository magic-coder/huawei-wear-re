package com.huawei.ui.main.stories.settings.activity;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.d.e;
import com.huawei.p190v.C2538c;
import com.huawei.up.model.UserInfomation;

/* compiled from: PersonalPrivacySettingsActivity */
class C2484f implements IBaseResponseCallback {
    final /* synthetic */ boolean f8950a;
    final /* synthetic */ PersonalPrivacySettingsActivity f8951b;

    C2484f(PersonalPrivacySettingsActivity personalPrivacySettingsActivity, boolean z) {
        this.f8951b = personalPrivacySettingsActivity;
        this.f8950a = z;
    }

    public void onResponse(int i, Object obj) {
        UserInfomation userInfomation = (UserInfomation) obj;
        if (userInfomation == null) {
            C2538c.m12680e(PersonalPrivacySettingsActivity.f8910a, "heightSetUserInfoGet is null!!");
            return;
        }
        C2538c.m12674b(PersonalPrivacySettingsActivity.f8910a, "userInfoGet" + userInfomation.toString());
        this.f8951b.f8942y = userInfomation.getHeight();
        this.f8951b.f8943z = userInfomation.getWeight();
        if (this.f8950a) {
            if (userInfomation.getClientSet() == 0) {
                this.f8951b.f8942y = e.e(userInfomation.getHeight());
                this.f8951b.f8943z = e.g(userInfomation.getWeight());
                this.f8951b.f8941x = 1;
            }
        } else if (1 == userInfomation.getClientSet()) {
            int g = this.f8951b.f8942y;
            this.f8951b.f8940w;
            g /= 12;
            int g2 = this.f8951b.f8942y;
            this.f8951b.f8940w;
            this.f8951b.f8942y = e.b(g, g2 - (g * 12));
            this.f8951b.f8943z = e.f(userInfomation.getWeight());
            this.f8951b.f8941x = 0;
        }
        userInfomation.setHeight(Integer.valueOf(this.f8951b.f8942y));
        userInfomation.setWeight(Integer.valueOf(this.f8951b.f8943z));
        userInfomation.setClientSet(Integer.valueOf(this.f8951b.f8941x));
        userInfomation.setGender(Integer.valueOf(-1000));
        userInfomation.setName(null);
        userInfomation.setBirthday("");
        userInfomation.setPicPath("");
        C2538c.m12677c(PersonalPrivacySettingsActivity.f8910a, "userInfoGet---change！" + userInfomation.toString());
        this.f8951b.f8940w.m12318a(this.f8951b.f8928k, userInfomation, new C2485g(this));
    }
}
