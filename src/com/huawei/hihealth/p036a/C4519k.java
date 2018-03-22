package com.huawei.hihealth.p036a;

import android.util.SparseArray;
import com.huawei.hihealth.HiDataReadOption;
import com.huawei.hihealth.data.p312b.C4550d;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;

/* compiled from: HiHealthNativeAPI */
class C4519k implements Runnable {
    final /* synthetic */ HiDataReadOption f16721a;
    final /* synthetic */ C4550d f16722b;
    final /* synthetic */ C4509c f16723c;

    C4519k(C4509c c4509c, HiDataReadOption hiDataReadOption, C4550d c4550d) {
        this.f16723c = c4509c;
        this.f16721a = hiDataReadOption;
        this.f16722b = c4550d;
    }

    public void run() {
        this.f16723c.m21598d();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            SparseArray sparseArray = new SparseArray();
            this.f16723c.f16699b.mo4510a(this.f16721a, new C4520l(this, new ArrayList(), sparseArray, currentTimeMillis));
        } catch (Exception e) {
            C2538c.e("HiH_HiHealthNativeAPI", new Object[]{"readHiHealthData e = ", e.getMessage()});
            if (this.f16722b != null) {
                this.f16722b.mo4610a(null, 1, 0);
            }
        }
    }
}
