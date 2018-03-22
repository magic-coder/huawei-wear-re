package com.huawei.pluginaf500.ui;

import android.os.Handler;
import android.os.Message;

/* compiled from: FindPhoneActivity */
class aj extends Handler {
    final /* synthetic */ FindPhoneActivity f19885a;

    aj(FindPhoneActivity findPhoneActivity) {
        this.f19885a = findPhoneActivity;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1000:
                this.f19885a.mo5115j();
                this.f19885a.finish();
                return;
            default:
                return;
        }
    }
}
