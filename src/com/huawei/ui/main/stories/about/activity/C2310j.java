package com.huawei.ui.main.stories.about.activity;

import android.os.Message;
import com.huawei.ui.main.j;

/* compiled from: AboutActivity */
class C2310j implements Runnable {
    final /* synthetic */ C2309i f8371a;

    C2310j(C2309i c2309i) {
        this.f8371a = c2309i;
    }

    public void run() {
        if (this.f8371a.f8370a.f8302C != null && this.f8371a.f8370a.f8302C.isShowing()) {
            this.f8371a.f8370a.m11773b(this.f8371a.f8370a.getString(j.IDS_hw_show_log_upload_progress));
        }
        this.f8371a.f8370a.f8330w.m11765a(false);
        Message obtain = Message.obtain();
        obtain.what = 0;
        this.f8371a.f8370a.f8303D.sendMessageDelayed(obtain, 600000);
    }
}
