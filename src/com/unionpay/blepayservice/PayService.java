package com.unionpay.blepayservice;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.p190v.C2538c;

public class PayService extends Service {
    private int f9087a;
    private Context f9088b;
    private final C2679e f9089c = new C2681g(this);
    private final C2677c f9090d = new C2682h(this);

    public void onCreate() {
        super.onCreate();
        this.f9088b = BaseApplication.m2632b();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public IBinder onBind(Intent intent) {
        C2538c.m12677c("PayService", "onBind...");
        return this.f9090d;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        C2538c.m12677c("PayService", "onStartCommand...");
        if (intent == null || intent.getExtras() == null) {
            return 2;
        }
        return super.onStartCommand(intent, i, i2);
    }
}
