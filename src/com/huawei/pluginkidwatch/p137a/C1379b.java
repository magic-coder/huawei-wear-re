package com.huawei.pluginkidwatch.p137a;

import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.BindDeviceInfosIOEntityModel;

/* compiled from: KidWatchUtil */
class C1379b implements C1378e {
    final /* synthetic */ String f2970a;
    final /* synthetic */ C1377a f2971b;

    C1379b(C1377a c1377a, String str) {
        this.f2971b = c1377a;
        this.f2970a = str;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (baseEntityModel != null && baseEntityModel.retCode == 0) {
            this.f2971b.m6169a((BindDeviceInfosIOEntityModel) baseEntityModel, this.f2970a);
        }
    }
}
