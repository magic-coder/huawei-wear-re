package com.huawei.hms.update.p050e;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/* compiled from: SilentUpdateWizard */
class C0945p extends Handler {
    final /* synthetic */ C0944o f1532a;

    C0945p(C0944o c0944o) {
        this.f1532a = c0944o;
    }

    public void handleMessage(Message message) {
        Bundle bundle = (Bundle) message.obj;
        switch (message.what) {
            case 101:
                this.f1532a.m3244a(bundle);
                return;
            case 102:
                this.f1532a.m3251b(bundle);
                return;
            case 103:
                this.f1532a.m3254c(bundle);
                return;
            default:
                return;
        }
    }
}
