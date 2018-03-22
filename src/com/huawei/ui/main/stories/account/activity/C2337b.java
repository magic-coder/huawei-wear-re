package com.huawei.ui.main.stories.account.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: ThirdPartyLoginActivity */
class C2337b implements OnClickListener {
    final /* synthetic */ ThirdPartyLoginActivity f8483a;

    C2337b(ThirdPartyLoginActivity thirdPartyLoginActivity) {
        this.f8483a = thirdPartyLoginActivity;
    }

    public void onClick(View view) {
        C2538c.m12677c(ThirdPartyLoginActivity.f8465h, "accountmigrate: showDataMigrateDialog cancel");
        this.f8483a.f8475j.postDelayed(new C2338c(this), 500);
    }
}
