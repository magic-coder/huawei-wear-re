package com.huawei.pluginkidwatch.plugin.menu.activity;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;

/* compiled from: GeneralSettingsActivity */
class el implements C1378e {
    final /* synthetic */ boolean f6080a;
    final /* synthetic */ GeneralSettingsActivity f6081b;

    el(GeneralSettingsActivity generalSettingsActivity, boolean z) {
        this.f6081b = generalSettingsActivity;
        this.f6080a = z;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (baseEntityModel != null && baseEntityModel.retCode == 0) {
            C1506g.m6979b();
            C1497q.m6943a(this.f6081b.f5733b, "managerphonenumber", "");
            this.f6081b.m9407f();
        } else if (this.f6080a) {
            C2538c.m12674b("KIDWATCH_GeneralSettingsActivity", "===============恢复出厂失败，再试一次");
            this.f6081b.m9386a(12, "", false);
        } else if (baseEntityModel == null || 13214 != baseEntityModel.retCode) {
            try {
                C1506g.m6979b();
                if (!this.f6081b.isFinishing()) {
                    C1483c.m6824a(this.f6081b.f5733b, C1680l.IDS_plugin_kidwatch_menu_reset_failed);
                }
            } catch (Exception e) {
                C2538c.m12674b("KIDWATCH_GeneralSettingsActivity", "resetFactory Exception e !!!");
            }
        } else {
            C1506g.m6979b();
            this.f6081b.m9407f();
        }
    }
}
