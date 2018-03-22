package com.huawei.pluginkidwatch.home.p156b;

import android.content.Context;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.GetDeviceModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;

/* compiled from: CheckNewVersionUtils */
class C1628h implements C1378e {
    final /* synthetic */ Context f4229a;
    final /* synthetic */ boolean f4230b;
    final /* synthetic */ C1624d f4231c;

    C1628h(C1624d c1624d, Context context, boolean z) {
        this.f4231c = c1624d;
        this.f4229a = context;
        this.f4230b = z;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "===============onResponse");
        if (baseEntityModel != null && baseEntityModel.retCode == 0) {
            C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "===============retCode" + baseEntityModel.retCode);
            C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", " ==ww== GetDeviceModel = " + ((GetDeviceModel) baseEntityModel).toString());
            this.f4231c.f4211h = r7.sn;
            if (this.f4231c.f4211h != null || !"".equals(this.f4231c.f4211h)) {
                C1462f.m6752m(this.f4231c.f4211h);
                this.f4231c.f4221v = C1462f.m6765y();
                C1497q.m6943a(this.f4231c.f4215n, C1462f.m6746j() + "IMEI", C1462f.m6765y());
                C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", " ==ww== GetDevice = " + C1462f.m6765y());
                this.f4231c.m7738b(this.f4229a, this.f4230b);
            } else if (!this.f4230b) {
                this.f4231c.m7689a(this.f4231c.f4218q);
                C1483c.m6824a(this.f4231c.f4215n, C1680l.IDS_plugin_kidwatch_menu_update_getimei_fail);
            }
        } else if (!this.f4230b) {
            if (!this.f4231c.f4213j) {
                this.f4231c.m7689a(this.f4231c.f4218q);
            }
            C1483c.m6824a(this.f4231c.f4215n, C1680l.IDS_plugin_kidwatch_menu_update_getimei_fail);
        }
    }
}
