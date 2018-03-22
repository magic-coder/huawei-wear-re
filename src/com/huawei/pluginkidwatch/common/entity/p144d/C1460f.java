package com.huawei.pluginkidwatch.common.entity.p144d;

import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;

/* compiled from: RestfulService */
class C1460f implements Runnable {
    final /* synthetic */ C1378e f3360a;
    final /* synthetic */ BaseEntityModel f3361b;
    final /* synthetic */ C1457c f3362c;

    C1460f(C1457c c1457c, C1378e c1378e, BaseEntityModel baseEntityModel) {
        this.f3362c = c1457c;
        this.f3360a = c1378e;
        this.f3361b = baseEntityModel;
    }

    public void run() {
        if (this.f3360a != null) {
            this.f3360a.mo2465a(this.f3361b);
        }
    }
}
