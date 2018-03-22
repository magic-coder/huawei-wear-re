package com.huawei.hwdatamigrate.hihealth.p414f;

import com.huawei.p190v.C2538c;

import java.util.concurrent.ExecutorService;

/* compiled from: MigrateWear */
class C4897g implements Runnable {
    final /* synthetic */ Long f17932a;
    final /* synthetic */ ExecutorService f17933b;
    final /* synthetic */ C4896f f17934c;

    C4897g(C4896f c4896f, Long l, ExecutorService executorService) {
        this.f17934c = c4896f;
        this.f17932a = l;
        this.f17933b = executorService;
    }

    public void run() {
        try {
            this.f17934c.f17927j = true;
            this.f17934c.m23682e();
            this.f17934c.m23684f();
            this.f17934c.m23686g();
            this.f17934c.m23695p();
            this.f17934c.m23687h();
            this.f17934c.m23688i();
            this.f17934c.m23675a(true);
            C2538c.c("HiH_MigrateWear", new Object[]{"migrateWearData end time = ", Long.valueOf(System.currentTimeMillis() - this.f17932a.longValue())});
        } catch (Exception e) {
            C2538c.e("HiH_MigrateWear", new Object[]{"migrateWearData Exception e = ", e.getMessage()});
        } finally {
            this.f17934c.f17927j = false;
            this.f17933b.shutdown();
        }
    }
}
