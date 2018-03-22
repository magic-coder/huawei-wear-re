package com.huawei.pluginkidwatch.home;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;

/* compiled from: HomeActivity */
class at implements C1378e {
    final /* synthetic */ HomeActivity f4187a;

    at(HomeActivity homeActivity) {
        this.f4187a = homeActivity;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==========sendDevcieSettingsInfoToCloud  entity.setWatchSetting-->onResponse");
        if (baseEntityModel == null || baseEntityModel.retCode != 0) {
            C2538c.m12680e("KIDWATCH_HomeActivity", "==========sendDevcieSettingsInfoToCloud send fail!!!");
            return;
        }
        C2538c.m12674b("KIDWATCH_HomeActivity", "==========sendDevcieSettingsInfoToCloud send Success");
    }
}
