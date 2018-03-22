package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import com.huawei.hwcommonmodel.b.a;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.lib.p147b.C1465a;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1395k;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;

/* compiled from: ContactInfoActivity */
class be implements C1378e {
    final /* synthetic */ ContactInfoActivity f5960a;

    be(ContactInfoActivity contactInfoActivity) {
        this.f5960a = contactInfoActivity;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        C1506g.m6979b();
        C1497q.m6942a(this.f5960a, "isunbindself", Boolean.valueOf(false));
        if (baseEntityModel.retCode == 0) {
            C1497q.m6942a(this.f5960a, "diteManger", Boolean.valueOf(true));
            this.f5960a.finish();
            Bitmap b = C1465a.m6770a().m6776b(this.f5960a.f5533F.bigHeadIcon);
            if (b != null) {
                b.recycle();
                C1465a.m6770a().m6774a(this.f5960a.f5533F.bigHeadIcon);
            }
            if (C1462f.m6748k() != null) {
                C1492l.m6911a(this.f5960a.getBaseContext(), a.B.a(), !String.valueOf(1).equals(C1462f.m6748k().f3099s) ? "k1" : "k2", C1462f.m6748k().f3096p);
            }
            C1392h.m6283a(this.f5960a, C1462f.m6748k());
            C1392h.m6306d(this.f5960a, C1462f.m6746j());
            C1392h.m6310e(this.f5960a, C1462f.m6746j());
            C1392h.m6312f(this.f5960a, C1462f.m6744i(), C1462f.m6746j());
            C1462f.m6718a(null);
            C1462f.m6731d("");
            C1462f.m6722a(true);
            C1497q.m6943a(this.f5960a, "managerphonenumber", "");
            C1497q.m6943a(this.f5960a, "sharedpreferences_watch_device_code", "");
            C1497q.m6942a(this.f5960a, "resutunbindall", Boolean.valueOf(true));
            C1395k a = C1392h.m6269a(this.f5960a, C1462f.m6744i(), C1462f.m6746j());
            C2538c.m12674b("ContactInfoActivity", "deviceInfo = " + a);
            if (a.f3096p != null) {
                C2538c.m12674b("ContactInfoActivity", "deviceInfo.BtMac = " + a.f3096p);
                this.f5960a.f5570t.mo2508a(a.f3096p, C1462f.m6746j());
            }
            Intent intent = new Intent();
            intent.setClassName(this.f5960a, "com.huawei.pluginkidwatch.HomeActivity");
            this.f5960a.startActivity(intent);
            this.f5960a.finish();
            return;
        }
        C1483c.m6824a(this.f5960a, C1680l.IDS_plugin_kidwatch_common_process_failed);
    }
}
