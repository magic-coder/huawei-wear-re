package com.huawei.openalliance.ad.p112a.p123f;

import com.huawei.openalliance.ad.inter.constant.EventType;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1221g;
import com.huawei.openalliance.ad.p112a.p121e.C1249b;

class C1276n implements Runnable {
    final /* synthetic */ C1221g f2720a;
    final /* synthetic */ C1275m f2721b;

    C1276n(C1275m c1275m, C1221g c1221g) {
        this.f2721b = c1275m;
        this.f2720a = c1221g;
    }

    public void run() {
        C1249b.m5537a(this.f2721b.f2709a, 1, EventType.IMPRESSION, this.f2720a);
    }
}
