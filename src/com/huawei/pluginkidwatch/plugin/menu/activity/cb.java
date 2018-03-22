package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.graphics.Bitmap;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.lib.p147b.C1465a;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.p138a.C1391g;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1395k;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;

/* compiled from: ContactsListActivity */
class cb implements C1378e {
    final /* synthetic */ ContactsListActivity f5991a;

    cb(ContactsListActivity contactsListActivity) {
        this.f5991a = contactsListActivity;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        C1506g.m6979b();
        if (baseEntityModel != null && baseEntityModel.retCode == 0) {
            new C1391g(this.f5991a.getApplicationContext()).m6265b(this.f5991a.f5582F.getContactId());
            C1395k a = C1392h.m6269a(this.f5991a, C1462f.m6744i(), C1462f.m6746j());
            if (!(a == null || a.f3096p == null)) {
                C2538c.m12674b("ContactsListActivity", "deviceInfo = " + a);
                C2538c.m12674b("ContactsListActivity", "deviceInfo = " + a.f3096p);
                this.f5991a.f5627z.mo2508a(a.f3096p, C1462f.m6746j());
            }
            this.f5991a.f5586J.remove(this.f5991a.f5582F);
            this.f5991a.f5626y.sendEmptyMessage(3);
            Bitmap b = C1465a.m6770a().m6776b(this.f5991a.f5582F.bigHeadIcon);
            if (b != null) {
                b.recycle();
            }
        } else if (baseEntityModel == null || 13206 != baseEntityModel.retCode) {
            C1483c.m6824a(this.f5991a, C1680l.IDS_plugin_kidwatch_menu_contactmanage_delete_fail);
        } else {
            this.f5991a.f5626y.sendEmptyMessage(3);
        }
    }
}
