package com.huawei.ui.main.stories.settings.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: PersonalPrivacySettingsActivity */
class C2488j implements OnClickListener {
    final /* synthetic */ PersonalPrivacySettingsActivity f8955a;

    C2488j(PersonalPrivacySettingsActivity personalPrivacySettingsActivity) {
        this.f8955a = personalPrivacySettingsActivity;
    }

    public void onClick(View view) {
        C2538c.m12677c(PersonalPrivacySettingsActivity.f8910a, "start showPrivacyNoticeDialog, user click Negative button!  ");
        this.f8955a.f8927j = false;
        this.f8955a.m12359a(true);
        this.f8955a.f8924g.dismiss();
        this.f8955a.f8924g = null;
    }
}
