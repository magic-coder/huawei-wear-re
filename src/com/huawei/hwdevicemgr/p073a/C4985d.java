package com.huawei.hwdevicemgr.p073a;

import com.google.gson.Gson;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwdataaccessmodel.sharedpreference.a;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.h;
import com.huawei.p190v.C2538c;

/* compiled from: HWDeviceMgr */
class C4985d implements Runnable {
    final /* synthetic */ C1023c f18068a;

    C4985d(C1023c cVar) {
        this.f18068a = cVar;
    }

    public void run() {
        if (C1023c.a(this.f18068a) != null) {
            a.c(C1023c.b(this.f18068a), String.valueOf(1000));
            synchronized (C1023c.c(this.f18068a)) {
                for (DeviceInfo deviceInfo : C1023c.a(this.f18068a)) {
                    a.a(C1023c.b(this.f18068a), String.valueOf(1000), deviceInfo.getDeviceIdentify(), new Gson().toJson(deviceInfo), new com.huawei.hwdataaccessmodel.a.c());
                }
            }
            if (C1023c.a(this.f18068a).size() == 0) {
                C2538c.a("02", 0, "HWDeviceMgr", new Object[]{"update has device db info with 0."});
                h.a(false);
                return;
            }
            C2538c.a("02", 0, "HWDeviceMgr", new Object[]{"update has device db info with 1."});
            h.a(true);
        }
    }
}
