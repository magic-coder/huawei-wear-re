package com.huawei.pluginkidwatch.plugin.setting.activity;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;

/* compiled from: SetRewardGoalActivity */
class cq implements C1378e {
    final /* synthetic */ SetRewardGoalActivity f6671a;

    cq(SetRewardGoalActivity setRewardGoalActivity) {
        this.f6671a = setRewardGoalActivity;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (baseEntityModel == null || baseEntityModel.retCode != 0) {
            C2538c.m12674b("SetRewardGoalActivity", "==============Send failure , try once");
            this.f6671a.f6548F.setVisibility(8);
            this.f6671a.f6548F.m7206a(false);
            C1483c.m6824a(this.f6671a.f6557d, C1680l.IDS_plugin_kidwatch_common_network_disable);
            C2538c.m12674b("SetRewardGoalActivity", "==============Clear failure");
            this.f6671a.f6551I = false;
            return;
        }
        C2538c.m12674b("SetRewardGoalActivity", "==============Clear success");
        this.f6671a.m10083h();
    }
}
