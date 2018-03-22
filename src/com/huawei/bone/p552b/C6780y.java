package com.huawei.bone.p552b;

import com.huawei.hwbasemgr.IBaseResponseCallback;

/* compiled from: MainInterators */
class C6780y implements IBaseResponseCallback {
    final /* synthetic */ C6756a f23208a;

    C6780y(C6756a c6756a) {
        this.f23208a = c6756a;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0) {
            this.f23208a.f23137t.sendEmptyMessage(100);
        } else {
            this.f23208a.f23126i.finish();
        }
    }
}
