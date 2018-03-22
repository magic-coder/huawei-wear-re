package com.tencent.connect.p193b;

import com.tencent.open.p532d.C6406s;
import com.tencent.tauth.C6252b;

/* compiled from: ProGuard */
class C6264b implements Runnable {
    final /* synthetic */ String f21791a;
    final /* synthetic */ C6252b f21792b;
    final /* synthetic */ C6263a f21793c;

    C6264b(C6263a c6263a, String str, C6252b c6252b) {
        this.f21793c = c6263a;
        this.f21791a = str;
        this.f21792b = c6252b;
    }

    public void run() {
        C6406s.m29222a("libwbsafeedit", "libwbsafeedit.so", 2);
        if (this.f21793c.f21790m != null) {
            this.f21793c.f21790m.runOnUiThread(new C6265c(this));
        }
    }
}
