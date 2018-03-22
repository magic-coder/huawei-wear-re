package com.huawei.ui.main.stories.settings.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: PersonalPrivacySettingsActivity */
class C2490l implements OnClickListener {
    final /* synthetic */ PersonalPrivacySettingsActivity f8957a;

    C2490l(PersonalPrivacySettingsActivity personalPrivacySettingsActivity) {
        this.f8957a = personalPrivacySettingsActivity;
    }

    public void onClick(View view) {
        C2538c.m12677c(PersonalPrivacySettingsActivity.f8910a, "start showPrivacyNoticeOpenDialog, user click Negative button!  ");
        this.f8957a.f8927j = false;
        this.f8957a.m12359a(false);
        this.f8957a.f8923f.dismiss();
        this.f8957a.f8923f = null;
    }
}
