package com.huawei.ui.main.stories.account.activity;

import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.account.interactor.C2344c;

/* compiled from: ThirdPartyLoginActivity */
class C2345i implements C2344c {
    final /* synthetic */ ThirdPartyLoginActivity f8497a;

    C2345i(ThirdPartyLoginActivity thirdPartyLoginActivity) {
        this.f8497a = thirdPartyLoginActivity;
    }

    public void mo2657a(Object obj) {
        C2538c.m12677c(ThirdPartyLoginActivity.f8465h, "HuaweiCloudLogin.login onSuccess");
        this.f8497a.f8473g.runOnUiThread(new C2346j(this, obj));
    }

    public void mo2656a(int i, String str) {
        C2538c.m12677c(ThirdPartyLoginActivity.f8465h, "HuaweiCloudLogin.login onFailure errcode = " + i + "; errmsg = ", str);
        this.f8497a.f8473g.runOnUiThread(new C2347k(this));
    }
}
