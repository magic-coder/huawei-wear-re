package com.huawei.pluginkidwatch.plugin.menu.activity;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.GetWatchSettingModel;
import java.util.Map;

/* compiled from: GeneralSettingsActivity */
class eb implements C1378e {
    final /* synthetic */ String f6067a;
    final /* synthetic */ GeneralSettingsActivity f6068b;

    eb(GeneralSettingsActivity generalSettingsActivity, String str) {
        this.f6068b = generalSettingsActivity;
        this.f6067a = str;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        C2538c.m12674b("KIDWATCH_GeneralSettingsActivity", "========== entity.getWatchSetting-->onResponse");
        if (this.f6068b.isFinishing()) {
            C2538c.m12680e("KIDWATCH_GeneralSettingsActivity", "=============GeneralSettingsActivity is  finish. so return");
        } else if (baseEntityModel == null || baseEntityModel.retCode != 0) {
            C2538c.m12680e("KIDWATCH_GeneralSettingsActivity", "========== get watch alarm list error");
            this.f6068b.runOnUiThread(new ec(this));
        } else {
            Map map = ((GetWatchSettingModel) baseEntityModel).watchSettingMap;
            if (map != null) {
                Object obj = map.get(this.f6067a);
                if (obj == null) {
                    C2538c.m12674b("KIDWATCH_GeneralSettingsActivity", "============ object is null");
                    this.f6068b.m9397b(this.f6067a, true);
                    return;
                }
                int parseFloat;
                C2538c.m12674b("KIDWATCH_GeneralSettingsActivity", "============object.toString():" + obj.toString());
                try {
                    parseFloat = (int) Float.parseFloat(obj.toString());
                } catch (NumberFormatException e) {
                    C2538c.m12674b("KIDWATCH_GeneralSettingsActivity", "getGeneralSettingInfoFromCloud parseFloat NumberFormatException " + e.getMessage());
                    parseFloat = 1;
                }
                if (1 != parseFloat) {
                    C2538c.m12674b("KIDWATCH_GeneralSettingsActivity", "============updateSettingsInfo false");
                    this.f6068b.m9397b(this.f6067a, false);
                    return;
                }
                C2538c.m12674b("KIDWATCH_GeneralSettingsActivity", "============updateSettingsInfo true");
                this.f6068b.m9397b(this.f6067a, true);
            }
        }
    }
}
