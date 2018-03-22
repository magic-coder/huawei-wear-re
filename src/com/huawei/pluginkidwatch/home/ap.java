package com.huawei.pluginkidwatch.home;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.GetRewardInfoRetModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;

/* compiled from: HomeActivity */
class ap implements C1378e {
    final /* synthetic */ boolean f4181a;
    final /* synthetic */ HomeActivity f4182b;

    ap(HomeActivity homeActivity, boolean z) {
        this.f4182b = homeActivity;
        this.f4181a = z;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (!this.f4182b.isFinishing()) {
            if (baseEntityModel == null || baseEntityModel.retCode != 0) {
                C2538c.m12674b("KIDWATCH_HomeActivity", "========== getRewardInfo failure");
                if (this.f4181a) {
                    if (!(this.f4182b.f4109F == null || this.f4182b.isFinishing())) {
                        C1506g.m6979b();
                    }
                    if (C1492l.m6916b(this.f4182b.f4109F)) {
                        this.f4182b.m7518a(this.f4182b.f4109F, C1680l.IDS_plugin_kidwatch_feature_reward_get_failure, true);
                        return;
                    } else {
                        this.f4182b.m7518a(this.f4182b.f4109F, C1680l.IDS_plugin_kidwatch_common_network_not_stable, true);
                        return;
                    }
                }
                return;
            }
            C2538c.m12674b("KIDWATCH_HomeActivity", "========== getRewardInfo Success");
            this.f4182b.aZ = C1492l.m6920d(((GetRewardInfoRetModel) baseEntityModel).rewardInfo);
            if (this.f4181a) {
                this.f4182b.m7603j(this.f4181a);
            }
        }
    }
}
