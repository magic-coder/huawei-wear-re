package com.huawei.pluginkidwatch.home;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import org.apache.log4j.helpers.FileWatchdog;

/* compiled from: K1PushService */
class bn implements Runnable {
    final /* synthetic */ K1PushService f4280a;

    bn(K1PushService k1PushService) {
        this.f4280a = k1PushService;
    }

    public void run() {
        if (this.f4280a.f4155b != null) {
            C2538c.m12674b("K1PushService", "==========runnableCheck --> check connected state");
            if (C1492l.m6912a() || !C1483c.m6829b(this.f4280a.f4155b)) {
                C2538c.m12674b("K1PushService", "is emui 3.X");
            } else {
                this.f4280a.m7647a();
            }
        } else {
            C2538c.m12674b("K1PushService", "==========runnableCheck -->mContext is null");
        }
        this.f4280a.f4156c.postDelayed(this.f4280a.f4158e, FileWatchdog.DEFAULT_DELAY);
    }
}
