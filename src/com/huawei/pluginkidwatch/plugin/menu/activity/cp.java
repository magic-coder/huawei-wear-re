package com.huawei.pluginkidwatch.plugin.menu.activity;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.GetContactIOEntityModel;
import java.util.List;

/* compiled from: ContactsListActivity */
class cp implements C1378e {
    final /* synthetic */ ContactsListActivity f6010a;

    cp(ContactsListActivity contactsListActivity) {
        this.f6010a = contactsListActivity;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (baseEntityModel != null && baseEntityModel.retCode == 0) {
            List list = ((GetContactIOEntityModel) baseEntityModel).contactsInfo;
            if (list == null || list.size() <= 0) {
                this.f6010a.m9231c(null);
            } else if (!this.f6010a.isFinishing()) {
                this.f6010a.f5605d = list.size();
                this.f6010a.m9231c(list);
                C2538c.m12674b("ContactsListActivity", "==ww ==  form db mContactNum --" + this.f6010a.f5605d);
            }
        }
    }
}
