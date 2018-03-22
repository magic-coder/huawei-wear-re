package com.huawei.bone.p552b;

import com.huawei.hwbasemgr.IBaseResponseCallback;

/* compiled from: MainInterators */
class C6774s implements IBaseResponseCallback {
    final /* synthetic */ C6756a f23198a;

    C6774s(C6756a c6756a) {
        this.f23198a = c6756a;
    }

    public void onResponse(int i, Object obj) {
        this.f23198a.f23126i.finish();
    }
}
