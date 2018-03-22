package com.huawei.pluginkidwatch.plugin.menu.utils;

import android.content.Context;
import com.huawei.hwcommonmodel.b.a;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1413d;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1395k;
import com.huawei.pluginkidwatch.common.p138a.C1401q;

/* compiled from: MenuUtils */
final class C1903t implements C1378e {
    final /* synthetic */ Context f6226a;
    final /* synthetic */ C1401q f6227b;
    final /* synthetic */ C1413d f6228c;

    C1903t(Context context, C1401q c1401q, C1413d c1413d) {
        this.f6226a = context;
        this.f6227b = c1401q;
        this.f6228c = c1413d;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (baseEntityModel.retCode == 0) {
            C2538c.m12674b("MenuUtils", "===confirmBind success====");
            C1392h.m6307d(this.f6226a, this.f6227b);
            if (1 == this.f6227b.f3151g) {
                String str;
                C1395k a = C1392h.m6269a(this.f6226a, C1462f.m6744i(), C1462f.m6746j());
                if (!(a == null || a.f3096p == null)) {
                    this.f6228c.mo2508a(a.f3096p, C1462f.m6746j());
                }
                C1395k a2 = C1392h.m6269a(this.f6226a, C1462f.m6744i(), this.f6227b.f3147c);
                Context context = this.f6226a;
                String a3 = a.A.a();
                if (String.valueOf(1).equals(a2.f3099s)) {
                    str = "k2";
                } else {
                    str = "k1";
                }
                C1492l.m6911a(context, a3, str, a2.f3096p);
            }
        } else {
            C2538c.m12674b("MenuUtils", "===confirmBind fail====Msg:" + baseEntityModel.retMsg);
            C2538c.m12674b("MenuUtils", "===confirmBind fail====resultCode:" + baseEntityModel.retCode);
            if (13204 == baseEntityModel.retCode) {
                this.f6227b.f3151g = 3;
                C1392h.m6307d(this.f6226a, this.f6227b);
            } else if (13211 == baseEntityModel.retCode) {
                C1483c.m6824a(this.f6226a, C1680l.IDS_plugin_kidwatch_settings_invite_failed_ismanager);
            } else {
                C1483c.m6824a(this.f6226a, C1680l.IDS_plugin_kidwatch_common_failed);
            }
        }
        C1902s.f6225a.mo2563a(baseEntityModel.retCode);
    }
}
