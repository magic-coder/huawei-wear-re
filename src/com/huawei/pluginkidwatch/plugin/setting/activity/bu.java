package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;

/* compiled from: RewardActivity */
class bu implements OnClickListener {
    final /* synthetic */ RewardActivity f6646a;

    bu(RewardActivity rewardActivity) {
        this.f6646a = rewardActivity;
    }

    public void onClick(View view) {
        if (this.f6646a.f6449A == null || this.f6646a.f6499z >= this.f6646a.f6449A.getGoal()) {
            C2538c.m12674b("RewardActivity", "===========error " + this.f6646a.f6499z);
        } else if (C1492l.m6916b(this.f6646a.f6487n)) {
            this.f6646a.m10012h();
        } else {
            C2538c.m12674b("RewardActivity", "==========network is unavailable");
            if (System.currentTimeMillis() - this.f6646a.f6495v > 3000) {
                this.f6646a.f6495v = System.currentTimeMillis();
                C1483c.m6824a(this.f6646a.f6487n, C1680l.IDS_plugin_kidwatch_common_network_disable);
            }
        }
    }
}
