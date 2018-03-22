package com.huawei.ui.main.stories.settings.p185a;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.login.ui.login.C1093a;
import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.provider.data.MessageObject;

/* compiled from: PersonalPrivacySettingsInteractors */
class C2461b implements IBaseResponseCallback {
    final /* synthetic */ String f8839a;
    final /* synthetic */ C2460a f8840b;

    C2461b(C2460a c2460a, String str) {
        this.f8840b = c2460a;
        this.f8839a = str;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0 && obj != null && (obj instanceof String)) {
            String str = (String) obj;
            C2538c.m12677c(C2460a.f8834a, "deletePersonalPrivacyMessage... messageID = " + str + ", messageType = " + this.f8839a);
            MessageObject messageObject = new MessageObject();
            messageObject.setMsgId(str);
            messageObject.setModule("special");
            messageObject.setType(this.f8839a);
            messageObject.setMsgType(1);
            messageObject.setPosition(1);
            messageObject.setMsgPosition(11);
            messageObject.setMsgTitle(this.f8840b.m12290a(this.f8839a));
            messageObject.setCreateTime(System.currentTimeMillis());
            messageObject.setDetailUri("messagecenter://special_person_setting");
            messageObject.setImgUri("assets://localMessageIcon/ic_question.png");
            if (C1093a.m4739a(BaseApplication.m2632b()) != null) {
                messageObject.setHuid(C1093a.m4739a(BaseApplication.m2632b()).m4750c());
            }
            this.f8840b.f8837d.m10244a(messageObject, new C2462c(this));
        }
    }
}
