package com.huawei.uploadlog;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import com.huawei.uploadlog.p186a.C2496a;
import com.huawei.uploadlog.p186a.C2497b;
import com.huawei.uploadlog.p188c.C2507c;
import com.huawei.uploadlog.p188c.C2511g;
import com.huawei.uploadlog.p188c.C2517m;
import com.huawei.uploadlog.p188c.C2519o;

/* compiled from: LogUploadService */
class C2523f implements Runnable {
    final /* synthetic */ Context f9005a;
    final /* synthetic */ LogUpload f9006b;
    final /* synthetic */ LogUploadService f9007c;

    C2523f(LogUploadService logUploadService, Context context, LogUpload logUpload) {
        this.f9007c = logUploadService;
        this.f9005a = context;
        this.f9006b = logUpload;
    }

    public void run() {
        synchronized (C2507c.f8987a) {
            C2497b c2497b = new C2497b(this.f9005a);
            LogUpload b = C2496a.m12419b(c2497b, String.valueOf(this.f9006b.getId()));
            C2519o c2519o;
            if (b == null) {
                long a = C2496a.m12413a(c2497b, this.f9006b);
                this.f9006b.setTaskId(a);
                C2511g.m12481b("BETACLUB_SDK", "taskId:" + a + "logUploadInfoTemp.getId():" + this.f9006b.getId() + "logUploadInfoTemp.getFilepath():" + this.f9006b.getFilePath() + "logUploadInfoTemp().getSize():" + this.f9006b.getSize());
                C2517m.m12570a(this.f9006b, 2);
                C2511g.m12481b("BETACLUB_SDK", "logUploadInfo.getTaskId():" + this.f9006b.getTaskId() + "CommonConstants.getTaskList():" + C2507c.m12462c());
                Intent intent = new Intent();
                intent.setAction("com.huawei.crowdtestsdk.UPLOAD_PROGRESS");
                intent.putExtra("mLogUploadInfo", this.f9006b);
                this.f9007c.sendBroadcast(intent);
                c2519o = new C2519o(Looper.getMainLooper());
                Message obtainMessage = c2519o.obtainMessage(1);
                obtainMessage.obj = this.f9006b;
                c2519o.sendMessage(obtainMessage);
            } else {
                if (C2517m.m12576b(b) != 1) {
                    C2517m.m12570a(b, 2);
                }
                C2511g.m12481b("BETACLUB_SDK", "mLogupload.getTaskId():" + b.getTaskId() + "CommonConstants.getTaskList():" + C2507c.m12462c());
                c2519o = new C2519o(Looper.getMainLooper());
                Message obtainMessage2 = c2519o.obtainMessage(1);
                obtainMessage2.obj = b;
                c2519o.sendMessage(obtainMessage2);
            }
        }
    }
}
