package com.huawei.uploadlog;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.huawei.crowdtestsdk.common.AppContext;
import com.huawei.uploadlog.p187b.C2499a;
import com.huawei.uploadlog.p188c.C2507c;
import com.huawei.uploadlog.p188c.C2511g;

public class LogUploadReceive extends Service {
    public IBinder onBind(Intent intent) {
        C2511g.m12481b("BETACLUB_SDK", "[LogUploadReceive.onBind] <>");
        return null;
    }

    public void onCreate() {
        C2511g.m12481b("BETACLUB_SDK", "[LogUploadReceive.onCreate] <>");
        super.onCreate();
        AppContext.getInstance().setApplication(getApplication());
    }

    public void onDestroy() {
        C2511g.m12481b("BETACLUB_SDK", "[LogUploadReceive.onDestroy] <>");
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        C2511g.m12481b("BETACLUB_SDK", "[LogUploadReceive.onStartCommand] <>");
        if (!(intent == null || intent.getExtras() == null || (C2507c.m12460b() != 3 && C2507c.m12460b() != 0))) {
            LogUpload logUpload = (LogUpload) intent.getParcelableExtra("LogUpload");
            if (logUpload != null) {
                C2499a.m12430a().m12431a(new C2524g(logUpload, 3));
                C2511g.m12481b("BETACLUB_SDK", "service 启动");
            }
        }
        return 2;
    }

    public boolean onUnbind(Intent intent) {
        C2511g.m12481b("BETACLUB_SDK", "[LogUploadReceive] onUnbind()");
        return super.onUnbind(intent);
    }
}
