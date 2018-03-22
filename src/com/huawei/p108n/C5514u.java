package com.huawei.p108n;

import com.huawei.datatype.DataDeviceAvoidDisturbInfo;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.datatypes.DeviceCapability;
import com.huawei.n.c;
import com.huawei.p190v.C2538c;

import java.util.List;

/* compiled from: HWDeviceConfigManager */
class C5514u implements IBaseResponseCallback {
    final /* synthetic */ DeviceCapability f19421a;
    final /* synthetic */ c f19422b;

    C5514u(c cVar, DeviceCapability deviceCapability) {
        this.f19422b = cVar;
        this.f19421a = deviceCapability;
    }

    public void onResponse(int i, Object obj) {
        List list = (List) obj;
        if (list.size() == 0) {
            list.add(new DataDeviceAvoidDisturbInfo());
        }
        if (this.f19421a.isAvoid_disturb()) {
            this.f19422b.a(list, c.a(this.f19422b), true);
            return;
        }
        C2538c.e("HWDeviceConfigManager", new Object[]{"autoSendCommend() not Support Avoid_disturb"});
    }
}
