package com.huawei.pluginmessagecenter;

import com.huawei.hwbasemgr.IBaseResponseCallback;

/* compiled from: PluginMessageCenter */
class C5875o implements Runnable {
    final /* synthetic */ String f20150a;
    final /* synthetic */ String f20151b;
    final /* synthetic */ IBaseResponseCallback f20152c;
    final /* synthetic */ j f20153d;

    C5875o(j jVar, String str, String str2, IBaseResponseCallback iBaseResponseCallback) {
        this.f20153d = jVar;
        this.f20150a = str;
        this.f20151b = str2;
        this.f20152c = iBaseResponseCallback;
    }

    public void run() {
        String a = C5864c.m27047a(j.a(this.f20153d)).m27049a(this.f20150a, this.f20151b);
        if (this.f20152c != null) {
            this.f20152c.onResponse(0, a);
        }
    }
}
