package com.huawei.p091m;

import com.huawei.hihealth.data.p312b.C3951c;
import com.huawei.m.d;
import com.huawei.p190v.C2538c;

/* compiled from: CoreSleepMgrStorage */
class C5455c implements C3951c {
    final /* synthetic */ d f19300a;
    final /* synthetic */ C5453a f19301b;

    C5455c(C5453a c5453a, d dVar) {
        this.f19301b = c5453a;
        this.f19300a = dVar;
    }

    public void onResult(int i, Object obj) {
        C2538c.c("CoreSleepMgrStorage", new Object[]{"insertCoreSleepCalcToHiHealth onResult type=", Integer.valueOf(i), " obj=", obj});
        if (i == 0) {
            C2538c.c("CoreSleepMgrStorage", new Object[]{"insertCoreSleepCalcToHiHealth success"});
        } else {
            C2538c.e("CoreSleepMgrStorage", new Object[]{"insertCoreSleepCalcToHiHealth not correct obj=", obj});
        }
        this.f19300a.b();
    }
}
