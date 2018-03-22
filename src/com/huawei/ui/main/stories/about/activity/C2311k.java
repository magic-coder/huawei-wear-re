package com.huawei.ui.main.stories.about.activity;

import com.huawei.ui.main.j;

/* compiled from: AboutActivity */
class C2311k implements Runnable {
    final /* synthetic */ C2309i f8372a;

    C2311k(C2309i c2309i) {
        this.f8372a = c2309i;
    }

    public void run() {
        if (this.f8372a.f8370a.f8302C != null && this.f8372a.f8370a.f8302C.isShowing()) {
            this.f8372a.f8370a.m11789i();
            this.f8372a.f8370a.m11794a(j.IDS_hw_show_log_bt_disconnect);
        }
        this.f8372a.f8370a.f8330w.m11765a(false);
    }
}
