package com.huawei.hwfitnessmgr;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: HWFitnessMgr */
class ac implements IBaseResponseCallback {
    final /* synthetic */ ab f18142a;

    ac(ab abVar) {
        this.f18142a = abVar;
    }

    public void onResponse(int i, Object obj) {
        C2538c.c("HWFitnessMgr", new Object[]{"更新本地和数据平台结果 = " + i});
    }
}
