package com.huawei.multisimservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.huawei.multisimservice.model.C1120a;
import com.huawei.multisimservice.model.C1200d;
import com.huawei.p190v.C2538c;
import com.huawei.p192w.C2546c;

public class MultiSimService extends Service {
    C1200d f2607a = null;
    C1120a f2608b = null;
    private String f2609c = "";
    private final C1194g f2610d = new C1196i(this);
    private final C1189b f2611e = new C1197j(this);
    private final C1192e f2612f = new C1198k(this);

    public MultiSimService() {
        C2538c.m12677c("MultiSimService", "MultiSimService construct");
    }

    public IBinder onBind(Intent intent) {
        C2538c.m12677c("MultiSimService", "onBind service ");
        return this.f2610d;
    }

    public boolean onUnbind(Intent intent) {
        boolean onUnbind = super.onUnbind(intent);
        this.f2609c = "";
        return onUnbind;
    }

    private void m5306a() {
        C2538c.m12677c("MultiSimService", "getDeviceInfoAndAuth with app:", this.f2609c);
        C2546c a = C2546c.m12702a();
        if (a == null) {
            C2538c.m12680e("MultiSimService", "getDeviceInfoAndAuth  get HWMultiSimMgr null");
            return;
        }
        a.m12751c(this.f2609c);
        if (this.f2608b != null) {
            a.m12735a(this.f2608b);
        } else if (this.f2607a != null) {
            a.m12736a(this.f2607a);
        }
        a.m12744b();
    }
}
