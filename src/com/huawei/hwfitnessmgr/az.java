package com.huawei.hwfitnessmgr;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import java.lang.ref.WeakReference;

/* compiled from: HWFitnessMgr */
class az implements Runnable {
    private static String f18176c = "syncTodayLock";
    WeakReference<q> f18177a;
    IBaseResponseCallback f18178b = null;

    az(q qVar, IBaseResponseCallback iBaseResponseCallback) {
        this.f18177a = new WeakReference(qVar);
        this.f18178b = iBaseResponseCallback;
    }

    public void run() {
        q qVar = (q) this.f18177a.get();
        if (qVar != null) {
            q.a(qVar, this.f18178b);
        }
    }
}
