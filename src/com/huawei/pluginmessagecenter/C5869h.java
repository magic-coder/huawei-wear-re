package com.huawei.pluginmessagecenter;

import android.os.Handler;
import android.os.Message;
import com.huawei.pluginmessagecenter.p499a.C5861g;

/* compiled from: MessagePushReceiver */
class C5869h extends Handler {
    final /* synthetic */ C5867f f20143a;

    C5869h(C5867f c5867f) {
        this.f20143a = c5867f;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message != null) {
            C5861g.m27024c("MessagePushReceiver", "mHandler=============msg.obj");
            if (message.obj instanceof C5885y) {
                this.f20143a.f20138a = (C5885y) message.obj;
            }
            switch (message.what) {
                case 1:
                    C5861g.m27024c("MessagePushReceiver", "mHandler=============REMOVE_SUCCESS");
                    if (this.f20143a.f20138a != null) {
                        C5861g.m27024c("MessagePushReceiver", "mHandler=============REMOVE_SUCCESS mRemovePushTokenCallBack");
                        C5861g.m27024c("MessagePushReceiver", "mHandler=============REMOVE_SUCCESS RESULT_CODE0");
                        this.f20143a.f20138a.m27077a(0);
                        return;
                    }
                    return;
                case 2:
                    C5861g.m27024c("MessagePushReceiver", "mHandler=============REMOVE_FAILED");
                    if (this.f20143a.f20138a != null) {
                        C5861g.m27024c("MessagePushReceiver", "mHandler=============REMOVE_FAILED mRemovePushTokenCallBack");
                        C5861g.m27024c("MessagePushReceiver", "mHandler=============REMOVE_FAILED RESULT_CODE" + C5867f.f20136b);
                        this.f20143a.f20138a.m27077a(C5867f.f20136b);
                        return;
                    }
                    return;
                default:
                    C5861g.m27024c("MessagePushReceiver", "mHandler=============RESULT_CODE" + message.what);
                    return;
            }
        }
    }
}
