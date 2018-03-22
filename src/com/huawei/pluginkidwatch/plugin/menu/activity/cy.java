package com.huawei.pluginkidwatch.plugin.menu.activity;

import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;

/* compiled from: EditCustomTimeActivity */
class cy implements C1378e {
    final /* synthetic */ EditCustomTimeActivity f6018a;

    cy(EditCustomTimeActivity editCustomTimeActivity) {
        this.f6018a = editCustomTimeActivity;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        this.f6018a.f5660v.setVisibility(8);
        this.f6018a.f5660v.m7206a(false);
        C1506g.m6979b();
        if (baseEntityModel != null && baseEntityModel.retCode == 0) {
            C1462f.m6727b(true);
            C1462f.m6751l(this.f6018a.f5653o);
            this.f6018a.finish();
        }
    }
}
