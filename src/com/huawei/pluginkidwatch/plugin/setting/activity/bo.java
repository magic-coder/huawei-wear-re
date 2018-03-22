package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.g;

/* compiled from: RelationSettingActivity */
class bo implements OnClickListener {
    final /* synthetic */ RelationSettingActivity f6636a;

    bo(RelationSettingActivity relationSettingActivity) {
        this.f6636a = relationSettingActivity;
    }

    public void onClick(View view) {
        if (g.btn_next == view.getId()) {
            this.f6636a.m9958d();
        } else if (g.relation_lly_mother == view.getId()) {
            this.f6636a.m9964g();
        } else if (g.relation_lly_father == view.getId()) {
            this.f6636a.m9966h();
        } else if (g.relation_lly_grandpa == view.getId()) {
            this.f6636a.m9969i();
        } else if (g.relation_lly_grandma == view.getId()) {
            this.f6636a.m9971j();
        } else if (g.relation_lly_other == view.getId()) {
            this.f6636a.m9960e();
        }
        C1497q.m6943a(this.f6636a.f6438p, "pictype", this.f6636a.f6442t);
    }
}
