package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.graphics.Bitmap;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.lib.p147b.C1465a;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1395k;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;

/* compiled from: TailorContactActivity */
class gn implements C1378e {
    final /* synthetic */ gm f6157a;

    gn(gm gmVar) {
        this.f6157a = gmVar;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        C1506g.m6979b();
        this.f6157a.f6156a.f6154a.f5907n.dismiss();
        this.f6157a.f6156a.f6154a.f5907n = null;
        if (baseEntityModel == null || baseEntityModel.retCode != 0) {
            C1483c.m6824a(this.f6157a.f6156a.f6154a, C1680l.IDS_plugin_kidwatch_menu_contactmanage_delete_fail);
            return;
        }
        this.f6157a.f6156a.f6154a.f5919z.m6265b(C1497q.m6948c(this.f6157a.f6156a.f6154a, "contactid"));
        Bitmap b = C1465a.m6770a().m6776b(C1497q.m6945b(this.f6157a.f6156a.f6154a, "contactheadcion", ""));
        if (b != null) {
            b.recycle();
            C1465a.m6770a().m6774a(C1497q.m6945b(this.f6157a.f6156a.f6154a, "contactheadcion", ""));
        }
        C1395k a = C1392h.m6269a(this.f6157a.f6156a.f6154a, C1462f.m6744i(), C1462f.m6746j());
        if (!(a == null || a.f3096p == null)) {
            C2538c.m12674b("TailorContactActivity", "deviceInfo = " + a);
            this.f6157a.f6156a.f6154a.f5903j.mo2508a(a.f3096p, C1462f.m6746j());
        }
        ContactsListActivity.m9217a(true);
        this.f6157a.f6156a.f6154a.finish();
    }
}
