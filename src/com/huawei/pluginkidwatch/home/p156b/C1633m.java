package com.huawei.pluginkidwatch.home.p156b;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.CommonRetIModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1395k;

/* compiled from: CheckNewVersionUtils */
class C1633m implements C1378e {
    final /* synthetic */ C1624d f4239a;

    C1633m(C1624d c1624d) {
        this.f4239a = c1624d;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (baseEntityModel == null || baseEntityModel.retCode != 0) {
            C1483c.m6824a(this.f4239a.f4215n, C1680l.IDS_plugin_kidwatch_menu_update_send_fail);
            return;
        }
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "===============sendUpdateCommand:retCode", baseEntityModel.retCode + "");
        CommonRetIModel commonRetIModel = (CommonRetIModel) baseEntityModel;
        this.f4239a.mo2557a(true, C1680l.IDS_plugin_kidwatch_menu_update_state1, null, this.f4239a.m7745h());
        this.f4239a.m7680a(0, true, this.f4239a.f4208e, commonRetIModel.data);
        C1483c.m6824a(this.f4239a.f4215n, C1680l.IDS_plugin_kidwatch_menu_update_send_success);
        C1395k a = C1392h.m6269a(this.f4239a.f4215n, C1462f.m6744i(), C1462f.m6746j());
        if (!(a == null || a.f3096p == null)) {
            this.f4239a.f4216o.mo2508a(a.f3096p, C1462f.m6746j());
            C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "=============调用立即刷新");
        }
        this.f4239a.f4220u = new C1636p(this.f4239a, C1624d.f4203t, C1624d.f4202s);
        this.f4239a.f4219r.post(this.f4239a.f4220u);
    }
}
