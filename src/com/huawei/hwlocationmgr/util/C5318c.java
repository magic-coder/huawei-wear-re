package com.huawei.hwlocationmgr.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: LocationMgrUtil */
class C5318c extends Handler {
    final /* synthetic */ C5316a f19045a;

    public C5318c(C5316a c5316a, Looper looper) {
        this.f19045a = c5316a;
        super(looper);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                if (this.f19045a.f19039n) {
                    this.f19045a.m25726i();
                    return;
                } else {
                    this.f19045a.m25705a(message.arg1);
                    return;
                }
            case 2:
                if (this.f19045a.f19039n) {
                    this.f19045a.m25727j();
                } else {
                    this.f19045a.m25704a();
                }
                this.f19045a.f19044s = false;
                return;
            default:
                return;
        }
    }
}
