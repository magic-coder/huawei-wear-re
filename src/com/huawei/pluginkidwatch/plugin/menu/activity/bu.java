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
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1395k;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;

/* compiled from: ContactInfoActivity */
class bu implements C1378e {
    final /* synthetic */ UserInfo f5980a;
    final /* synthetic */ ContactInfoActivity f5981b;

    bu(ContactInfoActivity contactInfoActivity, UserInfo userInfo) {
        this.f5981b = contactInfoActivity;
        this.f5980a = userInfo;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        C1506g.m6979b();
        if (baseEntityModel.retCode == 0) {
            C1497q.m6942a(this.f5981b, "diteManger", Boolean.valueOf(true));
            this.f5981b.finish();
            Bitmap b = C1465a.m6770a().m6776b(this.f5980a.bigHeadIcon);
            if (b != null) {
                b.recycle();
                C1465a.m6770a().m6774a(this.f5980a.bigHeadIcon);
            }
            C1395k a = C1392h.m6269a(this.f5981b, C1462f.m6744i(), C1462f.m6746j());
            C2538c.m12674b("ContactInfoActivity", "deviceInfo = " + a);
            C1492l.m6911a(this.f5981b.getBaseContext(), a.B.a(), !String.valueOf(1).equals(a.f3099s) ? "k1" : "k2", a.f3096p);
            if (a.f3096p != null) {
                this.f5981b.f5570t.mo2508a(a.f3096p, C1462f.m6746j());
                return;
            }
            return;
        }
        C1483c.m6824a(this.f5981b, C1680l.IDS_plugin_kidwatch_common_process_failed);
    }
}
