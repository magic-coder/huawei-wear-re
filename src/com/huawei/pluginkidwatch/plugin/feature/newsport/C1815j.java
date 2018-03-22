package com.huawei.pluginkidwatch.plugin.feature.newsport;

import android.content.Context;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.p138a.C1399o;
import java.util.List;

/* compiled from: NewSportActivity */
class C1815j extends C1808c {
    final /* synthetic */ boolean f5009b;
    final /* synthetic */ NewSportActivity f5010c;

    C1815j(NewSportActivity newSportActivity, Context context, C1810e c1810e, boolean z) {
        this.f5010c = newSportActivity;
        this.f5009b = z;
        super(context, c1810e);
    }

    public void mo2605a(List<C1399o> list) {
        C2538c.m12674b("NewSportActivity", "======AsyncLoadNewData========");
        this.f5010c.m8627a((List) list);
        if (list == null && this.f5009b) {
            this.f5010c.m8621g();
        }
    }
}
