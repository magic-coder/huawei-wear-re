package com.huawei.bone.p552b;

import com.huawei.hwbasemgr.IBaseResponseCallback;

/* compiled from: MainInterators */
class C6758c implements IBaseResponseCallback {
    final /* synthetic */ C6756a f23174a;

    C6758c(C6756a c6756a) {
        this.f23174a = c6756a;
    }

    public void onResponse(int i, Object obj) {
        this.f23174a.f23126i.runOnUiThread(new C6759d(this, i));
    }
}
