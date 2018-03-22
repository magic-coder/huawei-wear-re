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
class an implements OnClickListener {
    final /* synthetic */ C1401q f5195a;
    final /* synthetic */ at f5196b;
    final /* synthetic */ int f5197c;
    final /* synthetic */ ah f5198d;

    an(ah ahVar, C1401q c1401q, at atVar, int i) {
        this.f5198d = ahVar;
        this.f5195a = c1401q;
        this.f5196b = atVar;
        this.f5197c = i;
    }

    public void onClick(View view) {
        if (!C1492l.m6916b(this.f5198d.f5173a)) {
            C1483c.m6824a(this.f5198d.f5173a, C1680l.IDS_plugin_kidwatch_common_network_disable);
        } else if (!this.f5198d.f5185m) {
            this.f5198d.f5185m = true;
            C2538c.m12674b("NotificationHistoryAdapter", "====btnReject is clicked!");
            this.f5195a.f3151g = 2;
            if (9 == this.f5195a.f3149e) {
                C1902s.m9683a(this.f5198d.f5173a, this.f5195a, new ao(this));
            } else {
                C1902s.m9684b(this.f5198d.f5173a, this.f5195a, new ap(this));
            }
        }
    }
}
