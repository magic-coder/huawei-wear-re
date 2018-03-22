package com.huawei.pluginkidwatch.home.p156b;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.CommonStateRetIOModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1410z;

/* compiled from: CheckNewVersionUtils */
class C1634n implements C1378e {
    final /* synthetic */ boolean f4240a;
    final /* synthetic */ C1624d f4241b;

    C1634n(C1624d c1624d, boolean z) {
        this.f4241b = c1624d;
        this.f4240a = z;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "===============retCode", baseEntityModel.retCode + "");
        if (baseEntityModel.retCode == 0) {
            CommonStateRetIOModel commonStateRetIOModel = (CommonStateRetIOModel) baseEntityModel;
            C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "======K1Util.stringToint(model.commonState.value) ==" + C1492l.m6920d(commonStateRetIOModel.commonState.value));
            C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "======model.commonState.value ==" + commonStateRetIOModel.commonState.value);
            C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "========value=" + C1492l.m6920d(commonStateRetIOModel.commonState.value));
            C1410z e = C1392h.m6309e(this.f4241b.f4215n, C1462f.m6744i(), C1462f.m6746j());
            if (e != null) {
                long f = C1492l.m6922f(e.f3216h);
                C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "=========startTime==" + e.f3216h);
                C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "========model.commonState.lastModifyTime==" + commonStateRetIOModel.commonState.lastModifyTime);
                if (C1492l.m6922f(commonStateRetIOModel.commonState.lastModifyTime) < f) {
                    C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "=========时间校验不通过");
                    C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "checkedUpdateStatusCount++" + C1624d.m7713l());
                    C1624d.m7713l();
                    return;
                }
                C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "=========更新UI");
                if (C1624d.f4201l != 0) {
                    C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "checkedUpdateStatusCount" + C1624d.f4200k);
                    C1624d.f4200k = true;
                    C1624d.f4201l = 0;
                }
                this.f4241b.m7732a(r0, this.f4240a);
                return;
            }
            C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "=========getUpdateState-->table is null");
        } else if (C1492l.m6916b(this.f4241b.f4215n)) {
            this.f4241b.f4219r.postDelayed(this.f4241b.f4220u, 20000);
            C2538c.m12680e("KIDWATCH_CheckNewVersionUtils", "=========getUpdateState-->ERROR!!!");
        } else {
            C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "=========getUpdateState-->!K1Util.isNetworkConnected");
            C1483c.m6824a(this.f4241b.f4215n, C1680l.IDS_plugin_kidwatch_common_network_disable);
        }
    }
}
