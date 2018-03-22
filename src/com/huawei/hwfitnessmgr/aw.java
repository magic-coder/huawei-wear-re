package com.huawei.hwfitnessmgr;

import java.lang.ref.WeakReference;

/* compiled from: HWFitnessMgr */
class aw implements Runnable {
    WeakReference<q> f18168a;
    private int f18169b = 0;

    aw(q qVar, int i) {
        this.f18168a = new WeakReference(qVar);
        this.f18169b = i;
    }

    public void run() {
        q qVar = (q) this.f18168a.get();
        if (qVar != null) {
            qVar.c(this.f18169b);
        }
    }
}
