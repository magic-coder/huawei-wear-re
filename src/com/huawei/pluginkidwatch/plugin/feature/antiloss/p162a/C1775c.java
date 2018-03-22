package com.huawei.pluginkidwatch.plugin.feature.antiloss.p162a;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;

/* compiled from: AntilossUtils */
class C1775c implements C1378e {
    final /* synthetic */ C1773a f4924a;

    C1775c(C1773a c1773a) {
        this.f4924a = c1773a;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (baseEntityModel != null && baseEntityModel.retCode == 0) {
            C2538c.m12674b("AntilossUtils", "===============requestKidWatchOpenBleAntiloss success");
        } else if (baseEntityModel != null) {
            C2538c.m12674b("AntilossUtils", "=========requestKidWatchOpenBleAntiloss failure response = " + baseEntityModel.toString());
        }
    }
}
