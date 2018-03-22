package com.huawei.pluginkidwatch.plugin.menu.activity;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.UserInfo;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1395k;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;

/* compiled from: ContactsListActivity */
class cm implements C1378e {
    final /* synthetic */ UserInfo f6005a;
    final /* synthetic */ ContactsListActivity f6006b;

    cm(ContactsListActivity contactsListActivity, UserInfo userInfo) {
        this.f6006b = contactsListActivity;
        this.f6005a = userInfo;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        C1506g.m6979b();
        if (baseEntityModel.retCode == 0) {
            C2538c.m12674b("ContactsListActivity", "==ww== mOperateDialog  transferprivilege SUCCESS ");
            C1462f.m6736e(false);
            C1395k a = C1392h.m6269a(this.f6006b, C1462f.m6744i(), C1462f.m6746j());
            a.f3097q = this.f6005a.huid;
            C1392h.m6297b(this.f6006b, a);
            this.f6006b.m9244h();
            this.f6006b.f5613l.setVisibility(8);
            this.f6006b.f5609h.setVisibility(8);
        } else if (baseEntityModel.retCode == 13220) {
            C1483c.m6824a(this.f6006b, C1680l.IDS_plugin_kidwatch_menu_unlogin);
        } else {
            C1483c.m6824a(this.f6006b, C1680l.IDS_plugin_kidwatch_common_process_failed);
        }
    }
}
