package com.huawei.hihealth.p036a;

import com.huawei.hihealth.data.p312b.C3961b;
import com.huawei.p190v.C2538c;

/* compiled from: HiHealthNativeAPI */
class C4525q implements Runnable {
    final /* synthetic */ C3961b f16737a;
    final /* synthetic */ C4509c f16738b;

    C4525q(C4509c c4509c, C3961b c3961b) {
        this.f16738b = c4509c;
        this.f16737a = c3961b;
    }

    public void run() {
        this.f16738b.m21598d();
        try {
            this.f16738b.f16699b.mo4516a(new C4526r(this));
        } catch (Exception e) {
            C2538c.e("HiH_HiHealthNativeAPI", new Object[]{"fetchUserData e = ", e.getMessage()});
            if (this.f16737a != null) {
                this.f16737a.mo4332b(1, e.getMessage());
            }
        }
    }
}
