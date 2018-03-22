package com.huawei.pluginkidwatch.common.entity.p144d;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;
import com.huawei.pluginkidwatch.common.lib.p145d.C1455g;

/* compiled from: RestfulService */
class C1458d implements C1455g {
    final /* synthetic */ String f3353a;
    final /* synthetic */ String f3354b;
    final /* synthetic */ C1418a f3355c;
    final /* synthetic */ C1378e f3356d;
    final /* synthetic */ C1457c f3357e;

    C1458d(C1457c c1457c, String str, String str2, C1418a c1418a, C1378e c1378e) {
        this.f3357e = c1457c;
        this.f3353a = str;
        this.f3354b = str2;
        this.f3355c = c1418a;
        this.f3356d = c1378e;
    }

    public void mo2514a(int i, Object obj) {
        this.f3357e.f3351d.execute(new C1459e(this, obj));
    }

    public void mo2515b(int i, Object obj) {
        try {
            BaseEntityModel a = this.f3355c.mo2511a("");
            a.retCode = 13201;
            this.f3357e.m6705a(this.f3356d, a);
        } catch (Exception e) {
            C2538c.m12680e("RestfulService", "" + e.getMessage());
        }
    }
}
