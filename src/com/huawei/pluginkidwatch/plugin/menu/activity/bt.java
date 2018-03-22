package com.huawei.pluginkidwatch.plugin.menu.activity;

import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1395k;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;

/* compiled from: ContactInfoActivity */
class bt implements C1378e {
    final /* synthetic */ String f5978a;
    final /* synthetic */ ContactInfoActivity f5979b;

    bt(ContactInfoActivity contactInfoActivity, String str) {
        this.f5979b = contactInfoActivity;
        this.f5978a = str;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        C1506g.m6979b();
        if (baseEntityModel.retCode == 0) {
            C1462f.m6736e(false);
            C1395k a = C1392h.m6269a(this.f5979b, C1462f.m6744i(), C1462f.m6746j());
            a.f3097q = this.f5978a;
            C1392h.m6297b(this.f5979b, a);
            C1497q.m6942a(this.f5979b, "diteManger", Boolean.valueOf(true));
            this.f5979b.finish();
        } else if (baseEntityModel.retCode == 13220) {
            C1483c.m6824a(this.f5979b, C1680l.IDS_plugin_kidwatch_menu_unlogin);
        } else {
            C1483c.m6824a(this.f5979b, C1680l.IDS_plugin_kidwatch_common_process_failed);
        }
    }
}
