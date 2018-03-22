package com.huawei.aa;

import com.huawei.hihealth.data.p312b.C3951c;
import com.huawei.p190v.C2538c;

/* compiled from: HWStressMgr */
class C3952c implements C3951c {
    final /* synthetic */ a f15162a;

    C3952c(a aVar) {
        this.f15162a = aVar;
    }

    public void onResult(int i, Object obj) {
        C2538c.c("HWStressMgr", new Object[]{"insertStressDetailsListToHiHealth onResult type=", Integer.valueOf(i), ", obj = ", obj});
        if (i == 0) {
            C2538c.c("HWStressMgr", new Object[]{"insertStressDetailsListToHiHealth success."});
            a.b(this.f15162a, true);
        } else {
            C2538c.e("HWStressMgr", new Object[]{"insertCoreSleepStatusToHiHealth not correct obj=", obj});
            a.b(this.f15162a, false);
        }
        a.c(this.f15162a).sendEmptyMessage(1);
    }
}
