package com.huawei.ui.device.p170a;

import com.huawei.hwlocationmgr.a.a;
import com.huawei.hwlocationmgr.util.HWLocation;
import com.huawei.p190v.C2538c;

/* compiled from: DeviceSettingsInteractors */
class C1992t implements a {
    final /* synthetic */ C1990r f6956a;

    C1992t(C1990r c1990r) {
        this.f6956a = c1990r;
    }

    public void m10452a(HWLocation hWLocation) {
        C2538c.m12677c("DeviceSettingsInteractors", "ILocationResultCallback onLocationChanged");
        this.f6956a.f6952j.removeMessages(1);
        if (hWLocation != null) {
            this.f6956a.m10401a(hWLocation);
        }
        this.f6956a.m10408p();
    }

    public void m10451a(int i, String str) {
        C2538c.m12677c("DeviceSettingsInteractors", "ILocationResultCallback onFailed errCode=" + i + ", err_msg=" + str);
        this.f6956a.f6952j.removeMessages(1);
        this.f6956a.m10408p();
    }
}
