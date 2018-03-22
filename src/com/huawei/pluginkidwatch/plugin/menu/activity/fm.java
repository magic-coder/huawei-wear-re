package com.huawei.pluginkidwatch.plugin.menu.activity;

import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1895l;

/* compiled from: PeroidActivity */
class fm implements C1378e {
    final /* synthetic */ PeroidActivity f6125a;

    fm(PeroidActivity peroidActivity) {
        this.f6125a = peroidActivity;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (baseEntityModel != null && baseEntityModel.retCode == 0) {
            C1895l.m9663a(this.f6125a.f5800f, this.f6125a.f5799e);
            this.f6125a.m9481a(this.f6125a.f5801g);
        } else if (!this.f6125a.isFinishing()) {
            C1483c.m6832c(this.f6125a.f5800f, this.f6125a.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_contactmanage_delete_fail));
        }
    }
}
