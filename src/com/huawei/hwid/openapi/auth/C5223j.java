package com.huawei.hwid.openapi.auth;

import android.app.Dialog;
import java.util.TimerTask;

class C5223j extends TimerTask {
    final /* synthetic */ Dialog f18844a;
    final /* synthetic */ C5222i f18845b;

    C5223j(C5222i c5222i, Dialog dialog) {
        this.f18845b = c5222i;
        this.f18844a = dialog;
    }

    public void run() {
        this.f18845b.f18842f.post(new C5224k(this));
    }
}
