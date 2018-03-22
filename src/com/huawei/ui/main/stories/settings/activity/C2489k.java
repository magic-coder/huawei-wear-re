package com.huawei.ui.main.stories.settings.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: PersonalPrivacySettingsActivity */
class C2489k implements OnClickListener {
    final /* synthetic */ PersonalPrivacySettingsActivity f8956a;

    C2489k(PersonalPrivacySettingsActivity personalPrivacySettingsActivity) {
        this.f8956a = personalPrivacySettingsActivity;
    }

    public void onClick(View view) {
        C2538c.m12677c(PersonalPrivacySettingsActivity.f8910a, "start showPrivacyNoticeDialog, user click Positive button!  ");
        this.f8956a.m12359a(false);
        this.f8956a.m12366b(false);
        this.f8956a.f8924g.dismiss();
        this.f8956a.f8924g = null;
    }
}
