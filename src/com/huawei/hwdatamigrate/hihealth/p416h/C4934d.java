package com.huawei.hwdatamigrate.hihealth.p416h;

import com.huawei.hwdatamigrate.hihealth.a.a;
import com.huawei.p190v.C2538c;

import java.lang.ref.WeakReference;

/* compiled from: HiHealthDataInsertStore */
class C4934d implements Runnable {
    private WeakReference<C4924a> f18019a;

    public C4934d(C4924a c4924a) {
        this.f18019a = new WeakReference(c4924a);
    }

    public void run() {
        C4924a c4924a = (C4924a) this.f18019a.get();
        if (c4924a == null) {
            C2538c.d("HiH_HiHealthDataInsertStore", new Object[]{"StatDataRunnable() insertStore = null"});
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        c4924a.m23751d();
        a.a(C4924a.f17976a, 0);
        com.huawei.hwdatamigrate.hihealth.e.a.a().a(200, "doAsyncHealthDataStat", null);
        C2538c.b("HiH_HiHealthDataInsertStore", new Object[]{"StatDataRunnable() stat totalTime = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }
}
