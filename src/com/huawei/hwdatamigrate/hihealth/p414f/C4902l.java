package com.huawei.hwdatamigrate.hihealth.p414f;

import com.huawei.hihealth.data.p312b.C3951c;
import com.huawei.p190v.C2538c;

import java.util.concurrent.CountDownLatch;

/* compiled from: MigrateWearByHuid */
class C4902l implements C3951c {
    final /* synthetic */ boolean[] f17953a;
    final /* synthetic */ CountDownLatch f17954b;
    final /* synthetic */ C4901k f17955c;

    C4902l(C4901k c4901k, boolean[] zArr, CountDownLatch countDownLatch) {
        this.f17955c = c4901k;
        this.f17953a = zArr;
        this.f17954b = countDownLatch;
    }

    public void onResult(int i, Object obj) {
        C2538c.c("HiH_MigrateWearByHuid", new Object[]{"migrateDataToHiHealth onResult errorCode = ", Integer.valueOf(i), ",obj = ", obj});
        if (i != 0) {
            this.f17953a[0] = false;
        }
        this.f17954b.countDown();
    }
}
