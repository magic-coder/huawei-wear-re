package com.huawei.hihealth.p036a;

import com.huawei.hihealth.data.p312b.C4552f;
import com.huawei.p190v.C2538c;

import java.util.List;

/* compiled from: HiHealthNativeAPI */
class ab implements Runnable {
    final /* synthetic */ List f16693a;
    final /* synthetic */ C4552f f16694b;
    final /* synthetic */ C4509c f16695c;

    ab(C4509c c4509c, List list, C4552f c4552f) {
        this.f16695c = c4509c;
        this.f16693a = list;
        this.f16694b = c4552f;
    }

    public void run() {
        this.f16695c.m21598d();
        try {
            this.f16695c.f16699b.mo4519a(this.f16693a, new ac(this));
        } catch (Exception e) {
            C2538c.e("HiH_HiHealthNativeAPI", new Object[]{"subscribeHiHealthData e = ", e.getMessage()});
            if (this.f16694b != null) {
                this.f16694b.onResult(null, null);
            }
        }
    }
}
