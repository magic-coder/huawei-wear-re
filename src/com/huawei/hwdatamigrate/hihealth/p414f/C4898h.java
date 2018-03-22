package com.huawei.hwdatamigrate.hihealth.p414f;

import com.huawei.hihealth.data.p312b.C3961b;
import com.huawei.p190v.C2538c;

import java.util.concurrent.CountDownLatch;

/* compiled from: MigrateWear */
class C4898h implements C3961b {
    final /* synthetic */ CountDownLatch f17935a;
    final /* synthetic */ C4896f f17936b;

    C4898h(C4896f c4896f, CountDownLatch countDownLatch) {
        this.f17936b = c4896f;
        this.f17935a = countDownLatch;
    }

    public void mo4331a(int i, Object obj) {
        C2538c.c("HiH_MigrateWear", new Object[]{"migrateAccount onSuccess intent = ", Integer.valueOf(i), ",data = ", obj});
        this.f17935a.countDown();
    }

    public void mo4332b(int i, Object obj) {
        C2538c.d("HiH_MigrateWear", new Object[]{"migrateAccount onFailure errCode = ", Integer.valueOf(i), ",errMsg = ", obj});
        this.f17935a.countDown();
    }
}
