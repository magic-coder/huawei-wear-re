package com.huawei.ui.device.activity.selectcontact;

import android.os.Handler;
import android.os.Message;

/* compiled from: ContactOrderbyActivity */
class C2150k extends Handler {
    final /* synthetic */ ContactOrderbyActivity f7611a;

    C2150k(ContactOrderbyActivity contactOrderbyActivity) {
        this.f7611a = contactOrderbyActivity;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                this.f7611a.m11027d();
                return;
            case 2:
                this.f7611a.m11028e();
                return;
            default:
                return;
        }
    }
}
