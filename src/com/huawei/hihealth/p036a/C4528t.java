package com.huawei.hihealth.p036a;

import com.huawei.hihealth.HiAccountInfo;
import com.huawei.hihealth.data.p312b.C3961b;
import com.huawei.p190v.C2538c;

/* compiled from: HiHealthNativeAPI */
class C4528t implements Runnable {
    final /* synthetic */ HiAccountInfo f16743a;
    final /* synthetic */ C3961b f16744b;
    final /* synthetic */ C4509c f16745c;

    C4528t(C4509c c4509c, HiAccountInfo hiAccountInfo, C3961b c3961b) {
        this.f16745c = c4509c;
        this.f16743a = hiAccountInfo;
        this.f16744b = c3961b;
    }

    public void run() {
        this.f16745c.m21598d();
        try {
            C2538c.c("HiH_HiHealthNativeAPI", new Object[]{"hiLogin() start"});
            this.f16745c.f16699b.mo4505a(this.f16743a, new C4529u(this));
        } catch (Exception e) {
            C2538c.e("HiH_HiHealthNativeAPI", new Object[]{"hiLogin e = ", e.getMessage()});
            if (this.f16744b != null) {
                this.f16744b.mo4332b(1, e.getMessage());
            }
        }
    }
}
