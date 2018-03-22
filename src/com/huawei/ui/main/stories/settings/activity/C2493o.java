package com.huawei.ui.main.stories.settings.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.login.ui.login.C1093a;
import com.huawei.p190v.C2538c;

/* compiled from: PersonalPrivacySettingsActivity */
class C2493o implements OnClickListener {
    final /* synthetic */ PersonalPrivacySettingsActivity f8960a;

    C2493o(PersonalPrivacySettingsActivity personalPrivacySettingsActivity) {
        this.f8960a = personalPrivacySettingsActivity;
    }

    public void onClick(View view) {
        C2538c.m12677c(PersonalPrivacySettingsActivity.f8910a, "Enter sure");
        this.f8960a.f8915E.dismiss();
        C1093a.m4739a(BaseApplication.m2632b()).m4756i();
    }
}
