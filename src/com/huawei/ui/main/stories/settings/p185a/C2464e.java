package com.huawei.ui.main.stories.settings.p185a;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: PersonalPrivacySettingsInteractors */
class C2464e implements IBaseResponseCallback {
    final /* synthetic */ C2460a f8844a;

    C2464e(C2460a c2460a) {
        this.f8844a = c2460a;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0) {
            C2538c.m12677c(C2460a.f8834a, "onResponse setUserPrivacy success ");
            return;
        }
        C2538c.m12680e(C2460a.f8834a, "onResponse setUserPrivacy failure");
    }
}
