package com.huawei.hwcommonservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.huawei.p190v.C2538c;

public class HWWearCommonService extends Service {
    private final C0982g f1656a = new C0983a(this);
    private final C0985e f1657b = new C0986b(this);

    public HWWearCommonService() {
        C2538c.m12677c("HWWearCommonService", "HWWearCommonService construct");
    }

    public IBinder onBind(Intent intent) {
        C2538c.m12677c("HWWearCommonService", "onBind service ");
        return this.f1656a;
    }

    public boolean onUnbind(Intent intent) {
        C2538c.m12677c("HWWearCommonService", "onUnbind service ");
        return super.onUnbind(intent);
    }
}
