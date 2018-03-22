package com.huawei.hwfitnessmgr;

import android.os.RemoteException;
import com.huawei.hwcommonservice.model.d;
import com.huawei.p190v.C2538c;
import java.lang.ref.WeakReference;

/* compiled from: HWFitnessMgr */
class ay implements Runnable {
    WeakReference<q> f18172a = new WeakReference(q.q());
    d f18173b;
    long f18174c = -1;
    long f18175d = -1;

    public ay(long j, long j2, d dVar) {
        this.f18173b = dVar;
        this.f18174c = j;
        this.f18175d = j2;
    }

    public void run() {
        C2538c.a("05", 1, "HWFitnessMgr", new Object[]{"syncFitnessDetailDataRunableThirdPart"});
        q qVar = (q) this.f18172a.get();
        if (qVar != null) {
            try {
                q.a(qVar, this.f18174c, this.f18175d, this.f18173b);
            } catch (RemoteException e) {
                C2538c.c("HWFitnessMgr", new Object[]{"saveFitnessDate.syncFitnessDetailDataRunableThirdPart RemoteException e=" + e.getMessage()});
            }
        }
    }
}
