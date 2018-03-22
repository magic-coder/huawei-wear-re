package com.huawei.pluginkidwatch.plugin.feature.newsport;

import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.HealthDataIOEntityModel;

/* compiled from: AsyncGetCloudNewData */
class C1807b implements C1378e {
    final /* synthetic */ String f4996a;
    final /* synthetic */ String f4997b;
    final /* synthetic */ C1806a f4998c;

    C1807b(C1806a c1806a, String str, String str2) {
        this.f4998c = c1806a;
        this.f4996a = str;
        this.f4997b = str2;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        HealthDataIOEntityModel healthDataIOEntityModel = (HealthDataIOEntityModel) baseEntityModel;
        if (healthDataIOEntityModel.retCode == 0) {
            healthDataIOEntityModel.deviceCode = this.f4996a;
            this.f4998c.m8639a(this.f4998c.m8640b(healthDataIOEntityModel.healthData, healthDataIOEntityModel.deviceCode), this.f4997b);
            this.f4998c.publishProgress(new Object[0]);
        }
    }
}
