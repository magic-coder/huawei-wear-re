package com.huawei.ui.main.stories.account.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.dialog.a;

/* compiled from: ThirdPartyLoginActivity */
class C2341f implements OnClickListener {
    final /* synthetic */ a f8489a;
    final /* synthetic */ ThirdPartyLoginActivity f8490b;

    C2341f(ThirdPartyLoginActivity thirdPartyLoginActivity, a aVar) {
        this.f8490b = thirdPartyLoginActivity;
        this.f8489a = aVar;
    }

    public void onClick(View view) {
        C2538c.m12677c(ThirdPartyLoginActivity.f8465h, "accountmigrate: showDataMigrateSuccessfulDialog ok");
        this.f8489a.dismiss();
    }
}
