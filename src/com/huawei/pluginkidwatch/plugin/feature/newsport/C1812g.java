package com.huawei.pluginkidwatch.plugin.feature.newsport;

import com.huawei.pluginkidwatch.common.lib.utils.C1485e;
import com.huawei.pluginkidwatch.common.ui.p150a.C1499a;
import com.huawei.pluginkidwatch.common.ui.p150a.C1500b;
import com.huawei.pluginkidwatch.common.ui.p150a.C1509k;
import java.util.Date;

/* compiled from: NewSportActivity */
class C1812g implements C1509k {
    final /* synthetic */ NewSportActivity f5006a;

    C1812g(NewSportActivity newSportActivity) {
        this.f5006a = newSportActivity;
    }

    public void mo2603a(Date date) {
        C1499a.m6962a(date);
        C1500b.m6964a();
        Object a = C1485e.m6849a(date, "yyyy年MM月dd日");
        this.f5006a.m8610a(date);
        this.f5006a.m8619f();
        this.f5006a.f4972h.setText(a);
        if (a.equals(C1485e.m6861c())) {
            this.f5006a.f4969e.setEnabled(false);
            this.f5006a.f4970f.setVisibility(8);
            return;
        }
        this.f5006a.f4968d.setEnabled(true);
        this.f5006a.f4970f.setVisibility(0);
    }
}
