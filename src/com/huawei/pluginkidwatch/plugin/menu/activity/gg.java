package com.huawei.pluginkidwatch.plugin.menu.activity;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;

/* compiled from: SosContactSortActivity */
class gg implements C1378e {
    final /* synthetic */ SosContactSortActivity f6150a;

    gg(SosContactSortActivity sosContactSortActivity) {
        this.f6150a = sosContactSortActivity;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        C1506g.m6979b();
        if (baseEntityModel == null || baseEntityModel.retCode != 0) {
            C2538c.m12674b("SosContactSortActivity", "==ww== 排序失败");
            C1497q.m6942a(this.f6150a, "isSort", Boolean.valueOf(false));
            C1483c.m6832c(this.f6150a, "排序失败");
            return;
        }
        C2538c.m12674b("SosContactSortActivity", "==ww== 排序成功");
        C1497q.m6942a(this.f6150a, "isSort", Boolean.valueOf(true));
        this.f6150a.finish();
        C1483c.m6832c(this.f6150a, "排序成功");
    }
}
