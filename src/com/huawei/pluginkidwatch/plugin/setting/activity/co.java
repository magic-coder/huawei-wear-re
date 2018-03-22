package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.g;

/* compiled from: SetRewardGoalActivity */
class co implements OnClickListener {
    final /* synthetic */ SetRewardGoalActivity f6669a;

    co(SetRewardGoalActivity setRewardGoalActivity) {
        this.f6669a = setRewardGoalActivity;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (g.setting_rll_reward_img_5 == id) {
            C2538c.m12674b("SetRewardGoalActivity", "========Set Goal: 5");
            this.f6669a.m10081g();
        } else if (g.setting_rll_reward_img_10 == id) {
            C2538c.m12674b("SetRewardGoalActivity", "========Set Goal: 10");
            this.f6669a.m10078f();
        } else if (g.setting_rll_reward_img_15 == id) {
            C2538c.m12674b("SetRewardGoalActivity", "========Set Goal: 15");
            this.f6669a.m10076e();
        } else {
            C2538c.m12674b("SetRewardGoalActivity", "========Set Goal: 20");
            this.f6669a.m10074d();
        }
    }
}
