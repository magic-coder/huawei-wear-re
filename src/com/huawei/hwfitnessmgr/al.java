package com.huawei.hwfitnessmgr;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: HWFitnessMgr */
class al implements IBaseResponseCallback {
    final /* synthetic */ ak f18153a;

    al(ak akVar) {
        this.f18153a = akVar;
    }

    public void onResponse(int i, Object obj) {
        C2538c.c("HWFitnessMgr", new Object[]{"receive push and start sync  err:" + i});
    }
}
