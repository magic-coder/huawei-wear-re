package com.huawei.bone.p552b;

import com.huawei.hwbasemgr.IBaseResponseCallback;

/* compiled from: MainInterators */
class C6773r implements IBaseResponseCallback {
    final /* synthetic */ C6756a f23197a;

    C6773r(C6756a c6756a) {
        this.f23197a = c6756a;
    }

    public void onResponse(int i, Object obj) {
        this.f23197a.f23126i.finish();
    }
}
