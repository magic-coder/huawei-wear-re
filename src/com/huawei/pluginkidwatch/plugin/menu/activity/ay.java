package com.huawei.pluginkidwatch.plugin.menu.activity;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.AlarmItem;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1895l;

/* compiled from: AlarmActivity */
class ay implements C1378e {
    final /* synthetic */ int f5949a;
    final /* synthetic */ int f5950b;
    final /* synthetic */ AlarmActivity f5951c;

    ay(AlarmActivity alarmActivity, int i, int i2) {
        this.f5951c = alarmActivity;
        this.f5949a = i;
        this.f5950b = i2;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        C2538c.m12674b("AlarmActivity", "========== entity.setWatchSetting-->onResponse");
        if (baseEntityModel == null || baseEntityModel.retCode != 0) {
            C2538c.m12680e("AlarmActivity", "========== set watch alarm list error");
            AlarmItem alarmItem = (AlarmItem) this.f5951c.f5516g.get(this.f5949a);
            if (C1492l.m6919c("1") && C1492l.m6920d("1") == this.f5950b) {
                C2538c.m12674b("AlarmActivity", "==========turn on");
                alarmItem.isActive = "1";
            } else {
                C2538c.m12674b("AlarmActivity", "==========turn off");
                alarmItem.isActive = "0";
            }
            this.f5951c.f5516g.set(this.f5949a, alarmItem);
            this.f5951c.m9121a(this.f5951c.f5516g);
            C1483c.m6832c(this.f5951c.f5515f, this.f5951c.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_set_fail));
            return;
        }
        C2538c.m12674b("AlarmActivity", "========== set watch alarm list Success");
        C1895l.m9663a(this.f5951c.f5515f, this.f5951c.f5514e);
    }
}
