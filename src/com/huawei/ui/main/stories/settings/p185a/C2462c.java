package com.huawei.ui.main.stories.settings.p185a;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: PersonalPrivacySettingsInteractors */
class C2462c implements IBaseResponseCallback {
    final /* synthetic */ C2461b f8841a;

    C2462c(C2461b c2461b) {
        this.f8841a = c2461b;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0 && obj != null && (obj instanceof Boolean)) {
            if (!((Boolean) obj).booleanValue()) {
                this.f8841a.f8840b.f8838e.m2310a(true);
            }
            C2538c.m12677c(C2460a.f8834a, "Leave generatePersonalPrivacyMessage !!!");
        }
    }
}
