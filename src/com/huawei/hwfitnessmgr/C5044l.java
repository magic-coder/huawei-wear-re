package com.huawei.hwfitnessmgr;

import com.huawei.hihealth.data.p312b.C3951c;
import com.huawei.p190v.C2538c;

/* compiled from: FitnessMgrStorage */
class C5044l implements C3951c {
    final /* synthetic */ C5043k f18255a;

    C5044l(C5043k c5043k) {
        this.f18255a = c5043k;
    }

    public void onResult(int i, Object obj) {
        C2538c.a("05", 1, "Fitness_MgrStorage", new Object[]{"appendToExistData onResult type=", Integer.valueOf(i), " obj=", obj});
    }
}
