package com.huawei.ui.main.stories.settings.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: PersonalPrivacySettingsActivity */
class C2481c implements OnClickListener {
    final /* synthetic */ PersonalPrivacySettingsActivity f8947a;

    C2481c(PersonalPrivacySettingsActivity personalPrivacySettingsActivity) {
        this.f8947a = personalPrivacySettingsActivity;
    }

    public void onClick(View view) {
        C2538c.m12677c(PersonalPrivacySettingsActivity.f8910a, "out the page");
        this.f8947a.finish();
    }
}
