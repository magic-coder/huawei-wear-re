package com.huawei.hwservicesmgr;

import android.content.Intent;
import com.huawei.hwservicesmgr.remote.RemoteServiceMgr;
import com.huawei.p190v.C2538c;

/* compiled from: PhoneService */
class aa implements Runnable {
    final /* synthetic */ z f19103a;

    aa(z zVar) {
        this.f19103a = zVar;
    }

    public void run() {
        Intent intent = new Intent();
        intent.setAction(this.f19103a.c);
        intent.setPackage(this.f19103a.b);
        this.f19103a.d.startService(intent);
        C2538c.c("PhoneService", new Object[]{"restart service:  " + this.f19103a.b + " action is " + this.f19103a.c});
        if (z.a(this.f19103a)) {
            PhoneService.a(this.f19103a.d, 1000);
            if (PhoneService.d(this.f19103a.d) != null) {
                PhoneService.d(this.f19103a.d);
                RemoteServiceMgr.reconnect();
                return;
            }
            return;
        }
        PhoneService.f(this.f19103a.d).postDelayed(this, PhoneService.e(this.f19103a.d));
    }
}
