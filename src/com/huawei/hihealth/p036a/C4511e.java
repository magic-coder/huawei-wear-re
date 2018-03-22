package com.huawei.hihealth.p036a;

import com.huawei.hihealth.data.p312b.C4553g;
import com.huawei.p190v.C2538c;
import java.util.List;

/* compiled from: HiHealthNativeAPI */
class C4511e implements Runnable {
    final /* synthetic */ List f16705a;
    final /* synthetic */ C4553g f16706b;
    final /* synthetic */ C4509c f16707c;

    C4511e(C4509c c4509c, List list, C4553g c4553g) {
        this.f16707c = c4509c;
        this.f16705a = list;
        this.f16706b = c4553g;
    }

    public void run() {
        this.f16707c.m21598d();
        try {
            this.f16707c.f16699b.mo4520a(this.f16705a, new C4512f(this));
        } catch (Exception e) {
            C2538c.e("HiH_HiHealthNativeAPI", new Object[]{"unSubscribeHiHealthData e = ", e.getMessage()});
            if (this.f16706b != null) {
                this.f16706b.onResult(false);
            }
        }
    }
}
