package com.huawei.hwfitnessmgr;

import com.huawei.hihealth.data.p312b.C3951c;
import com.huawei.p190v.C2538c;

/* compiled from: FitnessDataMigration */
class C5013d implements C3951c {
    final /* synthetic */ C5011b f18190a;

    C5013d(C5011b c5011b) {
        this.f18190a = c5011b;
    }

    public void onResult(int i, Object obj) {
        C2538c.c("FitnessDataMigration", new Object[]{"saveDataToHiHealth onResult  type=", Integer.valueOf(i), " obj=", obj});
        this.f18190a.f18187i.release();
        C2538c.c("FitnessDataMigration", new Object[]{"mSemaphore release"});
    }
}
