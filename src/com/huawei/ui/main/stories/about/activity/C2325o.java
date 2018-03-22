package com.huawei.ui.main.stories.about.activity;

import com.huawei.p190v.C2538c;
import com.huawei.ui.main.j;

/* compiled from: AboutActivity */
class C2325o implements Runnable {
    final /* synthetic */ C2324n f8414a;

    C2325o(C2324n c2324n) {
        this.f8414a = c2324n;
    }

    public void run() {
        C2538c.m12674b("AboutActivity", "wifi 断开");
        this.f8414a.f8413b.f8303D.removeMessages(0);
        if (this.f8414a.f8413b.f8302C != null && this.f8414a.f8413b.f8302C.isShowing()) {
            this.f8414a.f8413b.m11794a(j.IDS_hw_show_log_upload_failed);
        }
        this.f8414a.f8413b.m11789i();
    }
}
