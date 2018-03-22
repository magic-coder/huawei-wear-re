package com.huawei.ui.main.stories.settings.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: PersonalPrivacySettingsActivity */
class C2494p implements OnClickListener {
    final /* synthetic */ PersonalPrivacySettingsActivity f8961a;

    C2494p(PersonalPrivacySettingsActivity personalPrivacySettingsActivity) {
        this.f8961a = personalPrivacySettingsActivity;
    }

    public void onClick(View view) {
        C2538c.m12677c(PersonalPrivacySettingsActivity.f8910a, "Enter cancle");
        this.f8961a.f8915E.dismiss();
    }
}
