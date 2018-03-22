package com.huawei.pluginkidwatch.home;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;

/* compiled from: HomeActivity */
class C1660o implements C1378e {
    final /* synthetic */ HomeActivity f4362a;

    C1660o(HomeActivity homeActivity) {
        this.f4362a = homeActivity;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (baseEntityModel == null || baseEntityModel.retCode != 0) {
            this.f4362a.m7518a(this.f4362a.f4109F, C1680l.IDS_plugin_kidwatch_main_map_start_position_failure, true);
            this.f4362a.m7631x();
            return;
        }
        C2538c.m12674b("KIDWATCH_HomeActivity", "===============Start Positioning success");
        this.f4362a.m7633y();
    }
}
