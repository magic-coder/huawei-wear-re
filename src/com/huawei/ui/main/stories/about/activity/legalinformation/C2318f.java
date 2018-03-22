package com.huawei.ui.main.stories.about.activity.legalinformation;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: PrivacyPolicyActivity */
class C2318f implements OnClickListener {
    final /* synthetic */ Context f8404a;
    final /* synthetic */ PrivacyPolicyActivity f8405b;

    C2318f(PrivacyPolicyActivity privacyPolicyActivity, Context context) {
        this.f8405b = privacyPolicyActivity;
        this.f8404a = context;
    }

    public void onClick(View view) {
        C2538c.m12674b("PrivacyPolicyActivity", "===www===onKeyDown  DialogInterface.BUTTON_POSITIVE");
        this.f8405b.f8397i.cancel();
        this.f8405b.f8393e.setVisibility(0);
        this.f8405b.m11848d(this.f8404a);
    }
}
