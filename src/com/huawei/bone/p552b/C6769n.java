package com.huawei.bone.p552b;

import com.huawei.hwbasemgr.IBaseResponseCallback;

/* compiled from: MainInterators */
class C6769n implements IBaseResponseCallback {
    final /* synthetic */ C6756a f23193a;

    C6769n(C6756a c6756a) {
        this.f23193a = c6756a;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0) {
            this.f23193a.f23137t.sendEmptyMessage(101);
        } else {
            this.f23193a.f23126i.finish();
        }
    }
}
