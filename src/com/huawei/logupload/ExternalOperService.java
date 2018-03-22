package com.huawei.logupload;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.huawei.logupload.C1094a.C1096a;
import com.huawei.logupload.p090c.C1101b;
import com.huawei.logupload.p090c.C1103f;

public class ExternalOperService extends Service {
    C1096a f2221a = new C1100b(this);

    public IBinder onBind(Intent intent) {
        C1103f.m4876a("ExternalOperDataBases", "onBind");
        return this.f2221a;
    }

    public void onCreate() {
        super.onCreate();
        C1101b.m4858a().m4859a(getApplication());
        C1103f.m4876a("ExternalOperDataBases", "onCreate");
    }

    public void onDestroy() {
        C1103f.m4876a("ExternalOperDataBases", "onDestroy");
        super.onDestroy();
    }

    public boolean onUnbind(Intent intent) {
        C1103f.m4876a("ExternalOperDataBases", "onUnbind");
        return super.onUnbind(intent);
    }
}
