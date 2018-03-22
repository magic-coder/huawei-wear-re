package com.huawei.pluginkidwatch.common.entity.p139a;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;

/* compiled from: KidApi */
class C1415d implements C1378e {
    final /* synthetic */ C1414c f3230a;

    C1415d(C1414c c1414c) {
        this.f3230a = c1414c;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (baseEntityModel != null && baseEntityModel.retCode == 0) {
            C2538c.m12674b("getSOSLocation", "======Start Positioning success");
        }
    }
}
