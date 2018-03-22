package com.huawei.pluginmessagecenter;

import com.huawei.hwbasemgr.IBaseResponseCallback;

/* compiled from: PluginMessageCenter */
class C5882u implements Runnable {
    final /* synthetic */ String f20170a;
    final /* synthetic */ IBaseResponseCallback f20171b;
    final /* synthetic */ j f20172c;

    C5882u(j jVar, String str, IBaseResponseCallback iBaseResponseCallback) {
        this.f20172c = jVar;
        this.f20170a = str;
        this.f20171b = iBaseResponseCallback;
    }

    public void run() {
        int a = C5862a.m27025a(j.a(this.f20172c)).m27035a(this.f20170a);
        if (this.f20171b != null) {
            boolean z;
            IBaseResponseCallback iBaseResponseCallback = this.f20171b;
            if (a == 0) {
                z = true;
            } else {
                z = false;
            }
            iBaseResponseCallback.onResponse(0, Boolean.valueOf(z));
        }
    }
}
