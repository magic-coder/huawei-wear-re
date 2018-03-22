package com.huawei.hwfitnessmgr;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: HWFitnessMgr */
class ag implements IBaseResponseCallback {
    final /* synthetic */ q f18148a;

    ag(q qVar) {
        this.f18148a = qVar;
    }

    public void onResponse(int i, Object obj) {
        C2538c.c("HWFitnessMgr", new Object[]{"queryCoreSleepSwitchEnable err_code = " + i});
    }
}
