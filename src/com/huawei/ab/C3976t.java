package com.huawei.ab;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcloudmodel.callback.C3957a;

/* compiled from: HWUserProfileMgr */
class C3976t implements C3957a<Boolean> {
    final /* synthetic */ IBaseResponseCallback f15214a;
    final /* synthetic */ m f15215b;

    C3976t(m mVar, IBaseResponseCallback iBaseResponseCallback) {
        this.f15215b = mVar;
        this.f15214a = iBaseResponseCallback;
    }

    public void m19691a(Boolean bool, String str, boolean z) {
        if (z) {
            this.f15214a.onResponse(0, null);
        } else {
            this.f15214a.onResponse(300099, null);
        }
    }
}
