package com.huawei.pluginkidwatch.plugin.menu.activity;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.GetWatchSettingModel;
import com.huawei.pluginkidwatch.common.entity.model.PositioningStrategy;
import com.huawei.pluginkidwatch.common.lib.utils.C1490j;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;
import java.util.Map;

/* compiled from: SettingLocationActivity */
class gc implements C1378e {
    final /* synthetic */ SettingLocationActivity f6146a;

    gc(SettingLocationActivity settingLocationActivity) {
        this.f6146a = settingLocationActivity;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        this.f6146a.f5864w.setVisibility(8);
        this.f6146a.f5864w.m7206a(false);
        if (baseEntityModel == null || baseEntityModel.retCode != 0) {
            C1506g.m6979b();
            this.f6146a.m9506a(false);
            C2538c.m12674b("SettingLocationActivity", "==ww==  getWatchSetting failed");
            return;
        }
        C2538c.m12674b("SettingLocationActivity", "==ww==  getWatchSetting success");
        Map map = ((GetWatchSettingModel) baseEntityModel).watchSettingMap;
        PositioningStrategy positioningStrategy = null;
        if (map != null) {
            Object obj = map.get("PositioningStrategy");
            if (obj == null) {
                C2538c.m12674b("SettingLocationActivity", "==ww==  object is null");
                this.f6146a.f5862u = 1;
                this.f6146a.m9503a(this.f6146a.f5862u);
                this.f6146a.m9523k();
                this.f6146a.m9506a(true);
                C1506g.m6979b();
                return;
            }
            String str = "";
            try {
                str = this.f6146a.f5863v.toJson(obj);
            } catch (Exception e) {
                C2538c.m12680e("SettingLocationActivity", "Exception e1 = " + e.getMessage());
            }
            C2538c.m12674b("SettingLocationActivity", "============object.toString():" + obj.toString());
            positioningStrategy = (PositioningStrategy) this.f6146a.f5863v.fromJson(str, PositioningStrategy.class);
        }
        if (positioningStrategy == null) {
            C2538c.m12674b("SettingLocationActivity", "==ww==  getWatchSetting success null");
            this.f6146a.f5862u = 1;
            this.f6146a.m9503a(this.f6146a.f5862u);
            this.f6146a.m9523k();
        } else if (positioningStrategy.getPositioningMode() == 0) {
            C2538c.m12674b("SettingLocationActivity", "==ww==  getWatchSetting success positioningMode 0");
            if (C1490j.m6890a("LCS_PowerSaveMode")) {
                C2538c.m12674b("SettingLocationActivity", "==ww==  getWatchSetting success positioningMode 0 support POWER_SAVE_MODE");
                this.f6146a.f5862u = 0;
            } else {
                C2538c.m12674b("SettingLocationActivity", "==ww==  getWatchSetting success positioningMode not support POWER_SAVE_MODE");
                this.f6146a.f5862u = 1;
            }
            this.f6146a.m9503a(this.f6146a.f5862u);
            this.f6146a.m9523k();
        } else if (1 == positioningStrategy.getPositioningMode()) {
            C2538c.m12674b("SettingLocationActivity", "==ww==  getWatchSetting success positioningMode 1");
            this.f6146a.f5862u = 1;
            this.f6146a.m9503a(this.f6146a.f5862u);
            this.f6146a.m9523k();
        } else {
            C2538c.m12674b("SettingLocationActivity", "==ww==  getWatchSetting success positioningMode = " + positioningStrategy.getPositioningMode());
            this.f6146a.f5862u = 2;
            this.f6146a.m9503a(this.f6146a.f5862u);
            C1462f.m6726b(positioningStrategy.getPositioningFrequencyList());
            this.f6146a.m9524l();
        }
        C1506g.m6979b();
        this.f6146a.m9506a(true);
    }
}
