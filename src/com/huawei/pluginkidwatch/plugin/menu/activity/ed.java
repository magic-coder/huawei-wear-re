package com.huawei.pluginkidwatch.plugin.menu.activity;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.GetDeviceModel;

/* compiled from: GeneralSettingsActivity */
class ed implements C1378e {
    final /* synthetic */ GeneralSettingsActivity f6070a;

    ed(GeneralSettingsActivity generalSettingsActivity) {
        this.f6070a = generalSettingsActivity;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        C2538c.m12674b("KIDWATCH_GeneralSettingsActivity", "===============onResponse");
        GetDeviceModel getDeviceModel = (GetDeviceModel) baseEntityModel;
        if (baseEntityModel == null || baseEntityModel.retCode != 0) {
            C2538c.m12674b("KIDWATCH_GeneralSettingsActivity", "====www======response = null");
            this.f6070a.f5756y = "";
            return;
        }
        this.f6070a.f5756y = getDeviceModel.sn;
    }
}
