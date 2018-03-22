package com.huawei.aa;

import com.huawei.hihealth.data.p312b.C3951c;
import com.huawei.p190v.C2538c;

/* compiled from: HWStressMgr */
class C3953d implements C3951c {
    final /* synthetic */ a f15163a;

    C3953d(a aVar) {
        this.f15163a = aVar;
    }

    public void onResult(int i, Object obj) {
        C2538c.c("HWStressMgr", new Object[]{"insertRelaxDetailsListToHiHealth onResult type = ", Integer.valueOf(i), ",obj = ", obj});
        if (i == 0) {
            C2538c.c("HWStressMgr", new Object[]{"insertRelaxDetailsListToHiHealth success"});
            a.c(this.f15163a, true);
            if (a.d(this.f15163a) && a.e(this.f15163a)) {
                a.a(this.f15163a, a.f(this.f15163a));
            }
            if (a.a(this.f15163a) != null) {
                a.a(this.f15163a).onResponse(400001, "save successful.");
            }
        } else {
            a.c(this.f15163a, false);
            C2538c.e("HWStressMgr", new Object[]{"insertRelaxDetailsListToHiHealth not correct obj=", obj});
            if (a.a(this.f15163a) != null) {
                a.a(this.f15163a).onResponse(400003, "save fail.");
            }
        }
        if (a.c(this.f15163a) != null) {
            a.c(this.f15163a).removeMessages(0);
        }
        a.a(this.f15163a, false);
    }
}
