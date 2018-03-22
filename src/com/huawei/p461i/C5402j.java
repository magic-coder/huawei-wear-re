package com.huawei.p461i;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: HWAlarmManager */
class C5402j implements IBaseResponseCallback {
    final /* synthetic */ C5393a f19218a;

    C5402j(C5393a c5393a) {
        this.f19218a = c5393a;
    }

    public void onResponse(int i, Object obj) {
        C2538c.c("HWAlarmManager", new Object[]{"autoSendResponseCallback() is comeback, err_code = " + i});
    }
}
