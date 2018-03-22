package com.huawei.p108n;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.n.c;
import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.j;
import java.util.List;
import java.util.concurrent.Executors;

/* compiled from: HWDeviceConfigManager */
class C5498e implements IBaseResponseCallback {
    final /* synthetic */ j f19391a;
    final /* synthetic */ DeviceInfo f19392b;
    final /* synthetic */ c f19393c;

    C5498e(c cVar, j jVar, DeviceInfo deviceInfo) {
        this.f19393c = cVar;
        this.f19391a = jVar;
        this.f19392b = deviceInfo;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0) {
            C2538c.c("HWDeviceConfigManager", new Object[]{"generateConnectedMessage, delete messageList, messageList.size() = " + ((List) obj).size()});
            Executors.newSingleThreadExecutor().execute(new C5499f(this, r7));
        }
    }
}
