package com.huawei.pluginkidwatch.common.ui.button;

import android.os.Handler;
import android.os.Message;
import com.huawei.p190v.C2538c;

/* compiled from: SwitchButtonAnimation */
class C1519h extends Handler {
    private C1519h() {
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1000:
                if (message.obj != null) {
                    ((Runnable) message.obj).run();
                    return;
                }
                return;
            default:
                C2538c.m12674b("SwitchButtonAnimation", "Animation Control:", "Message type:" + message.what);
                return;
        }
    }
}
