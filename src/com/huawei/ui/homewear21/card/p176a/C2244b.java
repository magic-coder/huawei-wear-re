package com.huawei.ui.homewear21.card.p176a;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.base.b;

/* compiled from: DeviceStateInteractors */
class C2244b implements IBaseResponseCallback {
    final /* synthetic */ b f8164a;
    final /* synthetic */ C2243a f8165b;

    C2244b(C2243a c2243a, b bVar) {
        this.f8165b = c2243a;
        this.f8164a = bVar;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c(C2243a.f8159a, "refreshAllCardsData syncFitnessDetailData onResponse err_code = " + i);
        if (this.f8164a != null) {
            this.f8164a.a(i, obj);
        }
    }
}
