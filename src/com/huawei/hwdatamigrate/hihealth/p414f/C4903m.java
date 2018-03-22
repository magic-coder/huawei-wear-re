package com.huawei.hwdatamigrate.hihealth.p414f;

import com.huawei.hihealth.data.p312b.C3961b;
import com.huawei.p190v.C2538c;
import java.util.concurrent.CountDownLatch;

/* compiled from: MigrateWearByHuid */
class C4903m implements C3961b {
    final /* synthetic */ CountDownLatch f17956a;
    final /* synthetic */ boolean[] f17957b;
    final /* synthetic */ C4901k f17958c;

    C4903m(C4901k c4901k, CountDownLatch countDownLatch, boolean[] zArr) {
        this.f17958c = c4901k;
        this.f17956a = countDownLatch;
        this.f17957b = zArr;
    }

    public void mo4331a(int i, Object obj) {
        C2538c.d("HiH_MigrateWearByHuid", new Object[]{"migrateData login Success in HiHealth "});
        this.f17956a.countDown();
    }

    public void mo4332b(int i, Object obj) {
        if (i != 0) {
            this.f17957b[0] = false;
        }
        this.f17956a.countDown();
    }
}
