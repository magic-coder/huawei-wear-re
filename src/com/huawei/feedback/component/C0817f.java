package com.huawei.feedback.component;

import com.huawei.logupload.LogUpload;

/* compiled from: ProgressService */
class C0817f implements Runnable {
    final /* synthetic */ int f1286a;
    final /* synthetic */ LogUpload f1287b;
    final /* synthetic */ ProgressService f1288c;

    C0817f(ProgressService progressService, int i, LogUpload logUpload) {
        this.f1288c = progressService;
        this.f1286a = i;
        this.f1287b = logUpload;
    }

    public void run() {
        this.f1288c.f1261c.cancel(this.f1286a);
        this.f1288c.f1262d.remove(Long.valueOf(this.f1287b.m4800i()));
        this.f1288c.f1263e.remove(Long.valueOf(this.f1287b.m4800i()));
    }
}
