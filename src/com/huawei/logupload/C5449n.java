package com.huawei.logupload;

import com.huawei.logupload.c.h;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: UploadRequest */
class C5449n extends TimerTask {
    private final /* synthetic */ Timer f19283a;
    private final /* synthetic */ LogUpload f19284b;

    C5449n(Timer timer, LogUpload logUpload) {
        this.f19283a = timer;
        this.f19284b = logUpload;
    }

    public void run() {
        this.f19283a.cancel();
        this.f19284b.f(true);
        h.a(new StringBuilder(String.valueOf(this.f19284b.f())).toString(), 1);
        k.b(this.f19284b);
    }
}
