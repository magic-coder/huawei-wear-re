package com.huawei.ui.homewear21.receiver;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.hwcloudmodel.p061c.C0970w;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.nps.interactors.C2442a;

public class UpgradeDBWorkerService extends IntentService {
    private static final String f8266a = UpgradeDBWorkerService.class.getSimpleName();

    public void onCreate() {
        C2538c.m12677c(f8266a, "UpgradeDBWorkerService ===>>onCreate");
        super.onCreate();
    }

    public void onStart(Intent intent, int i) {
        C2538c.m12677c(f8266a, "UpgradeDBWorkerService ===>>onStart");
        super.onStart(intent, i);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        C2538c.m12677c(f8266a, "UpgradeDBWorkerService ===>>onStartCommand");
        return super.onStartCommand(intent, i, i2);
    }

    public UpgradeDBWorkerService(String str) {
        super(str);
    }

    public UpgradeDBWorkerService() {
        super("UpgradeDBWorkerService");
    }

    protected void onHandleIntent(Intent intent) {
        C2538c.m12677c(f8266a, "UpgradeDBWorkerService start");
        if (intent == null) {
            C2538c.m12674b(f8266a, "intent == null");
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            C2538c.m12677c(f8266a, "task == null");
            return;
        }
        int i = extras.getInt("BUNDLE_WORK_TASK_UPGRADE", 0);
        if (i == 0) {
            C2538c.m12677c(f8266a, "work == 0");
            return;
        }
        C2538c.m12677c(f8266a, "UpgradeDBWorkerService work:" + i);
        switch (i) {
            case 1:
                if (!C0970w.m3489b()) {
                    C2442a.m12225a(BaseApplication.m2632b()).m12263a();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onDestroy() {
        C2538c.m12677c(f8266a, "UpgradeDBWorkerService ===>>onDestroy");
        super.onDestroy();
    }
}
