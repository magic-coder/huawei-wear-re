package com.huawei.hihealth.p036a;

import com.huawei.hihealth.HiAggregateOption;
import com.huawei.hihealth.data.p312b.C4549a;
import com.huawei.p190v.C2538c;
import java.util.ArrayList;

/* compiled from: HiHealthNativeAPI */
class C4513g implements Runnable {
    final /* synthetic */ HiAggregateOption f16709a;
    final /* synthetic */ C4549a f16710b;
    final /* synthetic */ C4509c f16711c;

    C4513g(C4509c c4509c, HiAggregateOption hiAggregateOption, C4549a c4549a) {
        this.f16711c = c4509c;
        this.f16709a = hiAggregateOption;
        this.f16710b = c4549a;
    }

    public void run() {
        this.f16711c.m21598d();
        try {
            this.f16711c.f16699b.mo4506a(this.f16709a, new C4516h(this, new ArrayList()));
        } catch (Exception e) {
            C2538c.e("HiH_HiHealthNativeAPI", new Object[]{"aggregateHiHealthData e = ", e.getMessage()});
            if (this.f16710b != null) {
                this.f16710b.mo5128a(null, 1, 0);
            }
        }
    }
}
