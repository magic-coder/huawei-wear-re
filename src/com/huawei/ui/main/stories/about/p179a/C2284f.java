package com.huawei.ui.main.stories.about.p179a;

import com.huawei.hwcloudmodel.callback.a;
import com.huawei.p190v.C2538c;

/* compiled from: CloudServiceInteractor */
class C2284f implements a {
    final /* synthetic */ C2283e f8288a;

    C2284f(C2283e c2283e) {
        this.f8288a = c2283e;
    }

    public void m11747a(Object obj, String str, boolean z) {
        if (z) {
            C2538c.m12674b("CloudServiceInteractor", "setCustomDefine success");
            return;
        }
        C2538c.m12674b("CloudServiceInteractor", "setCustomDefine failure");
    }
}
