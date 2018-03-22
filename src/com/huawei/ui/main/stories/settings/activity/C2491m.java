package com.huawei.ui.main.stories.settings.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: PersonalPrivacySettingsActivity */
class C2491m implements OnClickListener {
    final /* synthetic */ PersonalPrivacySettingsActivity f8958a;

    C2491m(PersonalPrivacySettingsActivity personalPrivacySettingsActivity) {
        this.f8958a = personalPrivacySettingsActivity;
    }

    public void onClick(View view) {
        C2538c.m12677c(PersonalPrivacySettingsActivity.f8910a, "start showPrivacyNoticeOpenDialog, user click Positive button!  ");
        this.f8958a.m12359a(true);
        this.f8958a.m12366b(true);
        this.f8958a.f8923f.dismiss();
        this.f8958a.f8923f = null;
    }
}
