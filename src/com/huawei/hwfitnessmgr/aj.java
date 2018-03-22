package com.huawei.hwfitnessmgr;

import com.huawei.hwbasemgr.IBaseResponseCallback;

/* compiled from: HWFitnessMgr */
class aj implements IBaseResponseCallback {
    final /* synthetic */ q f18151a;

    aj(q qVar) {
        this.f18151a = qVar;
    }

    public void onResponse(int i, Object obj) {
        this.f18151a.a.execute(new at(this.f18151a, i, obj));
    }
}
