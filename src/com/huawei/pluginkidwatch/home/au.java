package com.huawei.pluginkidwatch.home;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;

/* compiled from: HomeActivity */
class au implements OnClickListener {
    final /* synthetic */ HomeActivity f4188a;

    au(HomeActivity homeActivity) {
        this.f4188a = homeActivity;
    }

    public void onClick(View view) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "===navigation===onclick==Enter skipToThirdApp");
        if (C1492l.m6916b(this.f4188a.f4109F)) {
            if (this.f4188a.aM != null && 0.0d != this.f4188a.aM.lastLocation.lon) {
                this.f4188a.aw();
            }
        } else if (!this.f4188a.m7641a(2000)) {
            C1483c.m6824a(this.f4188a.f4109F, C1680l.IDS_plugin_kidwatch_common_network_disable);
        }
    }
}
