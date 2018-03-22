package com.huawei.ui.homewear21.p175a;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonmodel.p062a.C0972a;
import com.huawei.p190v.C2538c;

/* compiled from: HomeFragment */
class bw implements IBaseResponseCallback {
    final /* synthetic */ C2217a f8096a;

    bw(C2217a c2217a) {
        this.f8096a = c2217a;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "pariedDevicesSwitcher err_code:" + i + "  objData:" + obj);
        if (100 == i) {
            DeviceInfo deviceInfo = (DeviceInfo) obj;
            C0972a.m3501a(deviceInfo);
            this.f8096a.f8019d.m11687a(new DeviceInfo[0]);
            this.f8096a.m11485b(deviceInfo);
            this.f8096a.bc();
        } else if (101 == i) {
            this.f8096a.az();
        } else if (102 == i) {
            this.f8096a.bm();
        }
    }
}
