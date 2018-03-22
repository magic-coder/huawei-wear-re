package com.huawei.pluginkidwatch.plugin.feature.antiloss;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.plugin.feature.antiloss.p162a.C1773a;

/* compiled from: AntilossActivity */
class C1782f implements Runnable {
    final /* synthetic */ C1780d f4931a;

    C1782f(C1780d c1780d) {
        this.f4931a = c1780d;
    }

    public void run() {
        C2538c.m12674b("AntilossActivity", "BluetoothAdapter ACTION_STATE_CHANGED STATE_ON connecting device !!!!");
        if (3 == this.f4931a.f4929a.f4904w.m8302i() || this.f4931a.f4929a.f4904w.m8302i() == 0 || -1 == this.f4931a.f4929a.f4904w.m8302i()) {
            if (C1773a.m8552a(this.f4931a.f4929a.f4879J) != null) {
                C1773a.m8552a(this.f4931a.f4929a.f4879J).m8560d(this.f4931a.f4929a.f4879J);
            }
            this.f4931a.f4929a.f4904w.m8293c(this.f4931a.f4929a.f4882M);
        }
    }
}
