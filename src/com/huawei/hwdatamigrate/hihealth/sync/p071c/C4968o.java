package com.huawei.hwdatamigrate.hihealth.sync.p071c;

import android.util.SparseArray;
import com.huawei.hwdatamigrate.hihealth.sync.a.h;
import com.huawei.hwdatamigrate.hihealth.sync.c.n;
import com.huawei.p190v.C2538c;

import java.lang.ref.WeakReference;

/* compiled from: HiSyncTotalSportStat */
class C4968o implements Runnable {
    SparseArray<Integer> f18059a;
    private WeakReference<n> f18060b;

    public C4968o(n nVar, SparseArray<Integer> sparseArray) {
        this.f18059a = sparseArray;
        this.f18060b = new WeakReference(nVar);
    }

    public void run() {
        n nVar = (n) this.f18060b.get();
        if (nVar == null) {
            C2538c.d("Debug_HiSyncTotalSportStat", new Object[]{"StatDownloadRunnable() mSyncStat = null"});
            return;
        }
        try {
            n.a(nVar, this.f18059a);
        } catch (h e) {
            C2538c.e("Debug_HiSyncTotalSportStat", new Object[]{"downloadOneStatByTime error ! e is ", e.getMessage()});
        }
    }
}
