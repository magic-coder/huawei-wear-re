package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.content.Intent;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;

/* compiled from: SetRewardGoalActivity */
class cp implements C1378e {
    final /* synthetic */ SetRewardGoalActivity f6670a;

    cp(SetRewardGoalActivity setRewardGoalActivity) {
        this.f6670a = setRewardGoalActivity;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        this.f6670a.f6551I = false;
        C2538c.m12674b("SetRewardGoalActivity", "========== entity.setWatchSetting-->onResponse");
        if (baseEntityModel != null && baseEntityModel.retCode == 0) {
            C2538c.m12674b("SetRewardGoalActivity", "========== set watch reward goal Success");
            this.f6670a.m10084i();
            this.f6670a.m10088k();
            Intent intent = new Intent();
            intent.putExtra("new_goal", this.f6670a.f6562i);
            intent.putExtra("new_hope", this.f6670a.f6559f.getText().toString().trim());
            if (this.f6670a.f6545C) {
                intent.setClass(this.f6670a.f6557d, RewardActivity.class);
                this.f6670a.f6557d.startActivity(intent);
            } else if (this.f6670a.f6544B) {
                this.f6670a.f6544B = false;
                this.f6670a.f6543A = 0;
            } else {
                intent.putExtra("is_modify_goal", this.f6670a.f6547E);
                this.f6670a.setResult(-1, intent);
            }
            this.f6670a.f6548F.setVisibility(8);
            this.f6670a.f6548F.m7206a(false);
            this.f6670a.finish();
        } else if (baseEntityModel == null || baseEntityModel.retCode != 13218) {
            C2538c.m12680e("SetRewardGoalActivity", "========== set watch reward goal error");
            this.f6670a.f6548F.setVisibility(8);
            this.f6670a.f6548F.m7206a(false);
            this.f6670a.f6558e.setClickable(true);
            if (!this.f6670a.isFinishing()) {
                C2538c.m12680e("SetRewardGoalActivity", "========== 显示设置失败");
                C1483c.m6832c(this.f6670a.f6557d, this.f6670a.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_set_fail));
            }
        } else {
            C2538c.m12674b("SetRewardGoalActivity", "========== 需要先清空云数据，然后设置目标");
            this.f6670a.m10087j();
        }
    }
}
