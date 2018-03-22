package com.huawei.openalliance.ad.p112a.p123f;

import android.content.Context;
import com.huawei.openalliance.ad.p112a.p113a.C1235b;
import com.huawei.openalliance.ad.p112a.p121e.C1255g;
import com.huawei.openalliance.ad.p112a.p122h.C1284b;

class C1271k implements Runnable {
    final /* synthetic */ C1235b f2706a;
    final /* synthetic */ Context f2707b;
    final /* synthetic */ C1269i f2708c;

    C1271k(C1269i c1269i, C1235b c1235b, Context context) {
        this.f2708c = c1269i;
        this.f2706a = c1235b;
        this.f2707b = context;
    }

    public void run() {
        if (C1284b.m5669a(this.f2706a)) {
            this.f2708c.m5589a(this.f2707b, this.f2706a);
        }
        C1255g.m5564a(this.f2707b, this.f2706a.getInvalidcontentid__());
    }
}
