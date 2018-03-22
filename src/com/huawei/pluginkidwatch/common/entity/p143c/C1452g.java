package com.huawei.pluginkidwatch.common.entity.p143c;

import android.content.Context;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;

/* compiled from: TmidUtil */
class C1452g implements C1378e {
    final /* synthetic */ Context f3336a;
    final /* synthetic */ C1450e f3337b;

    C1452g(C1450e c1450e, Context context) {
        this.f3337b = c1450e;
        this.f3336a = context;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (baseEntityModel.retCode == 0) {
            C2538c.m12674b("TmidUtil", "===uploadTMID success===");
            return;
        }
        C2538c.m12674b("TmidUtil", "===uploadTMID fail===");
        try {
            this.f3337b.f3333b = this.f3337b.f3333b - 1;
            if (this.f3337b.f3333b <= 0) {
                C2538c.m12674b("TmidUtil", "===uploadTMID return===");
                return;
            }
            wait(this.f3337b.f3332a);
            this.f3337b.m6686a(this.f3336a);
        } catch (InterruptedException e) {
            C2538c.m12674b("TmidUtil", "===uploadTMID catch===");
        }
    }
}
