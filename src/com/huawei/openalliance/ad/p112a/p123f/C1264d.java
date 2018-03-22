package com.huawei.openalliance.ad.p112a.p123f;

import android.content.Context;
import com.huawei.openalliance.ad.p112a.p113a.C1235b;
import com.huawei.openalliance.ad.p112a.p121e.C1255g;
import com.huawei.openalliance.ad.p112a.p121e.C1256h;
import com.huawei.openalliance.ad.p112a.p121e.C1258j;

class C1264d implements Runnable {
    final /* synthetic */ Context f2689a;
    final /* synthetic */ C1235b f2690b;
    final /* synthetic */ C1262b f2691c;

    C1264d(C1262b c1262b, Context context, C1235b c1235b) {
        this.f2691c = c1262b;
        this.f2689a = context;
        this.f2690b = c1235b;
    }

    public void run() {
        C1255g.m5564a(this.f2689a, this.f2690b.getInvalidcontentid__());
        C1261a.m5577a(this.f2689a, this.f2690b.getRetcode__(), this.f2690b.getSloganList__());
        C1258j.m5575a(this.f2689a, this.f2690b.getInvalidSloganId__());
        C1256h.m5569a(this.f2689a, this.f2690b.getTodayNoShowContentid__());
    }
}
