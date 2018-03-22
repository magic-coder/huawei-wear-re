package com.huawei.ui.homewear21.p175a;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.C1971j;
import com.huawei.pluginmessagecenter.provider.data.MessageObject;
import java.util.List;

/* compiled from: HomeFragment */
class C2237u implements IBaseResponseCallback {
    final /* synthetic */ C1971j f8152a;
    final /* synthetic */ C2217a f8153b;

    C2237u(C2217a c2217a, C1971j c1971j) {
        this.f8153b = c2217a;
        this.f8152a = c1971j;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0 && obj != null) {
            List list = (List) obj;
            C2538c.m12661a("MainUI", 0, "HomeFragment", "clearMessageCenterLocalDeviceMessage, delete 2222 device DEVICE_OTA otaMessageList, otaMessageList.size() = " + list.size());
            for (int i2 = 0; i2 < list.size(); i2++) {
                this.f8152a.m10252b(((MessageObject) list.get(i2)).getMsgId());
            }
            C2538c.m12661a("MainUI", 0, "HomeFragment", "Leave clearMessageCenterLocalDeviceMessage");
        }
    }
}
