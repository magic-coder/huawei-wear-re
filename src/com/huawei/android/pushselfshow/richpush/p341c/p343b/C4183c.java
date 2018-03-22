package com.huawei.android.pushselfshow.richpush.p341c.p343b;

import com.huawei.android.pushagent.c.a.e;

class C4183c implements C4182d {
    boolean f15743a = true;
    final Runnable f15744b = new C4185f(this);
    final /* synthetic */ C4181b f15745c;

    C4183c(C4181b c4181b) {
        this.f15745c = c4181b;
        e.a("PushSelfShowLog", "OnlineEventsBridgeMode() the webview is " + c4181b.f15738a);
        c4181b.f15738a.setNetworkAvailable(true);
    }

    public void mo4387a() {
        this.f15745c.f15741d.runOnUiThread(this.f15744b);
    }
}
