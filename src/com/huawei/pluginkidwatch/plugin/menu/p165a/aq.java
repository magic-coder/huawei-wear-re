package com.huawei.pluginkidwatch.plugin.menu.p165a;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.p138a.C1401q;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1902s;

/* compiled from: NotificationHistoryAdapter */
class aq implements OnClickListener {
    final /* synthetic */ C1401q f5201a;
    final /* synthetic */ at f5202b;
    final /* synthetic */ int f5203c;
    final /* synthetic */ ah f5204d;

    aq(ah ahVar, C1401q c1401q, at atVar, int i) {
        this.f5204d = ahVar;
        this.f5201a = c1401q;
        this.f5202b = atVar;
        this.f5203c = i;
    }

    public void onClick(View view) {
        if (!C1492l.m6916b(this.f5204d.f5173a)) {
            C1483c.m6824a(this.f5204d.f5173a, C1680l.IDS_plugin_kidwatch_common_network_disable);
        } else if (!this.f5204d.f5186n) {
            this.f5204d.f5186n = true;
            C2538c.m12674b("NotificationHistoryAdapter", "====btnAllow is clicked!");
            this.f5201a.f3151g = 1;
            if (9 == this.f5201a.f3149e) {
                C1902s.m9683a(this.f5204d.f5173a, this.f5201a, new ar(this));
            } else {
                C1902s.m9684b(this.f5204d.f5173a, this.f5201a, new as(this));
            }
        }
    }
}
