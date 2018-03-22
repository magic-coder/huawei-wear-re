package com.huawei.ui.main.stories.about.p179a;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.login.ui.login.util.c;
import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.provider.data.MessageObject;
import com.huawei.ui.main.j;

/* compiled from: AppUpdateInteractor */
class C2281c implements IBaseResponseCallback {
    final /* synthetic */ C2280b f8282a;

    C2281c(C2280b c2280b) {
        this.f8282a = c2280b;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0 && obj != null && (obj instanceof String)) {
            String str = (String) obj;
            MessageObject messageObject = new MessageObject();
            messageObject.setMsgId(str);
            messageObject.setModule("device");
            messageObject.setType("device_app_update");
            messageObject.setMsgType(1);
            messageObject.setPosition(this.f8282a.f8279b);
            messageObject.setMsgPosition(11);
            messageObject.setHuid(c.a(this.f8282a.f8280c).c());
            messageObject.setMsgContent("");
            C2538c.m12677c("AppUpdateInteractor", "app update contentStr = " + "");
            messageObject.setMsgTitle(this.f8282a.f8280c.getString(j.IDS_messagecenter_device_app_new_version_title));
            C2538c.m12677c("AppUpdateInteractor", "app update mstTitle = " + r1);
            messageObject.setCreateTime(System.currentTimeMillis());
            if (this.f8282a.f8281d.m11725l()) {
                messageObject.setDetailUri("messagecenter://device_app_update");
            } else {
                messageObject.setDetailUri("messagecenter://device_app_update_health");
            }
            messageObject.setImgUri("assets://localMessageIcon/ic_update.png");
            this.f8282a.f8278a.m10243a(messageObject);
        }
    }
}
