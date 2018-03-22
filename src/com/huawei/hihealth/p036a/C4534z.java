package com.huawei.hihealth.p036a;

import com.huawei.hihealth.data.p312b.C3961b;
import com.huawei.p190v.C2538c;

/* compiled from: HiHealthNativeAPI */
class C4534z implements Runnable {
    final /* synthetic */ int f16755a;
    final /* synthetic */ int f16756b;
    final /* synthetic */ C3961b f16757c;
    final /* synthetic */ C4509c f16758d;

    C4534z(C4509c c4509c, int i, int i2, C3961b c3961b) {
        this.f16758d = c4509c;
        this.f16755a = i;
        this.f16756b = i2;
        this.f16757c = c3961b;
    }

    public void run() {
        this.f16758d.m21598d();
        try {
            this.f16758d.f16699b.mo4498a(this.f16755a, this.f16756b, new aa(this));
        } catch (Exception e) {
            C2538c.e("HiH_HiHealthNativeAPI", new Object[]{"fetchGoalInfo e = ", e.getMessage()});
            if (this.f16757c != null) {
                this.f16757c.mo4332b(1, e.getMessage());
            }
        }
    }
}
