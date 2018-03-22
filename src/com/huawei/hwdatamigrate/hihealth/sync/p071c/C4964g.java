package com.huawei.hwdatamigrate.hihealth.sync.p071c;

import android.util.SparseArray;
import com.huawei.hwdatamigrate.hihealth.sync.a.h;
import com.huawei.hwdatamigrate.hihealth.sync.c.f;
import com.huawei.p190v.C2538c;

import java.lang.ref.WeakReference;

/* compiled from: HiSyncDimenSportStat */
class C4964g implements Runnable {
    SparseArray<Integer> f18051a;
    private WeakReference<f> f18052b;

    public C4964g(f fVar, SparseArray<Integer> sparseArray) {
        this.f18051a = sparseArray;
        this.f18052b = new WeakReference(fVar);
    }

    public void run() {
        f fVar = (f) this.f18052b.get();
        if (fVar == null) {
            C2538c.d("Debug_HiSyncDimenSportStat", new Object[]{"StatDownloadRunnable() mSyncStat = null"});
            return;
        }
        try {
            f.a(fVar, this.f18051a);
        } catch (h e) {
            C2538c.e("Debug_HiSyncDimenSportStat", new Object[]{"downloadOneStatByTime error ! e is ", e.getMessage()});
        }
    }
}
