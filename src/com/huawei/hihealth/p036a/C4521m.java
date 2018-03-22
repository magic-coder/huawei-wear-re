package com.huawei.hihealth.p036a;

import com.huawei.hihealth.HiDeviceInfo;
import com.huawei.hihealth.data.p312b.C4551e;
import com.huawei.p190v.C2538c;
import java.util.List;

/* compiled from: HiHealthNativeAPI */
class C4521m implements Runnable {
    final /* synthetic */ HiDeviceInfo f16728a;
    final /* synthetic */ List f16729b;
    final /* synthetic */ C4551e f16730c;
    final /* synthetic */ C4509c f16731d;

    C4521m(C4509c c4509c, HiDeviceInfo hiDeviceInfo, List list, C4551e c4551e) {
        this.f16731d = c4509c;
        this.f16728a = hiDeviceInfo;
        this.f16729b = list;
        this.f16730c = c4551e;
    }

    public void run() {
        this.f16731d.m21598d();
        try {
            this.f16731d.f16699b.mo4513a(this.f16728a, this.f16729b, new C4522n(this));
        } catch (Exception e) {
            C2538c.e("HiH_HiHealthNativeAPI", new Object[]{"registerDataClient e = ", e.getMessage()});
            if (this.f16730c != null) {
                this.f16730c.mo4609a(null);
            }
        }
    }
}
