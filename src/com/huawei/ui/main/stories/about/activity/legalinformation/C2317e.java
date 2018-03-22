package com.huawei.ui.main.stories.about.activity.legalinformation;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: PrivacyPolicyActivity */
class C2317e implements OnClickListener {
    final /* synthetic */ PrivacyPolicyActivity f8403a;

    C2317e(PrivacyPolicyActivity privacyPolicyActivity) {
        this.f8403a = privacyPolicyActivity;
    }

    public void onClick(View view) {
        C2538c.m12674b("PrivacyPolicyActivity", "===www===onKeyDown DialogInterface.BUTTON_POSITIVE");
        this.f8403a.f8397i.cancel();
        this.f8403a.finish();
    }
}
