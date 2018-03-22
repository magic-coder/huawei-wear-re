package com.huawei.hwbtsdk.btmanager;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.huawei.ae.C3989b;
import com.huawei.hwbtsdk.p399a.C4610m;
import com.huawei.p190v.C2538c;

/* compiled from: BTDeviceSendCommandUtil */
class C4652l implements ServiceConnection {
    final /* synthetic */ C4648h f17047a;

    C4652l(C4648h c4648h) {
        this.f17047a = c4648h;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        C2538c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"iconnect service connected so start to set service handle ."});
        if (iBinder != null) {
            C4610m.m21971a(C3989b.m19743a(iBinder));
            return;
        }
        C2538c.b("01", 1, "BTDeviceSendCommandUtil", new Object[]{"service is null."});
        C4610m.m21971a(null);
    }

    public void onServiceDisconnected(ComponentName componentName) {
        C2538c.b("01", 1, "BTDeviceSendCommandUtil", new Object[]{"iconnect service disconnect so start to set service handle is null."});
        C4610m.m21971a(null);
    }
}
