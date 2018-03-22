package com.huawei.pluginmessagecenter;

import com.huawei.hwbasemgr.IBaseResponseCallback;

/* compiled from: PluginMessageCenter */
class C5883v implements Runnable {
    final /* synthetic */ IBaseResponseCallback f20173a;
    final /* synthetic */ j f20174b;

    C5883v(j jVar, IBaseResponseCallback iBaseResponseCallback) {
        this.f20174b = jVar;
        this.f20173a = iBaseResponseCallback;
    }

    public void run() {
        boolean a = C5862a.m27025a(j.a(this.f20174b)).m27039a();
        if (this.f20173a != null) {
            this.f20173a.onResponse(0, Boolean.valueOf(a));
        }
    }
}
