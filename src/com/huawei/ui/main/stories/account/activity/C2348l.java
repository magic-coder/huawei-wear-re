package com.huawei.ui.main.stories.account.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.dialog.a;

/* compiled from: ThirdPartyLoginActivity */
class C2348l implements OnClickListener {
    final /* synthetic */ a f8501a;
    final /* synthetic */ ThirdPartyLoginActivity f8502b;

    C2348l(ThirdPartyLoginActivity thirdPartyLoginActivity, a aVar) {
        this.f8502b = thirdPartyLoginActivity;
        this.f8501a = aVar;
    }

    public void onClick(View view) {
        C2538c.m12677c(ThirdPartyLoginActivity.f8465h, "showDataMigrateDialogUpdateAndCancel on click");
        this.f8501a.dismiss();
    }
}
