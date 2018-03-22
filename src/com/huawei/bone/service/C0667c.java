package com.huawei.bone.service;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcloudmodel.p060b.C0969i;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdatamigrate.hihealth.f.k;
import com.huawei.hwdatamigrate.hihealth.p067c.be;
import com.huawei.p190v.C2538c;
import java.util.concurrent.CountDownLatch;

/* compiled from: MigrateIntentService */
class C0667c implements IBaseResponseCallback {
    final /* synthetic */ String f1213a;
    final /* synthetic */ String f1214b;
    final /* synthetic */ CountDownLatch f1215c;
    final /* synthetic */ MigrateIntentService f1216d;

    C0667c(MigrateIntentService migrateIntentService, String str, String str2, CountDownLatch countDownLatch) {
        this.f1216d = migrateIntentService;
        this.f1213a = str;
        this.f1214b = str2;
        this.f1215c = countDownLatch;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c("MigrateIntentService", "startHealthMigrateData fitness data migrate complete err_code:" + i);
        if (C0969i.m3482a(57)) {
            k.a(BaseApplication.m2632b(), this.f1213a, Boolean.valueOf(true)).b();
        } else {
            k.a(BaseApplication.m2632b(), this.f1213a, Boolean.valueOf(false)).b();
        }
        be.m3648a().m3652b(this.f1213a, this.f1214b);
        this.f1215c.countDown();
        Intent intent = new Intent();
        intent.setAction("com.huawei.migrate.action.migrate.success");
        if (LocalBroadcastManager.getInstance(this.f1216d.f1207a) != null) {
            LocalBroadcastManager.getInstance(this.f1216d.f1207a).sendBroadcast(intent);
        }
    }
}
