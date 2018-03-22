package com.huawei.pluginkidwatch.plugin.menu.activity;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1395k;

/* compiled from: EditPhoneNumActivity */
class dg implements C1378e {
    final /* synthetic */ EditPhoneNumActivity f6030a;

    dg(EditPhoneNumActivity editPhoneNumActivity) {
        this.f6030a = editPhoneNumActivity;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (baseEntityModel == null || baseEntityModel.retCode != 0) {
            this.f6030a.f5665f.setClickable(true);
            C2538c.m12680e(this.f6030a.f5661b, "=====设置电话失败");
            this.f6030a.f5663d.setText("");
            C1483c.m6824a(this.f6030a.f5671l, C1680l.IDS_plugin_kidwatch_settings_verification_code_fail);
            this.f6030a.m9299a(-1);
            return;
        }
        C2538c.m12674b(this.f6030a.f5661b, "=====设置电话ok====");
        C2538c.m12674b(this.f6030a.f5661b, "==ww==isFromInfo =" + this.f6030a.f5673n);
        C1497q.m6943a(this.f6030a, "menuinfophone", this.f6030a.f5672m);
        C1395k a = C1392h.m6269a(this.f6030a, C1462f.m6744i(), C1462f.m6746j());
        if (!(a == null || a.f3096p == null)) {
            C2538c.m12674b(this.f6030a.f5661b, "deviceInfo = " + a.f3096p);
            this.f6030a.f5669j.mo2508a(a.f3096p, C1462f.m6746j());
        }
        this.f6030a.finish();
    }
}
