package com.huawei.p510u;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: HWLinkLossAlarmManager */
class C5981d implements IBaseResponseCallback {
    final /* synthetic */ C5978a f20584a;

    C5981d(C5978a c5978a) {
        this.f20584a = c5978a;
    }

    public void onResponse(int i, Object obj) {
        C2538c.e("HWLinkLossAlarmManager", new Object[]{"autoSendCommend response: " + obj});
    }
}
