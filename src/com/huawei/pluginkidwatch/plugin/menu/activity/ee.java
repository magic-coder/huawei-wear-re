package com.huawei.pluginkidwatch.plugin.menu.activity;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1395k;

/* compiled from: GeneralSettingsActivity */
class ee implements C1378e {
    final /* synthetic */ String f6071a;
    final /* synthetic */ boolean f6072b;
    final /* synthetic */ GeneralSettingsActivity f6073c;

    ee(GeneralSettingsActivity generalSettingsActivity, String str, boolean z) {
        this.f6073c = generalSettingsActivity;
        this.f6071a = str;
        this.f6072b = z;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        boolean z = true;
        C2538c.m12674b("KIDWATCH_GeneralSettingsActivity", "========== entity.setWatchSetting-->onResponse");
        if (baseEntityModel == null || baseEntityModel.retCode != 0) {
            C2538c.m12680e("KIDWATCH_GeneralSettingsActivity", "========== set setting info error");
            GeneralSettingsActivity generalSettingsActivity = this.f6073c;
            String str = this.f6071a;
            if (this.f6072b) {
                z = false;
            }
            generalSettingsActivity.m9397b(str, z);
            C1483c.m6832c(this.f6073c.f5733b, this.f6073c.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_set_fail));
            return;
        }
        C2538c.m12674b("KIDWATCH_GeneralSettingsActivity", "========== set setting info Success");
        C1395k a = C1392h.m6269a(this.f6073c.f5733b, C1462f.m6744i(), C1462f.m6746j());
        if (a.f3096p != null) {
            this.f6073c.f5734c.mo2508a(a.f3096p, C1462f.m6746j());
        }
    }
}
