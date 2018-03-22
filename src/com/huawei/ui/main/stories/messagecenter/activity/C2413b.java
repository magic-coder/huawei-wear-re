package com.huawei.ui.main.stories.messagecenter.activity;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.pluginmessagecenter.C1971j;
import com.huawei.pluginmessagecenter.a.g;
import java.util.List;

/* compiled from: MessageCenterActivity */
class C2413b implements IBaseResponseCallback {
    final /* synthetic */ MessageCenterActivity f8692a;

    C2413b(MessageCenterActivity messageCenterActivity) {
        this.f8692a = messageCenterActivity;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0 && obj != null) {
            List list = (List) obj;
            g.c("MessageCenterActivity", "messageCenterRunnable messageObjectList = " + list.toString());
            if (list.isEmpty()) {
                C1971j.m10236a(BaseApplication.m2632b()).m10241a();
                return;
            }
            this.f8692a.f8688f.sendMessage(this.f8692a.f8688f.obtainMessage(0, list));
            g.c("MessageCenterActivity", "Leave messageCenterRunnable!");
        }
    }
}
