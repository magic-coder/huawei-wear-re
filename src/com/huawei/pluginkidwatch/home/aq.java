package com.huawei.pluginkidwatch.home;

import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.GetWatchSettingModel;
import com.huawei.pluginkidwatch.common.entity.model.RewardGoal;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;
import java.util.Map;

/* compiled from: HomeActivity */
class aq implements C1378e {
    final /* synthetic */ boolean f4183a;
    final /* synthetic */ HomeActivity f4184b;

    aq(HomeActivity homeActivity, boolean z) {
        this.f4184b = homeActivity;
        this.f4183a = z;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "========== entity.getWatchSetting-->onResponse");
        if (this.f4184b.isFinishing()) {
            C2538c.m12680e("KIDWATCH_HomeActivity", "=============RewardActivity is  finish. so return");
            return;
        }
        if (!(this.f4184b.f4109F == null || this.f4184b.isFinishing())) {
            C1506g.m6979b();
        }
        if (baseEntityModel == null || baseEntityModel.retCode != 0) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "========== getRewardInfo failure");
            if (this.f4183a) {
                C1483c.m6824a(this.f4184b.f4109F, C1680l.IDS_plugin_kidwatch_common_network_not_stable);
                return;
            }
            return;
        }
        try {
            Map map = ((GetWatchSettingModel) baseEntityModel).watchSettingMap;
            if (map != null) {
                this.f4184b.aY = (RewardGoal) this.f4184b.aN.fromJson(this.f4184b.aN.toJson(map.get("rewardGoal")), RewardGoal.class);
            }
        } catch (JsonSyntaxException e) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "==========抓住崩溃：解析从云传来的小红花总数和奖励时发生崩溃");
            this.f4184b.aY = null;
        }
        if (this.f4183a) {
            this.f4184b.am();
        }
    }
}
