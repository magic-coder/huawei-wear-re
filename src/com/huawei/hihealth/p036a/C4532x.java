package com.huawei.hihealth.p036a;

import com.huawei.hihealth.data.p312b.C3961b;
import com.huawei.p190v.C2538c;

import java.util.List;

/* compiled from: HiHealthNativeAPI */
class C4532x implements Runnable {
    final /* synthetic */ int f16750a;
    final /* synthetic */ List f16751b;
    final /* synthetic */ C3961b f16752c;
    final /* synthetic */ C4509c f16753d;

    C4532x(C4509c c4509c, int i, List list, C3961b c3961b) {
        this.f16753d = c4509c;
        this.f16750a = i;
        this.f16751b = list;
        this.f16752c = c3961b;
    }

    public void run() {
        this.f16753d.m21598d();
        try {
            this.f16753d.f16699b.mo4504a(this.f16750a, this.f16751b, new C4533y(this));
        } catch (Exception e) {
            C2538c.e("HiH_HiHealthNativeAPI", new Object[]{"setGoalInfo e = ", e.getMessage()});
            if (this.f16752c != null) {
                this.f16752c.mo4332b(1, e.getMessage());
            }
        }
    }
}
