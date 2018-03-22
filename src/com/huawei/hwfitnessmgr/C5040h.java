package com.huawei.hwfitnessmgr;

import com.huawei.hihealth.data.p312b.C3951c;
import com.huawei.p190v.C2538c;

/* compiled from: FitnessMgrStorage */
class C5040h implements C3951c {
    final /* synthetic */ C5039g f18250a;

    C5040h(C5039g c5039g) {
        this.f18250a = c5039g;
    }

    public void onResult(int i, Object obj) {
        C2538c.a("05", 1, "Fitness_MgrStorage", new Object[]{"saveTodayTotaltoHiHealth onResult type=", Integer.valueOf(i), " obj=", obj});
    }
}
