package com.huawei.ui.main.stories.nps.activity;

import android.os.Handler;
import android.os.Message;

/* compiled from: SingleFragment */
class C2439n extends Handler {
    final /* synthetic */ C2438m f8780a;

    C2439n(C2438m c2438m) {
        this.f8780a = c2438m;
    }

    public void handleMessage(Message message) {
        this.f8780a.f8773d.setItemChecked(message.what, true);
        this.f8780a.m12222a();
        super.handleMessage(message);
    }
}
