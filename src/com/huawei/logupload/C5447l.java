package com.huawei.logupload;

import com.huawei.logupload.c.f;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: UploadRequest */
class C5447l extends TimerTask {
    private final /* synthetic */ Timer f19279a;
    private final /* synthetic */ LogUpload f19280b;

    C5447l(Timer timer, LogUpload logUpload) {
        this.f19279a = timer;
        this.f19280b = logUpload;
    }

    public void run() {
        this.f19279a.cancel();
        f.b("LogUpload Service", "5分钟后重试链接日志分发服务器");
        k.a(this.f19280b);
    }
}
