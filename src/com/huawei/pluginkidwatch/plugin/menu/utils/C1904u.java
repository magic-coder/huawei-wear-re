package com.huawei.pluginkidwatch.plugin.menu.utils;

import android.content.Context;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1413d;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1395k;
import com.huawei.pluginkidwatch.common.p138a.C1401q;

/* compiled from: MenuUtils */
final class C1904u implements C1378e {
    final /* synthetic */ Context f6229a;
    final /* synthetic */ C1401q f6230b;
    final /* synthetic */ C1413d f6231c;

    C1904u(Context context, C1401q c1401q, C1413d c1413d) {
        this.f6229a = context;
        this.f6230b = c1401q;
        this.f6231c = c1413d;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (baseEntityModel.retCode == 0) {
            C2538c.m12674b("MenuUtils", "===deleteWatchContact success====");
            C1392h.m6307d(this.f6229a, this.f6230b);
            C1395k a = C1392h.m6269a(this.f6229a, C1462f.m6744i(), C1462f.m6746j());
            if (!(a == null || a.f3096p == null)) {
                C2538c.m12674b("MenuUtils", "==========拒绝添加联系人正常发送立即更新");
                this.f6231c.mo2508a(a.f3096p, C1462f.m6746j());
            }
        } else {
            C2538c.m12674b("MenuUtils", "===deleteWatchContact fail====Msg:" + baseEntityModel.retMsg);
            C1483c.m6824a(this.f6229a, C1680l.IDS_plugin_kidwatch_common_failed);
        }
        C1902s.f6225a.mo2563a(baseEntityModel.retCode);
    }
}
