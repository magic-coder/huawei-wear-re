package com.huawei.pluginkidwatch.plugin.menu.p165a;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.lib.utils.C1485e;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1898o;
import java.util.Timer;

/* compiled from: NotificationHistoryAdapter */
class ak implements Runnable {
    final /* synthetic */ at f5190a;
    final /* synthetic */ ah f5191b;

    ak(ah ahVar, at atVar) {
        this.f5191b = ahVar;
        this.f5190a = atVar;
    }

    public void run() {
        C2538c.m12674b("NotificationHistoryAdapter", "index:" + this.f5190a.f5210D + " duration:" + C1898o.m9672c());
        this.f5190a.f5211E.setMax(C1898o.m9672c());
        this.f5191b.f5184l = C1898o.m9672c();
        this.f5191b.f5187o = C1485e.m6862c((long) this.f5191b.f5184l);
        this.f5190a.f5208B.setText(this.f5191b.f5187o);
        this.f5191b.f5181i = new Timer();
        this.f5191b.f5182j = new al(this);
        this.f5191b.f5181i.schedule(this.f5191b.f5182j, 0, 10);
    }
}
