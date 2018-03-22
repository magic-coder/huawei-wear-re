package com.huawei.ui.main.stories.nps.interactors;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.login.ui.login.C1093a;
import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.provider.data.MessageObject;
import com.huawei.ui.main.j;

/* compiled from: HWNPSManager */
class C2451g implements IBaseResponseCallback {
    final /* synthetic */ C2442a f8817a;

    C2451g(C2442a c2442a) {
        this.f8817a = c2442a;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0 && obj != null && (obj instanceof String)) {
            String str = (String) obj;
            MessageObject messageObject = new MessageObject();
            messageObject.setMsgId(str);
            messageObject.setModule("nps");
            messageObject.setType("nps_type_message");
            messageObject.setMsgType(2);
            messageObject.setPosition(1);
            messageObject.setMsgPosition(11);
            messageObject.setMsgContent(this.f8817a.f8786b.getString(j.IDS_nps_success_message_2));
            C2538c.m12677c(this.f8817a.f8785a, "nps generateNpsMessage contentStr = " + r1);
            messageObject.setMsgTitle(this.f8817a.f8786b.getString(j.IDS_messagecenter_nps_title));
            C2538c.m12677c(this.f8817a.f8785a, "nps generateNpsMessage mstTitle = " + r1);
            messageObject.setCreateTime(System.currentTimeMillis());
            messageObject.setDetailUri("messagecenter://nps_question");
            messageObject.setImgUri("assets://localMessageIcon/ic_investigation.png");
            if (C1093a.m4739a(BaseApplication.m2632b()) != null) {
                messageObject.setHuid(C1093a.m4739a(BaseApplication.m2632b()).m4750c());
            }
            this.f8817a.f8807y.m10243a(messageObject);
            C2538c.m12677c(this.f8817a.f8785a, "nps Leave generateNpsMessage !!!");
        }
    }
}
