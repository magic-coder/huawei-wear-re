package com.huawei.ui.main.stories.about.activity.legalinformation;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: PrivacyPolicyActivity */
class C2315c implements OnClickListener {
    final /* synthetic */ PrivacyPolicyActivity f8401a;

    C2315c(PrivacyPolicyActivity privacyPolicyActivity) {
        this.f8401a = privacyPolicyActivity;
    }

    public void onClick(View view) {
        C2538c.m12674b("PrivacyPolicyActivity", "===www===btnRetry onClick ");
        this.f8401a.m11847d();
        this.f8401a.f8393e.setVisibility(0);
        this.f8401a.m11848d(this.f8401a.f8394f);
    }
}
