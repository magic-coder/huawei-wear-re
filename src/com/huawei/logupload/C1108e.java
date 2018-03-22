package com.huawei.logupload;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import com.huawei.logupload.p088a.C1097a;
import com.huawei.logupload.p088a.C1098c;
import com.huawei.logupload.p090c.C1102c;
import com.huawei.logupload.p090c.C1103f;
import com.huawei.logupload.p090c.C1105h;
import com.huawei.logupload.p090c.C1105h.C1104a;

/* compiled from: LogUploadService */
class C1108e implements Runnable {
    final /* synthetic */ LogUploadService f2286a;
    private final /* synthetic */ Context f2287b;
    private final /* synthetic */ LogUpload f2288c;

    C1108e(LogUploadService logUploadService, Context context, LogUpload logUpload) {
        this.f2286a = logUploadService;
        this.f2287b = context;
        this.f2288c = logUpload;
    }

    public void run() {
        synchronized (C1102c.f2274a) {
            C1098c c1098c = new C1098c(this.f2287b);
            LogUpload b = C1097a.m4848b(c1098c, String.valueOf(this.f2288c.m4800i()));
            C1104a c1104a;
            if (b == null) {
                long a = C1097a.m4842a(c1098c, this.f2288c);
                this.f2288c.m4768a(a);
                C1103f.m4878b("LogUpload Service", "taskId:" + a + "logUploadInfoTemp.getId():" + this.f2288c.m4800i() + "logUploadInfoTemp.getFilepath():" + this.f2288c.m4798h() + "logUploadInfoTemp().getSize():" + this.f2288c.m4802j());
                C1105h.m4894a(new StringBuilder(String.valueOf(this.f2288c.m4791f())).toString(), 2);
                C1103f.m4878b("LogUpload Service", "logUploadInfo.getTaskId():" + this.f2288c.m4791f() + "CommonConstants.getTaskList():" + C1102c.m4867c());
                if (C1102c.m4875i() != 1) {
                    Intent intent = new Intent();
                    intent.setAction("com.example.logupload.progress");
                    intent.setPackage(this.f2288c.m4760C());
                    intent.putExtra("mLogUploadInfo", this.f2288c);
                    this.f2286a.sendBroadcast(intent);
                }
                c1104a = new C1104a(Looper.getMainLooper());
                Message obtainMessage = c1104a.obtainMessage(1);
                obtainMessage.obj = this.f2288c;
                c1104a.sendMessage(obtainMessage);
            } else {
                if (C1105h.m4884a(new StringBuilder(String.valueOf(b.m4791f())).toString()) != 1) {
                    C1105h.m4894a(new StringBuilder(String.valueOf(b.m4791f())).toString(), 2);
                }
                C1103f.m4878b("LogUpload Service", "mLogupload.getTaskId():" + b.m4791f() + "CommonConstants.getTaskList():" + C1102c.m4867c());
                c1104a = new C1104a(Looper.getMainLooper());
                Message obtainMessage2 = c1104a.obtainMessage(1);
                obtainMessage2.obj = b;
                c1104a.sendMessage(obtainMessage2);
            }
        }
    }
}
