package com.huawei.pluginkidwatch.plugin.setting.activity;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;

/* compiled from: RewardActivity */
class bv implements C1378e {
    final /* synthetic */ RewardActivity f6647a;

    bv(RewardActivity rewardActivity) {
        this.f6647a = rewardActivity;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        this.f6647a.f6485l.setEnabled(true);
        this.f6647a.aj.setVisibility(8);
        this.f6647a.aj.m7206a(false);
        if (baseEntityModel != null && baseEntityModel.retCode == 0) {
            C2538c.m12674b("RewardActivity", "========== addOneReward Success");
            this.f6647a.f6499z = this.f6647a.f6499z + 1;
            this.f6647a.f6482i.setText(this.f6647a.f6499z + "");
            this.f6647a.m9991a(this.f6647a.f6499z, this.f6647a.f6449A.getGoal());
            if (!this.f6647a.isFinishing()) {
                C2538c.m12674b("RewardActivity", "==========fresh now");
                this.f6647a.m10016j();
            }
        } else if (baseEntityModel == null || 13218 != baseEntityModel.retCode) {
            C2538c.m12680e("RewardActivity", "========== addOneReward failure");
        } else {
            C2538c.m12680e("RewardActivity", "========== Already reached goal,please reset it first ");
            this.f6647a.f6499z = this.f6647a.f6449A.getGoal();
            this.f6647a.f6482i.setText(this.f6647a.f6499z + "");
            this.f6647a.m9991a(this.f6647a.f6499z, this.f6647a.f6449A.getGoal());
            if (!this.f6647a.isFinishing()) {
                C2538c.m12674b("RewardActivity", "==========fresh now");
                this.f6647a.m10016j();
            }
        }
    }
}
