package com.huawei.bone.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.huawei.hwcloudmodel.p061c.C0970w;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdatamigrate.hihealth.p067c.be;
import com.huawei.hwdatamigrate.hihealth.p067c.bf;
import com.huawei.hwfitnessmgr.C1026q;
import com.huawei.login.ui.login.C1093a;
import com.huawei.p190v.C2538c;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class MigrateIntentService extends IntentService {
    private Context f1207a = null;

    protected void onHandleIntent(Intent intent) {
        C2538c.m12677c("MigrateIntentService", "Enter onHandleIntent");
        this.f1207a = BaseApplication.m2632b();
        if (intent != null) {
            String action = intent.getAction();
            C2538c.m12677c("MigrateIntentService", "Enter onHandleIntent action:" + action);
            if ("com.huawei.bone.service.MigrateIntentService".equals(action)) {
                action = intent.getStringExtra("migrate_old_huid");
                String stringExtra = intent.getStringExtra("migrate_old_st");
                String stringExtra2 = intent.getStringExtra("migrate_current_huid");
                if (TextUtils.isEmpty(stringExtra)) {
                    C2538c.m12677c("MigrateIntentService", "oldSt is null,return");
                } else if (TextUtils.isEmpty(action)) {
                    C2538c.m12677c("MigrateIntentService", "oldHuid is null,return");
                } else if (TextUtils.isEmpty(stringExtra2)) {
                    C2538c.m12677c("MigrateIntentService", "currentHuid is null,return");
                } else {
                    C2538c.m12674b("MigrateIntentService", "oldHuid:" + action + "   currentHuid:" + stringExtra2 + "   oldSt:" + stringExtra);
                    m2644a(action, stringExtra, stringExtra2);
                }
            } else if ("com.huawei.bone.service.check_data_to_migrate".equals(action)) {
                m2643a();
            }
        }
    }

    private void m2643a() {
        C2538c.m12677c("MigrateIntentService", "Enter reCheckMigrateData");
        String c = C1093a.m4739a(BaseApplication.m2632b()).m4750c();
        be.m3648a().m3655c(c);
        ArrayList a = be.m3648a().m3651a(c);
        if (a == null || a.size() <= 0) {
            C2538c.m12677c("MigrateIntentService", "no data to migrate");
            return;
        }
        bf bfVar = (bf) a.get(0);
        C2538c.m12674b("MigrateIntentService", "list.size():" + a.size() + " table:" + bfVar.toString());
        m2644a(bfVar.m3656a(), bfVar.m3662c(), bfVar.m3659b());
    }

    private void m2644a(String str, String str2, String str3) {
        C2538c.m12677c("MigrateIntentService", "Enter migrateData isDatalogin:" + C0970w.m3488a(C1093a.m4739a(this.f1207a).m4750c()));
        if (C0970w.m3488a(C1093a.m4739a(this.f1207a).m4750c())) {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            C1026q.m4018a(this.f1207a).m4127a(str, new C0667c(this, str, str3, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                C2538c.m12677c("MigrateIntentService", "Enter InterruptedException:" + e.getMessage());
            }
        }
        C2538c.m12677c("MigrateIntentService", "Leave migrateData");
    }

    public void onCreate() {
        C2538c.m12677c("MigrateIntentService", "onCreate()");
        super.onCreate();
    }

    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    public void onDestroy() {
        C2538c.m12677c("MigrateIntentService", "onDestroy()");
        super.onDestroy();
    }

    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    public MigrateIntentService(String str) {
        super(str);
    }

    public MigrateIntentService() {
        super("MigrateIntentService");
    }
}
