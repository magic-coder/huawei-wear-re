package com.huawei.openalliance.ad.p112a.p123f;

import android.content.Context;
import com.huawei.openalliance.ad.p112a.p113a.C1235b;
import com.huawei.openalliance.ad.p112a.p121e.C1255g;
import com.huawei.openalliance.ad.p112a.p121e.C1256h;
import com.huawei.openalliance.ad.p112a.p121e.C1258j;

class C1263c implements Runnable {
    final /* synthetic */ C1235b f2686a;
    final /* synthetic */ Context f2687b;
    final /* synthetic */ C1262b f2688c;

    C1263c(C1262b c1262b, C1235b c1235b, Context context) {
        this.f2688c = c1262b;
        this.f2686a = c1235b;
        this.f2687b = context;
    }

    public void run() {
        if (C1261a.m5584b(this.f2686a)) {
            C1268h.m5600a(this.f2687b, this.f2686a, this.f2688c.f2683d, this.f2688c.f2684e, this.f2688c.f2685f);
        }
        C1255g.m5564a(this.f2687b, this.f2686a.getInvalidcontentid__());
        C1261a.m5577a(this.f2687b, this.f2686a.getRetcode__(), this.f2686a.getSloganList__());
        C1258j.m5575a(this.f2687b, this.f2686a.getInvalidSloganId__());
        C1256h.m5569a(this.f2687b, this.f2686a.getTodayNoShowContentid__());
    }
}
