package com.huawei.pluginkidwatch.home.p156b;

import android.content.Context;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.WatchStatus;
import com.huawei.pluginkidwatch.common.entity.model.WatchStatusIOModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;

/* compiled from: CheckUpdateVersionFactory */
final class C1640t implements C1378e {
    final /* synthetic */ Context f4253a;
    final /* synthetic */ boolean f4254b;

    C1640t(Context context, boolean z) {
        this.f4253a = context;
        this.f4254b = z;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (baseEntityModel != null && baseEntityModel.retCode == 0) {
            C2538c.m12674b(C1638r.f4249a, "==autoCheckNewVersion== setWatchVersion " + baseEntityModel.retCode);
            WatchStatus watchStatus = ((WatchStatusIOModel) baseEntityModel).watchStatus;
            if (watchStatus != null && watchStatus.version != null && !"".equals(watchStatus.version)) {
                int d;
                int d2;
                C2538c.m12674b(C1638r.f4249a, "==autoCheckNewVersion== setWatchVersion=entity.getWatchStatus " + watchStatus.version);
                String[] split = watchStatus.version.split("\\.");
                for (String d3 : split) {
                    d2 = C1492l.m6920d(d3);
                    C2538c.m12674b(C1638r.f4249a, "==autoCheckNewVersion== setWatchVersion nowVersion allSplitNum=" + d2);
                }
                if (split.length >= 3) {
                    d = C1492l.m6920d(split[0]);
                    C2538c.m12674b(C1638r.f4249a, "==autoCheckNewVersion== setWatchVersion nowVersion firstNumber=" + split[0]);
                    d2 = C1492l.m6920d(split[1]);
                    C2538c.m12674b(C1638r.f4249a, "==autoCheckNewVersion== setWatchVersion nowVersion secondNumber=" + split[1]);
                    int d4 = C1492l.m6920d(split[2]);
                    C2538c.m12674b(C1638r.f4249a, "==autoCheckNewVersion== setWatchVersion nowVersion thirdNumber=" + split[2]);
                    if (d > 1 || d2 > 33 || (d2 == 33 && d4 > 1)) {
                        C1638r.m7764c(this.f4253a, this.f4254b);
                        return;
                    }
                }
                C2538c.m12674b(C1638r.f4249a, "==autoCheckNewVersion==Enter app autoCheckNewVersion");
                C1638r.m7758a(this.f4253a, this.f4254b);
            }
        }
    }
}
