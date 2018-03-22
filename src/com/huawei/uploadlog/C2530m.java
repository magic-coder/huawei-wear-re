package com.huawei.uploadlog;

import com.huawei.uploadlog.p188c.C2511g;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: UploadRequest */
final class C2530m extends TimerTask {
    final /* synthetic */ Timer f9015a;
    final /* synthetic */ LogUpload f9016b;

    C2530m(Timer timer, LogUpload logUpload) {
        this.f9015a = timer;
        this.f9016b = logUpload;
    }

    public void run() {
        this.f9015a.cancel();
        C2511g.m12481b("BETACLUB_SDK", "[UploadRequest.logUploadRequest] 5分钟后重试链接日志分发服务器");
        C2529l.m12612e(this.f9016b);
    }
}
