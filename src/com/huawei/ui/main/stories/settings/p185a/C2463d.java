package com.huawei.ui.main.stories.settings.p185a;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: PersonalPrivacySettingsInteractors */
class C2463d implements IBaseResponseCallback {
    final /* synthetic */ String f8842a;
    final /* synthetic */ C2460a f8843b;

    C2463d(C2460a c2460a, String str) {
        this.f8843b = c2460a;
        this.f8842a = str;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0 && obj != null && (obj instanceof String)) {
            String str = (String) obj;
            C2538c.m12677c(C2460a.f8834a, "deletePersonalPrivacyMessage... messageID = " + str + ", messageType = " + this.f8842a);
            this.f8843b.f8837d.m10252b(str);
        }
    }
}
