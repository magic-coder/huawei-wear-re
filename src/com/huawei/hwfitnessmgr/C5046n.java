package com.huawei.hwfitnessmgr;

import com.huawei.hihealth.data.p312b.C3951c;
import com.huawei.p190v.C2538c;

/* compiled from: FitnessMgrStorage */
class C5046n implements C3951c {
    final /* synthetic */ C5039g f18257a;

    C5046n(C5039g c5039g) {
        this.f18257a = c5039g;
    }

    public void onResult(int i, Object obj) {
        C2538c.a("05", 1, "Fitness_MgrStorage", new Object[]{"insertSampPointHiHealthData onResult type=", Integer.valueOf(i), " obj=", obj});
        if (i == 0) {
            this.f18257a.f18245e.sendEmptyMessage(0);
            return;
        }
        this.f18257a.f18245e.sendEmptyMessage(1);
        C2538c.e("Fitness_MgrStorage", new Object[]{"insertSampPointHiHealthData not correct obj=", obj});
    }
}
