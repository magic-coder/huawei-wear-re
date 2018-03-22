package com.huawei.hihealth.p036a;

import com.huawei.hihealth.data.p312b.C3961b;
import com.huawei.p190v.C2538c;

/* compiled from: HiHealthNativeAPI */
class C4530v implements Runnable {
    final /* synthetic */ C3961b f16747a;
    final /* synthetic */ C4509c f16748b;

    C4530v(C4509c c4509c, C3961b c3961b) {
        this.f16748b = c4509c;
        this.f16747a = c3961b;
    }

    public void run() {
        this.f16748b.m21598d();
        try {
            this.f16748b.f16699b.mo4531c(new C4531w(this));
        } catch (Exception e) {
            C2538c.e("HiH_HiHealthNativeAPI", new Object[]{"fetchAccountInfo e = ", e.getMessage()});
            if (this.f16747a != null) {
                this.f16747a.mo4332b(1, e.getMessage());
            }
        }
    }
}
