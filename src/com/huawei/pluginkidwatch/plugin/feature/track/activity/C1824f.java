package com.huawei.pluginkidwatch.plugin.feature.track.activity;

import com.huawei.pluginkidwatch.common.lib.utils.C1485e;
import com.huawei.pluginkidwatch.common.ui.p150a.C1499a;
import com.huawei.pluginkidwatch.common.ui.p150a.C1500b;
import com.huawei.pluginkidwatch.common.ui.p150a.C1509k;
import java.util.Date;

/* compiled from: TrackActivity */
class C1824f implements C1509k {
    final /* synthetic */ TrackActivity f5133a;

    C1824f(TrackActivity trackActivity) {
        this.f5133a = trackActivity;
    }

    public void mo2603a(Date date) {
        if (this.f5133a.ak && this.f5133a.al != null) {
            this.f5133a.al.m8796a();
        }
        this.f5133a.m8770l();
        C1499a.m6962a(date);
        C1500b.m6964a();
        String a = C1485e.m6849a(date, "yyyy年MM月dd日");
        if (a.equals(C1485e.m6861c())) {
            this.f5133a.f5104e.setEnabled(false);
            this.f5133a.f5106g.setVisibility(8);
        } else {
            this.f5133a.f5104e.setEnabled(true);
            this.f5133a.f5106g.setVisibility(0);
        }
        this.f5133a.f5105f.setText(a);
        this.f5133a.m8747d(a);
    }
}
