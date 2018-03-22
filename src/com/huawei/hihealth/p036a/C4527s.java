package com.huawei.hihealth.p036a;

import com.huawei.hihealth.HiSyncOption;
import com.huawei.hihealth.data.p312b.C3961b;
import com.huawei.p190v.C2538c;

/* compiled from: HiHealthNativeAPI */
class C4527s implements Runnable {
    final /* synthetic */ HiSyncOption f16740a;
    final /* synthetic */ C3961b f16741b;
    final /* synthetic */ C4509c f16742c;

    C4527s(C4509c c4509c, HiSyncOption hiSyncOption, C3961b c3961b) {
        this.f16742c = c4509c;
        this.f16740a = hiSyncOption;
        this.f16741b = c3961b;
    }

    public void run() {
        this.f16742c.m21598d();
        try {
            this.f16742c.f16699b.mo4514a(this.f16740a, null);
        } catch (Exception e) {
            C2538c.e("HiH_HiHealthNativeAPI", new Object[]{"synCloud e = ", e.getMessage()});
            if (this.f16741b != null) {
                this.f16741b.mo4332b(1, e.getMessage());
            }
        }
    }
}
