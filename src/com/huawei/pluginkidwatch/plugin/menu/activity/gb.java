package com.huawei.pluginkidwatch.plugin.menu.activity;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1395k;

/* compiled from: SettingLocationActivity */
class gb implements C1378e {
    final /* synthetic */ SettingLocationActivity f6145a;

    gb(SettingLocationActivity settingLocationActivity) {
        this.f6145a = settingLocationActivity;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        this.f6145a.f5864w.setVisibility(8);
        this.f6145a.f5864w.m7206a(false);
        if (baseEntityModel == null || baseEntityModel.retCode != 0) {
            if (!C1492l.m6916b(this.f6145a.f5848g)) {
                C1483c.m6824a(this.f6145a.f5848g, C1680l.IDS_plugin_kidwatch_common_network_disable);
            }
            C2538c.m12674b("SettingLocationActivity", "==ww==  关闭智能定位模式失败");
            this.f6145a.m9503a(this.f6145a.f5862u);
            this.f6145a.m9523k();
            return;
        }
        C2538c.m12674b("SettingLocationActivity", "==ww==  关闭智能定位模式成功");
        this.f6145a.f5862u = 2;
        this.f6145a.m9503a(this.f6145a.f5862u);
        this.f6145a.m9522j();
        C1395k a = C1392h.m6269a(this.f6145a.f5848g, C1462f.m6744i(), C1462f.m6746j());
        C2538c.m12674b("SettingLocationActivity", "deviceInfo = " + a);
        if (a.f3096p != null) {
            C2538c.m12674b("SettingLocationActivity", "deviceInfo.BtMac = " + a.f3096p);
            this.f6145a.f5851j.mo2508a(a.f3096p, C1462f.m6746j());
        }
    }
}
