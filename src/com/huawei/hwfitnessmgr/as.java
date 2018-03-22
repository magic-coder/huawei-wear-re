package com.huawei.hwfitnessmgr;

import java.lang.ref.WeakReference;

/* compiled from: HWFitnessMgr */
class as implements Runnable {
    WeakReference<q> f18160a;

    as(q qVar) {
        this.f18160a = new WeakReference(qVar);
    }

    public void run() {
        q qVar = (q) this.f18160a.get();
        if (qVar != null) {
            q.a(qVar);
        }
    }
}
