package com.huawei.hwdevicemgr.p073a;

import com.fenda.hwbracelet.p261d.C3597a;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.p190v.C2538c;

/* compiled from: HWDeviceMgr */
class C4990i implements C3597a {
    final /* synthetic */ C1023c f18073a;

    C4990i(C1023c cVar) {
        this.f18073a = cVar;
    }

    public void mo4602a(DeviceInfo deviceInfo) {
        C2538c.a("02", 0, "HWDeviceMgr", new Object[]{"Enter mAF500DeviceStateCallback()"});
        if (deviceInfo != null) {
            C2538c.a("02", 0, "HWDeviceMgr", new Object[]{"AF500 Device state = " + deviceInfo.getDeviceConnectState()});
            if (C1023c.f(this.f18073a) == null) {
                return;
            }
            if (C1023c.f(this.f18073a).m26564e()) {
                deviceInfo.setDeviceBTType(2);
                C1023c.n(this.f18073a).a(deviceInfo, r0);
                return;
            }
            C2538c.a("02", 0, "HWDeviceMgr", new Object[]{"AF500 device is invalid."});
        }
    }
}
