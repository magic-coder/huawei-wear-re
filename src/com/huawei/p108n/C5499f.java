package com.huawei.p108n;

import com.huawei.pluginmessagecenter.provider.data.MessageObject;
import com.huawei.p190v.C2538c;
import java.util.List;

/* compiled from: HWDeviceConfigManager */
class C5499f implements Runnable {
    final /* synthetic */ List f19394a;
    final /* synthetic */ C5498e f19395b;

    C5499f(C5498e c5498e, List list) {
        this.f19395b = c5498e;
        this.f19394a = list;
    }

    public void run() {
        for (int i = 0; i < this.f19394a.size(); i++) {
            this.f19395b.f19391a.b(((MessageObject) this.f19394a.get(i)).getMsgId());
        }
        if (-2 == this.f19395b.f19392b.getProductType() || this.f19395b.f19392b.getProductType() == 0 || 2 == this.f19395b.f19392b.getProductType() || 4 == this.f19395b.f19392b.getProductType() || -1 == this.f19395b.f19392b.getProductType() || 9 == this.f19395b.f19392b.getProductType()) {
            C2538c.c("HWDeviceConfigManager", new Object[]{"generateConnectedMessage, W1,B1,AF500 don't need generate message..."});
            return;
        }
        C2538c.c("HWDeviceConfigManager", new Object[]{"generateConnectedMessage, getDeviceIdentify() = " + this.f19395b.f19392b.getDeviceIdentify(), ", getSharedPreference deviceIdentify = " + this.f19395b.f19393c.getSharedPreference("kStorage_DeviceCfgMgr_Identify")});
        if (this.f19395b.f19392b.getDeviceIdentify().equalsIgnoreCase(this.f19395b.f19393c.getSharedPreference("kStorage_DeviceCfgMgr_Identify"))) {
            C2538c.c("HWDeviceConfigManager", new Object[]{"generateConnectedMessage, same device, don't need generate message..."});
            return;
        }
        this.f19395b.f19393c.setSharedPreference("kStorage_DeviceCfgMgr_Identify", this.f19395b.f19392b.getDeviceIdentify(), null);
        this.f19395b.f19391a.a("device", "device_type_connected", new C5500g(this));
    }
}
