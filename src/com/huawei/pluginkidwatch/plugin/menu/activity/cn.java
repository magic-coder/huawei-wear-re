package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.graphics.Bitmap;
import com.huawei.hwcommonmodel.b.a;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.UserInfo;
import com.huawei.pluginkidwatch.common.lib.p147b.C1465a;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1395k;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;

/* compiled from: ContactsListActivity */
class cn implements C1378e {
    final /* synthetic */ UserInfo f6007a;
    final /* synthetic */ ContactsListActivity f6008b;

    cn(ContactsListActivity contactsListActivity, UserInfo userInfo) {
        this.f6008b = contactsListActivity;
        this.f6007a = userInfo;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        C1506g.m6979b();
        if (baseEntityModel.retCode == 0) {
            C2538c.m12674b("ContactsListActivity", "==ww== mOperateDialog  unbind SUCCESS ");
            Bitmap b = C1465a.m6770a().m6776b(this.f6007a.bigHeadIcon);
            if (b != null) {
                b.recycle();
                C1465a.m6770a().m6775a(this.f6007a.bigHeadIcon, null);
            }
            this.f6008b.m9244h();
            C1395k a = C1392h.m6269a(this.f6008b, C1462f.m6744i(), C1462f.m6746j());
            if (!(a == null || a.f3096p == null)) {
                C2538c.m12674b("ContactsListActivity", "deviceInfo = " + a);
                C2538c.m12674b("ContactsListActivity", "deviceInfo = " + a.f3096p);
                this.f6008b.f5627z.mo2508a(a.f3096p, C1462f.m6746j());
            }
            if (C1462f.m6748k() != null) {
                C1492l.m6911a(this.f6008b.getBaseContext(), a.B.a(), !String.valueOf(1).equals(a.f3099s) ? "k1" : "k2", a.f3096p);
                return;
            }
            return;
        }
        C1483c.m6824a(this.f6008b, C1680l.IDS_plugin_kidwatch_common_process_failed);
    }
}
