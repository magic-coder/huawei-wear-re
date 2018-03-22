package com.huawei.p091m;

import com.huawei.hihealth.data.p312b.C3951c;
import com.huawei.m.d;
import com.huawei.p190v.C2538c;

/* compiled from: CoreSleepMgrStorage */
class C5454b implements C3951c {
    final /* synthetic */ d f19298a;
    final /* synthetic */ C5453a f19299b;

    C5454b(C5453a c5453a, d dVar) {
        this.f19299b = c5453a;
        this.f19298a = dVar;
    }

    public void onResult(int i, Object obj) {
        C2538c.c("CoreSleepMgrStorage", new Object[]{"insertCoreSleepStatusToHiHealth onResult type=", Integer.valueOf(i), " obj=", obj});
        if (i == 0) {
            C2538c.c("CoreSleepMgrStorage", new Object[]{"insertCoreSleepStatusToHiHealth success"});
            this.f19298a.a(this.f19298a.d());
            return;
        }
        C2538c.e("CoreSleepMgrStorage", new Object[]{"insertCoreSleepStatusToHiHealth not correct obj=", obj});
    }
}
