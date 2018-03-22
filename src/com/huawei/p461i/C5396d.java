package com.huawei.p461i;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.p190v.C2538c;

/* compiled from: HWAlarmManager */
class C5396d implements IBaseResponseCallback {
    final /* synthetic */ C5393a f19212a;

    C5396d(C5393a c5393a) {
        this.f19212a = c5393a;
    }

    public void onResponse(int i, Object obj) {
        byte[] bArr = (byte[]) obj;
        C2538c.c("HWAlarmManager", new Object[]{"Alarm manager receive data = " + C0973a.a(bArr)});
        if (this.f19212a.m25988c() == 0) {
            C2538c.c("HWAlarmManager", new Object[]{"Start to resolve V0 Result"});
            this.f19212a.m25955a(bArr);
            return;
        }
        this.f19212a.m25961b(bArr);
    }
}
