package com.huawei.uploadlog;

import com.huawei.uploadlog.p188c.C2517m;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: UploadRequest */
final class C2532o extends TimerTask {
    final /* synthetic */ Timer f9019a;
    final /* synthetic */ LogUpload f9020b;

    C2532o(Timer timer, LogUpload logUpload) {
        this.f9019a = timer;
        this.f9020b = logUpload;
    }

    public void run() {
        this.f9019a.cancel();
        this.f9020b.setReconnect(true);
        C2517m.m12570a(this.f9020b, 1);
        C2529l.m12613f(this.f9020b);
    }
}
