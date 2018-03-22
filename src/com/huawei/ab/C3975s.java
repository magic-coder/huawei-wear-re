package com.huawei.ab;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcloudmodel.callback.C3957a;

/* compiled from: HWUserProfileMgr */
class C3975s implements C3957a<Boolean> {
    final /* synthetic */ IBaseResponseCallback f15212a;
    final /* synthetic */ m f15213b;

    C3975s(m mVar, IBaseResponseCallback iBaseResponseCallback) {
        this.f15213b = mVar;
        this.f15212a = iBaseResponseCallback;
    }

    public void m19689a(Boolean bool, String str, boolean z) {
        if (true == z) {
            this.f15212a.onResponse(0, null);
        } else {
            this.f15212a.onResponse(300099, null);
        }
    }
}
