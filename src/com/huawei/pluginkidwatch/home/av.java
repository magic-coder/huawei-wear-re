package com.huawei.pluginkidwatch.home;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.GetWatchSettingModel;
import com.huawei.pluginkidwatch.common.entity.model.PositioningStrategy;
import java.util.Map;

/* compiled from: HomeActivity */
class av implements C1378e {
    final /* synthetic */ HomeActivity f4189a;

    av(HomeActivity homeActivity) {
        this.f4189a = homeActivity;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        C2538c.m12677c("KIDWATCH_HomeActivity", "getWatchSetting POSITONINGSTRATEGY onResponse ......");
        if (baseEntityModel == null || baseEntityModel.retCode != 0) {
            C2538c.m12677c("KIDWATCH_HomeActivity", "getWatchSetting POSITONINGSTRATEGY onResponse failed!");
            C1462f.m6715a(1);
            return;
        }
        C2538c.m12677c("KIDWATCH_HomeActivity", "getWatchSetting POSITONINGSTRATEGY onResponse sucess!");
        Map map = ((GetWatchSettingModel) baseEntityModel).watchSettingMap;
        PositioningStrategy positioningStrategy = null;
        if (map != null) {
            Object obj = map.get("PositioningStrategy");
            if (obj == null) {
                C1462f.m6715a(1);
                return;
            }
            String str = "";
            try {
                str = this.f4189a.aN.toJson(obj);
            } catch (Exception e) {
                C2538c.m12677c("KIDWATCH_HomeActivity", "getFrequencyModeWatchSetting Exception e1 = " + e.getMessage());
            }
            C2538c.m12677c("KIDWATCH_HomeActivity", "getFrequencyModeWatchSetting ============object.toString():" + obj.toString());
            positioningStrategy = (PositioningStrategy) this.f4189a.aN.fromJson(str, PositioningStrategy.class);
        }
        if (positioningStrategy == null) {
            C2538c.m12677c("KIDWATCH_HomeActivity", "getFrequencyModeWatchSetting positioningStrategy is null PositioningStrategy.KEY_LOCATION_FREQUENCY_MODE");
            C1462f.m6715a(1);
            return;
        }
        C2538c.m12677c("KIDWATCH_HomeActivity", "getFrequencyModeWatchSetting positioningMode = " + positioningStrategy.getPositioningMode());
        C1462f.m6715a(positioningStrategy.getPositioningMode());
    }
}
