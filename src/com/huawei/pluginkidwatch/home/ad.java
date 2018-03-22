package com.huawei.pluginkidwatch.home;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.ui.view.C1595v;

/* compiled from: HomeActivity */
class ad implements C1378e {
    final /* synthetic */ HomeActivity f4166a;

    ad(HomeActivity homeActivity) {
        this.f4166a = homeActivity;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (baseEntityModel != null && baseEntityModel.retCode == 0) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "=========makeSecretcallCust success");
            this.f4166a.aA = C1483c.m6827b(this.f4166a.f4109F, this.f4166a.getString(C1680l.IDS_plugin_kidwatch_menu_record_success), 1);
            this.f4166a.m7580d(5);
        } else if (baseEntityModel == null || 13204 != baseEntityModel.retCode) {
            this.f4166a.f4131c.post(this.f4166a.cs);
            C2538c.m12674b("KIDWATCH_HomeActivity", "=========makeSecretcallCust falure");
            this.f4166a.m7518a(this.f4166a.f4109F, C1680l.IDS_plugin_kidwatch_menu_record_failed, true);
        } else {
            this.f4166a.f4131c.post(this.f4166a.cs);
            C2538c.m12674b("KIDWATCH_HomeActivity", "==========发起远程监听失败，号码不存在");
            C1595v a = new C1595v(this.f4166a.f4109F).m7339a(C1680l.IDS_plugin_kidwatch_common_tips).m7348b(C1680l.IDS_plugin_kidwatch_menu_record_failed_no_exit).m7340a(C1680l.IDS_plugin_kidwatch_common_know_tips, new ae(this));
            this.f4166a.f4136i = a.m7338a();
            this.f4166a.f4136i.setCanceledOnTouchOutside(false);
            this.f4166a.f4136i.setCancelable(false);
            this.f4166a.f4136i.show();
        }
    }
}
