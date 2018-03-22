package com.huawei.ui.device.p170a;

import com.huawei.datatype.DataDeviceInfo;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.datatypes.j;
import com.huawei.p190v.C2538c;

/* compiled from: DeviceInteractors */
class C1989q implements IBaseResponseCallback {
    final /* synthetic */ C1988p f6942a;

    C1989q(C1988p c1988p) {
        this.f6942a = c1988p;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c("DeviceInteractors", "initNpsRequestDeviceInfo getFirmwareVersion onResponse err_code = " + i);
        if (i == 0 && obj != null) {
            j.c(((DataDeviceInfo) obj).getDevice_soft_version());
            C2538c.m12677c("DeviceInteractors", "initNpsRequestDeviceInfo FIEMWARE : " + r8.getDevice_soft_version());
        }
    }
}
