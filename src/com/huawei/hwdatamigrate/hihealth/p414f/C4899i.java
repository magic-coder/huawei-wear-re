package com.huawei.hwdatamigrate.hihealth.p414f;

import com.huawei.hihealth.data.p312b.C3951c;
import com.huawei.p190v.C2538c;

import java.util.concurrent.CountDownLatch;

/* compiled from: MigrateWear */
class C4899i implements C3951c {
    final /* synthetic */ boolean[] f17937a;
    final /* synthetic */ CountDownLatch f17938b;
    final /* synthetic */ C4896f f17939c;

    C4899i(C4896f c4896f, boolean[] zArr, CountDownLatch countDownLatch) {
        this.f17939c = c4896f;
        this.f17937a = zArr;
        this.f17938b = countDownLatch;
    }

    public void onResult(int i, Object obj) {
        C2538c.c("HiH_MigrateWear", new Object[]{"migrateDataToHiHealth onResult errorCode = ", Integer.valueOf(i), ",obj = ", obj});
        if (i != 0) {
            this.f17937a[0] = false;
        }
        this.f17938b.countDown();
    }
}
