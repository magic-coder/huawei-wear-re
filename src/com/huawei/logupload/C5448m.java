package com.huawei.logupload;

import com.huawei.logupload.c.h;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: UploadRequest */
class C5448m extends TimerTask {
    private final /* synthetic */ Timer f19281a;
    private final /* synthetic */ LogUpload f19282b;

    C5448m(Timer timer, LogUpload logUpload) {
        this.f19281a = timer;
        this.f19282b = logUpload;
    }

    public void run() {
        this.f19281a.cancel();
        this.f19282b.f(true);
        h.a(new StringBuilder(String.valueOf(this.f19282b.f())).toString(), 1);
        k.b(this.f19282b);
    }
}
