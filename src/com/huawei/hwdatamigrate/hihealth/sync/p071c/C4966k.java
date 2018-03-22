package com.huawei.hwdatamigrate.hihealth.sync.p071c;

import android.util.SparseArray;
import com.huawei.hwdatamigrate.hihealth.sync.a.h;
import com.huawei.hwdatamigrate.hihealth.sync.c.i;
import com.huawei.p190v.C2538c;

import java.lang.ref.WeakReference;

/* compiled from: HiSyncSleepStat */
class C4966k implements Runnable {
    SparseArray<Integer> f18053a;
    private WeakReference<i> f18054b;

    private C4966k(i iVar, SparseArray<Integer> sparseArray) {
        this.f18053a = sparseArray;
        this.f18054b = new WeakReference(iVar);
    }

    public void run() {
        i iVar = (i) this.f18054b.get();
        if (iVar == null) {
            C2538c.d("Debug_HiSyncSleepStat", new Object[]{"StatDownloadRunnable() mSyncStat = null"});
            return;
        }
        try {
            i.a(iVar, this.f18053a);
        } catch (h e) {
            C2538c.e("Debug_HiSyncSleepStat", new Object[]{"downloadSleepStatByTime error ! e is ", e.getMessage()});
        }
    }
}
