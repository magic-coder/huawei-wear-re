package com.huawei.ui.main.stories.messagecenter.activity;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.pluginmessagecenter.a.g;
import java.util.List;

/* compiled from: MessageCenterActivity */
class C2415d implements IBaseResponseCallback {
    final /* synthetic */ int f8694a;
    final /* synthetic */ MessageCenterActivity f8695b;

    C2415d(MessageCenterActivity messageCenterActivity, int i) {
        this.f8695b = messageCenterActivity;
        this.f8694a = i;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0 && obj != null) {
            this.f8695b.f8686d = (List) obj;
            g.c("MessageCenterActivity", "onChange() getMessageList:" + this.f8695b.f8686d);
            if (this.f8695b.f8686d.size() <= 0) {
                this.f8695b.f8688f.sendEmptyMessage(1);
                return;
            }
            this.f8695b.runOnUiThread(new C2416e(this));
            this.f8695b.m12147b(this.f8695b.f8686d);
            g.c("MessageCenterActivity", "Leave onChange() flag: " + this.f8694a);
        }
    }
}
