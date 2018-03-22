package com.huawei.ui.device.p170a;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.login.ui.login.util.c;
import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.provider.data.MessageObject;
import com.huawei.ui.device.i;

/* compiled from: UpdateInteractors */
class ao implements IBaseResponseCallback {
    final /* synthetic */ an f6892a;

    ao(an anVar) {
        this.f6892a = anVar;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c("UpdateInteractors", "getEventAlarm() err_code = " + i);
        if (i == 0 && obj != null && (obj instanceof String)) {
            C2538c.m12677c("UpdateInteractors", "generateConnectedMessage messageID = " + ((String) obj));
            MessageObject messageObject = new MessageObject();
            messageObject.setMsgId(r10);
            messageObject.setModule("device");
            messageObject.setType("device_ota");
            messageObject.setMsgType(2);
            messageObject.setPosition(this.f6892a.f6890b);
            messageObject.setHuid(c.a(this.f6892a.f6891c.f6878m).c());
            messageObject.setMsgTitle(String.format(this.f6892a.f6891c.f6878m.getString(i.IDS_messagecenter_device_need_upgrade_title), new Object[]{this.f6892a.f6891c.f6874i}));
            C2538c.m12677c("UpdateInteractors", "generateConnectedMessage mstTitle = " + r1);
            messageObject.setMsgContent("");
            C2538c.m12677c("UpdateInteractors", "generateConnectedMessage mstContent = " + "");
            messageObject.setCreateTime(System.currentTimeMillis());
            messageObject.setDetailUri("messagecenter://device_ota");
            switch (this.f6892a.f6891c.f6871f) {
                case 3:
                    messageObject.setImgUri("assets://localMessageIcon/ic_watch_update.png");
                    break;
                default:
                    messageObject.setImgUri("assets://localMessageIcon/ic_band_update.png");
                    break;
            }
            this.f6892a.f6889a.m10243a(messageObject);
            C2538c.m12677c("UpdateInteractors", "generateConnectedMessage leave");
        }
    }
}
