package com.huawei.pluginaf500.ui;

import android.os.Handler;
import android.os.Message;

/* compiled from: AF500BaseActivity */
class C5792a extends Handler {
    final /* synthetic */ AF500BaseActivity f19870a;

    C5792a(AF500BaseActivity aF500BaseActivity) {
        this.f19870a = aF500BaseActivity;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        this.f19870a.mo5112a(message);
    }
}
