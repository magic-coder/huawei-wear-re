package com.huawei.logupload;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.huawei.logupload.b.a;
import com.huawei.logupload.c.b;
import com.huawei.logupload.c.c;
import com.huawei.logupload.c.f;

public class LogUploadReceive extends Service {
    public IBinder onBind(Intent intent) {
        f.b("LogUpload Service", "LogUploadReceive onBind()");
        return null;
    }

    public void onCreate() {
        f.b("LogUpload Service", "LogUploadReceive onCreate()");
        super.onCreate();
        b.a().a(getApplication());
    }

    public void onDestroy() {
        f.b("LogUpload Service", "LogUploadReceive onDestroy()");
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        f.b("LogUpload Service", "LogUploadReceive onStartCommand()");
        if (!(intent == null || intent.getExtras() == null || (c.b() != 3 && c.b() != 0))) {
            LogUpload logUpload = (LogUpload) intent.getParcelableExtra("LogUpload");
            if (logUpload != null) {
                f.d("LogUpload Service", "alert_visible=" + logUpload.g() + "; filepath=" + logUpload.h() + "; transactionId=" + logUpload.i() + "; size=" + logUpload.j() + "; encrypt=" + logUpload.k() + "; privacy=" + logUpload.q() + "; flags=" + logUpload.l() + "; channelId=" + logUpload.A() + "; feedBackPackageName=" + logUpload.C() + "; feedBackClassName=" + logUpload.D());
                a.a().a(new f(logUpload, 3));
                f.b("LogUpload Service", "service 启动");
            }
        }
        return 2;
    }

    public boolean onUnbind(Intent intent) {
        f.b("LogUpload Service", "LogUploadReceive onUnbind()");
        return super.onUnbind(intent);
    }
}
