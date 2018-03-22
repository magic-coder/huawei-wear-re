package com.huawei.uploadlog;

import com.huawei.uploadlog.p188c.C2517m;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: UploadRequest */
final class C2531n extends TimerTask {
    final /* synthetic */ Timer f9017a;
    final /* synthetic */ LogUpload f9018b;

    C2531n(Timer timer, LogUpload logUpload) {
        this.f9017a = timer;
        this.f9018b = logUpload;
    }

    public void run() {
        this.f9017a.cancel();
        this.f9018b.setReconnect(true);
        C2517m.m12570a(this.f9018b, 1);
        C2529l.m12613f(this.f9018b);
    }
}
