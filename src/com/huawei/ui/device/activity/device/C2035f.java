package com.huawei.ui.device.activity.device;

import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.p190v.C2538c;
import com.huawei.ui.device.p170a.C1988p;

/* compiled from: DeviceManagerListActivity */
class C2035f implements Runnable {
    final /* synthetic */ DeviceManagerListActivity f7141a;

    C2035f(DeviceManagerListActivity deviceManagerListActivity) {
        this.f7141a = deviceManagerListActivity;
    }

    public void run() {
        DeviceInfo a = C1988p.m10381a(BaseApplication.m2632b()).m10384a();
        if (a != null) {
            C2538c.m12677c("DeviceManagerListActivity", "onStart(), currentDeviceInfo :" + a.toString());
            if (2 == a.getDeviceConnectState()) {
                C2538c.m12677c("DeviceManagerListActivity", "onStart(), getDeviceBattery once more");
                C1988p.m10381a(BaseApplication.m2632b()).m10387a(this.f7141a.f7113b);
                return;
            }
            return;
        }
        C2538c.m12679d("DeviceManagerListActivity", "currentDeviceInfo is null!");
    }
}
