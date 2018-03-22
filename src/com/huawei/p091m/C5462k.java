package com.huawei.p091m;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.m.d;
import com.huawei.p190v.C2538c;

/* compiled from: HwCoreSleepMgr */
class C5462k extends Handler {
    final /* synthetic */ d f19310a;

    C5462k(d dVar, Looper looper) {
        this.f19310a = dVar;
        super(looper);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 0:
                C2538c.c("HwCoreSleepMgr", new Object[]{"sync time out"});
                d.a(this.f19310a);
                d.b(this.f19310a);
                d.a(this.f19310a, false);
                return;
            case 1:
                C2538c.c("HwCoreSleepMgr", new Object[]{"proc cpc time out"});
                d.a(this.f19310a);
                d.b(this.f19310a);
                d.a(this.f19310a, false);
                return;
            case 2:
                C2538c.c("HwCoreSleepMgr", new Object[]{"proc update sync flag"});
                this.f19310a.b = 1;
                return;
            default:
                return;
        }
    }
}
