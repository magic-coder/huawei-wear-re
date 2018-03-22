package com.huawei.pluginkidwatch.home.p156b;

import android.content.Context;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.CommonStateRetIOModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;

/* compiled from: CheckUpdateVersionFactory */
final class C1641u implements C1378e {
    final /* synthetic */ Context f4255a;
    final /* synthetic */ boolean f4256b;

    C1641u(Context context, boolean z) {
        this.f4255a = context;
        this.f4256b = z;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        C2538c.m12674b(C1638r.f4249a, "===============retCode", baseEntityModel.retCode + "");
        if (baseEntityModel.retCode == 0) {
            CommonStateRetIOModel commonStateRetIOModel = (CommonStateRetIOModel) baseEntityModel;
            C2538c.m12674b(C1638r.f4249a, "==autoCheckNewVersion== K1Util.stringToint(model.commonState.value) ==" + C1492l.m6920d(commonStateRetIOModel.commonState.value));
            C2538c.m12674b(C1638r.f4249a, "==autoCheckNewVersion== model.commonState.value ==" + commonStateRetIOModel.commonState.value);
            int d = C1492l.m6920d(commonStateRetIOModel.commonState.value);
            C2538c.m12674b(C1638r.f4249a, "==autoCheckNewVersion== value==" + d);
            if (3 == d) {
                C2538c.m12674b(C1638r.f4249a, "==autoCheckNewVersion==Enter watch autoCheckNewVersion");
                C1638r.f4251c.m7733a(this.f4255a, this.f4256b);
            }
        }
    }
}
