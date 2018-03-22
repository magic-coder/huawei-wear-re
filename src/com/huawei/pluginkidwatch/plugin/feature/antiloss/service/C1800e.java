package com.huawei.pluginkidwatch.plugin.feature.antiloss.service;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.CommonRetIModel;

/* compiled from: KidWatchServiceInteractor */
class C1800e implements C1378e {
    final /* synthetic */ C1799d f4962a;

    C1800e(C1799d c1799d) {
        this.f4962a = c1799d;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        CommonRetIModel commonRetIModel = (CommonRetIModel) baseEntityModel;
        C2538c.m12674b("KidWatchService", "retCode = " + commonRetIModel.retCode);
    }
}
