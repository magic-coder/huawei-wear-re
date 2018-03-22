package com.huawei.ui.main.stories.messagecenter.activity;

import android.os.Handler;
import android.os.Message;
import com.huawei.p190v.C2538c;
import java.lang.ref.WeakReference;

/* compiled from: MessageCenterActivity */
class C2417f extends Handler {
    private final WeakReference<MessageCenterActivity> f8697a;

    public C2417f(MessageCenterActivity messageCenterActivity) {
        this.f8697a = new WeakReference(messageCenterActivity);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f8697a != null && this.f8697a.get() != null) {
            C2538c.m12677c("MessageCenterActivity", "weakActivity is null,return");
            switch (message.what) {
                case 0:
                    ((MessageCenterActivity) this.f8697a.get()).m12140a(message);
                    return;
                case 1:
                    ((MessageCenterActivity) this.f8697a.get()).m12151d();
                    ((MessageCenterActivity) this.f8697a.get()).m12144b();
                    return;
                case 2:
                    ((MessageCenterActivity) this.f8697a.get()).m12144b();
                    return;
                default:
                    return;
            }
        }
    }
}
