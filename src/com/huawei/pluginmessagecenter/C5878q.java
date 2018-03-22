package com.huawei.pluginmessagecenter;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import java.util.List;

/* compiled from: PluginMessageCenter */
class C5878q implements Runnable {
    final /* synthetic */ String f20160a;
    final /* synthetic */ String f20161b;
    final /* synthetic */ IBaseResponseCallback f20162c;
    final /* synthetic */ j f20163d;

    C5878q(j jVar, String str, String str2, IBaseResponseCallback iBaseResponseCallback) {
        this.f20163d = jVar;
        this.f20160a = str;
        this.f20161b = str2;
        this.f20162c = iBaseResponseCallback;
    }

    public void run() {
        List b = C5862a.m27025a(j.a(this.f20163d)).m27042b(this.f20160a, this.f20161b);
        if (this.f20162c != null) {
            this.f20162c.onResponse(0, b);
        }
    }
}
