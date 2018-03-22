package com.huawei.ui.main.stories.account.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.dialog.a;

/* compiled from: ThirdPartyLoginActivity */
class C2342g implements OnClickListener {
    final /* synthetic */ a f8491a;
    final /* synthetic */ ThirdPartyLoginActivity f8492b;

    C2342g(ThirdPartyLoginActivity thirdPartyLoginActivity, a aVar) {
        this.f8492b = thirdPartyLoginActivity;
        this.f8491a = aVar;
    }

    public void onClick(View view) {
        C2538c.m12677c(ThirdPartyLoginActivity.f8465h, "showHandleMigrateDialog on click");
        this.f8491a.dismiss();
    }
}
