package com.huawei.pluginmessagecenter;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.pluginmessagecenter.provider.data.MessageObject;

/* compiled from: PluginMessageCenter */
class C5876p implements Runnable {
    final /* synthetic */ MessageObject f20154a;
    final /* synthetic */ IBaseResponseCallback f20155b;
    final /* synthetic */ j f20156c;

    C5876p(j jVar, MessageObject messageObject, IBaseResponseCallback iBaseResponseCallback) {
        this.f20156c = jVar;
        this.f20154a = messageObject;
        this.f20155b = iBaseResponseCallback;
    }

    public void run() {
        boolean a = C5864c.m27047a(j.a(this.f20156c)).m27050a(this.f20154a);
        if (this.f20155b != null) {
            this.f20155b.onResponse(0, Boolean.valueOf(a));
        }
    }
}
