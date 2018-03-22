package com.huawei.bone.p552b;

import com.huawei.hwbasemgr.IBaseResponseCallback;

/* compiled from: MainInterators */
class C6775t implements IBaseResponseCallback {
    final /* synthetic */ C6756a f23199a;

    C6775t(C6756a c6756a) {
        this.f23199a = c6756a;
    }

    public void onResponse(int i, Object obj) {
        this.f23199a.f23126i.finish();
    }
}
