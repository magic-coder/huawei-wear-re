package com.huawei.pluginkidwatch.home.p156b;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.WatchStatusIOModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1491k;

/* compiled from: CheckNewVersionUtils */
class C1635o implements C1378e {
    final /* synthetic */ boolean f4242a;
    final /* synthetic */ C1624d f4243b;

    C1635o(C1624d c1624d, boolean z) {
        this.f4243b = c1624d;
        this.f4242a = z;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (baseEntityModel == null || baseEntityModel.retCode != 0) {
            C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==ww== updateSuccessGetWatchStatus error");
            return;
        }
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==ww==updateSuccessGetWatchStatus " + baseEntityModel.retCode);
        C1491k.m6897a(this.f4243b.f4215n, C1462f.m6746j() + "beforeVersion", ((WatchStatusIOModel) baseEntityModel).watchStatus.version);
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "===============升级成功");
        this.f4243b.m7729t();
        if (!this.f4242a) {
            C1483c.m6824a(this.f4243b.f4215n, C1680l.IDS_plugin_kidwatch_menu_update_state5);
        }
        this.f4243b.m7743f();
    }
}
