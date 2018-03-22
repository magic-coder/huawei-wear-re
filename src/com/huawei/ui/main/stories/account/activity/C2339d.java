package com.huawei.ui.main.stories.account.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: ThirdPartyLoginActivity */
class C2339d implements OnClickListener {
    final /* synthetic */ String f8485a;
    final /* synthetic */ String f8486b;
    final /* synthetic */ ThirdPartyLoginActivity f8487c;

    C2339d(ThirdPartyLoginActivity thirdPartyLoginActivity, String str, String str2) {
        this.f8487c = thirdPartyLoginActivity;
        this.f8485a = str;
        this.f8486b = str2;
    }

    public void onClick(View view) {
        C2538c.m12677c(ThirdPartyLoginActivity.f8465h, "accountmigrate: showDataMigrateDialog ok");
        if (this.f8487c.f8474i != null) {
            this.f8487c.f8474i.execute(new C2340e(this));
        }
    }
}
