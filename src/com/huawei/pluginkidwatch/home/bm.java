package com.huawei.pluginkidwatch.home;

import android.content.Intent;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.lib.utils.C1496p;

/* compiled from: K1PushService */
class bm implements Runnable {
    final /* synthetic */ K1PushService f4279a;

    bm(K1PushService k1PushService) {
        this.f4279a = k1PushService;
    }

    public void run() {
        C2538c.m12674b("K1PushService", "==========runnable --> run");
        C2538c.m12674b("K1PushService", "==========runnable --> run  isEmui:" + C1492l.m6912a());
        C2538c.m12674b("K1PushService", "==========runnable --> run" + C1496p.m6932a(this.f4279a.f4155b, "k1pushtokenflag", false));
        if (C1492l.m6912a() || C1496p.m6932a(this.f4279a.f4155b, "k1pushtokenflag", false).booleanValue()) {
            C2538c.m12674b("K1PushService", "==========No need to start forcely");
            return;
        }
        C2538c.m12674b("K1PushService", "==========一直没有token,强制拉起");
        this.f4279a.m7651a(this.f4279a.f4155b, "com.huawei.android.pushagent.PushEventReceiver");
        this.f4279a.m7651a(this.f4279a.f4155b, "com.huawei.android.pushagent.PushBootReceiver");
        Intent intent = new Intent("com.huawei.android.push.intent.REGISTER");
        intent.putExtra("pkg_name", this.f4279a.f4155b.getPackageName());
        intent.setFlags(32);
        this.f4279a.m7649a(this.f4279a.f4155b, intent);
    }
}
