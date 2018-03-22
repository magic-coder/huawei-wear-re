package com.huawei.p108n;

import android.text.TextUtils;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwdevicemgr.d;
import com.huawei.login.ui.login.util.C5433c;
import com.huawei.pluginmessagecenter.provider.data.MessageObject;
import com.huawei.p190v.C2538c;

/* compiled from: HWDeviceConfigManager */
class C5500g implements IBaseResponseCallback {
    final /* synthetic */ C5499f f19396a;

    C5500g(C5499f c5499f) {
        this.f19396a = c5499f;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0 && obj != null && (obj instanceof String)) {
            C2538c.c("HWDeviceConfigManager", new Object[]{"generateConnectedMessage messageID = " + ((String) obj)});
            MessageObject messageObject = new MessageObject();
            messageObject.setMsgId(r10);
            messageObject.setModule("device");
            messageObject.setType("device_type_connected");
            messageObject.setMsgType(2);
            messageObject.setPosition(1);
            messageObject.setMsgPosition(11);
            messageObject.setHuid(C5433c.m26039a(com.huawei.n.c.h(this.f19396a.f19395b.f19393c)).m26051c());
            String string = com.huawei.n.c.h(this.f19396a.f19395b.f19393c).getString(d.IDS_messagecenter_device_bind_success_title);
            CharSequence deviceName = this.f19396a.f19395b.f19392b.getDeviceName();
            if (TextUtils.isEmpty(deviceName) && this.f19396a.f19395b.f19393c.c() != null) {
                deviceName = this.f19396a.f19395b.f19393c.c().getDeviceName();
            }
            if (TextUtils.isEmpty(deviceName)) {
                deviceName = "";
            }
            messageObject.setMsgTitle(String.format(string, new Object[]{deviceName}));
            C2538c.c("HWDeviceConfigManager", new Object[]{"generateConnectedMessage mstTitle = " + r0});
            messageObject.setMsgContent("");
            C2538c.c("HWDeviceConfigManager", new Object[]{"generateConnectedMessage mstContent = " + ""});
            long currentTimeMillis = System.currentTimeMillis();
            messageObject.setCreateTime(currentTimeMillis);
            messageObject.setExpireTime(currentTimeMillis + 86400000);
            messageObject.setDetailUri("messagecenter://device_guide");
            messageObject.setImgUri("assets://localMessageIcon/ic_band_connected.png");
            this.f19396a.f19395b.f19391a.a(messageObject);
            C2538c.c("HWDeviceConfigManager", new Object[]{"generateConnectedMessage leave"});
        }
    }
}
