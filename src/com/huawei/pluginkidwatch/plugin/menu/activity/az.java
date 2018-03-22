package com.huawei.pluginkidwatch.plugin.menu.activity;

import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1895l;

/* compiled from: AlarmActivity */
class az implements C1378e {
    final /* synthetic */ AlarmActivity f5952a;

    az(AlarmActivity alarmActivity) {
        this.f5952a = alarmActivity;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (baseEntityModel != null && baseEntityModel.retCode == 0) {
            this.f5952a.m9121a(this.f5952a.f5516g);
            C1895l.m9663a(this.f5952a.f5515f, this.f5952a.f5514e);
        } else if (!this.f5952a.isFinishing()) {
            C1483c.m6832c(this.f5952a.f5515f, this.f5952a.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_contactmanage_delete_fail));
        }
    }
}
