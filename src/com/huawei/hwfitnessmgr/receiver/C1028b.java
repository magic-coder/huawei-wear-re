package com.huawei.hwfitnessmgr.receiver;

import android.content.Context;
import com.huawei.ab.C0630m;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.login.ui.login.C1093a;

/* compiled from: SendDataToDeviceBroadcastReceiver */
class C1028b implements Runnable {
    final /* synthetic */ Context f1915a;
    final /* synthetic */ SendDataToDeviceBroadcastReceiver f1916b;

    C1028b(SendDataToDeviceBroadcastReceiver sendDataToDeviceBroadcastReceiver, Context context) {
        this.f1916b = sendDataToDeviceBroadcastReceiver;
        this.f1915a = context;
    }

    public void run() {
        int b = C1093a.m4739a(BaseApplication.m2632b()).m4749b();
        boolean z = (b == 0 || b == -1) ? false : true;
        if (!C0630m.m2297a(this.f1915a).m2320e() || z) {
            C0630m.m2297a(this.f1915a).m2307a(new d(this), true, true, new int[0]);
        } else {
            C0630m.m2297a(this.f1915a).m2305a(this.f1915a, new c(this));
        }
    }
}
