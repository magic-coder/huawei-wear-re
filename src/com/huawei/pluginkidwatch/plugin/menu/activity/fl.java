package com.huawei.pluginkidwatch.plugin.menu.activity;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.AlarmItem;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1895l;

/* compiled from: PeroidActivity */
class fl implements C1378e {
    final /* synthetic */ int f6122a;
    final /* synthetic */ int f6123b;
    final /* synthetic */ PeroidActivity f6124c;

    fl(PeroidActivity peroidActivity, int i, int i2) {
        this.f6124c = peroidActivity;
        this.f6122a = i;
        this.f6123b = i2;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        C2538c.m12674b("PeroidActivity", "========== entity.setWatchSetting-->onResponse");
        if (baseEntityModel == null || baseEntityModel.retCode != 0) {
            C2538c.m12680e("PeroidActivity", "========== set watch alarm list error");
            AlarmItem alarmItem = (AlarmItem) this.f6124c.f5801g.get(this.f6122a);
            if (C1492l.m6920d("1") == this.f6123b) {
                C2538c.m12674b("PeroidActivity", "==========turn on");
                alarmItem.isActive = "1";
            } else {
                C2538c.m12674b("PeroidActivity", "==========turn off");
                alarmItem.isActive = "0";
            }
            this.f6124c.f5801g.set(this.f6122a, alarmItem);
            this.f6124c.m9481a(this.f6124c.f5801g);
            C1483c.m6832c(this.f6124c.f5800f, this.f6124c.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_set_fail));
            return;
        }
        C2538c.m12674b("PeroidActivity", "========== set watch alarm list Success");
        C1895l.m9663a(this.f6124c.f5800f, this.f6124c.f5799e);
    }
}
