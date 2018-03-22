package com.huawei.ui.main.stories.settings.activity;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.login.ui.login.C1093a;
import com.huawei.p190v.C2538c;

/* compiled from: PersonalPrivacySettingsActivity */
class C2486h implements IBaseResponseCallback {
    final /* synthetic */ PersonalPrivacySettingsActivity f8953a;

    C2486h(PersonalPrivacySettingsActivity personalPrivacySettingsActivity) {
        this.f8953a = personalPrivacySettingsActivity;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c(PersonalPrivacySettingsActivity.f8910a, "loginForCenter err_code：" + i);
        if (i != 0) {
            return;
        }
        if (((String) obj).equals(C1093a.m4739a(BaseApplication.m2632b()).m4750c())) {
            C2538c.m12677c(PersonalPrivacySettingsActivity.f8910a, "hide mLougout");
            this.f8953a.f8933p.setVisibility(8);
            return;
        }
        C2538c.m12677c(PersonalPrivacySettingsActivity.f8910a, "show mLougout 1");
        this.f8953a.f8933p.setVisibility(0);
    }
}
