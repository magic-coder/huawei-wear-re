package com.huawei.hwdevicemgr.p073a;

import com.huawei.hwbtsdk.p057b.p058a.C4620b;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.List;

/* compiled from: HWDeviceMgr */
class C4989h implements C4620b {
    final /* synthetic */ C1023c f18072a;

    C4989h(C1023c cVar) {
        this.f18072a = cVar;
    }

    public void mo4601a(String str) {
        C2538c.a("02", 0, "HWDeviceMgr", new Object[]{"Enter onBTDeviceBondNone()."});
        if (-1 != C1023c.a(this.f18072a, str)) {
            C2538c.a("02", 0, "HWDeviceMgr", new Object[]{"Need to remove device."});
            List arrayList = new ArrayList();
            for (DeviceInfo deviceInfo : C1023c.a(this.f18072a)) {
                if (!deviceInfo.getDeviceIdentify().equalsIgnoreCase(str)) {
                    arrayList.add(C1023c.c(this.f18072a, deviceInfo));
                } else if (2 == deviceInfo.getDeviceBTType()) {
                    return;
                }
            }
            this.f18072a.a(arrayList, false);
        }
    }
}
