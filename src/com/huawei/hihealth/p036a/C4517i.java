package com.huawei.hihealth.p036a;

import com.huawei.hihealth.HiDataInsertOption;
import com.huawei.hihealth.data.p312b.C3951c;
import com.huawei.hihealth.p394c.C4541c;
import com.huawei.p190v.C2538c;

import java.util.concurrent.CountDownLatch;

/* compiled from: HiHealthNativeAPI */
class C4517i implements Runnable {
    final /* synthetic */ HiDataInsertOption f16714a;
    final /* synthetic */ C3951c f16715b;
    final /* synthetic */ C4509c f16716c;

    C4517i(C4509c c4509c, HiDataInsertOption hiDataInsertOption, C3951c c3951c) {
        this.f16716c = c4509c;
        this.f16714a = hiDataInsertOption;
        this.f16715b = c3951c;
    }

    public void run() {
        this.f16716c.m21598d();
        long currentTimeMillis = System.currentTimeMillis();
        int[] iArr = new int[]{0};
        Object[] objArr = new Object[]{Boolean.valueOf(true)};
        try {
            C2538c.c("HiH_HiHealthNativeAPI", new Object[]{"insertHiHealthData options size = ", Integer.valueOf(C4541c.m21765a(this.f16714a).size())});
            for (HiDataInsertOption hiDataInsertOption : r0) {
                CountDownLatch countDownLatch = new CountDownLatch(1);
                this.f16716c.f16699b.mo4509a(hiDataInsertOption, new C4518j(this, iArr, objArr, countDownLatch));
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    C2538c.e("HiH_HiHealthNativeAPI", new Object[]{"accountmigrate: 2.0isLogin InterruptedException e = ", e.getMessage()});
                }
            }
            C2538c.c("HiH_HiHealthNativeAPI", new Object[]{"insertHiHealthData code = ", Integer.valueOf(iArr[0]), ",totalTime = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), ",message = ", objArr[0]});
            if (this.f16715b != null) {
                this.f16715b.onResult(iArr[0], objArr[0]);
            }
        } catch (Exception e2) {
            C2538c.e("HiH_HiHealthNativeAPI", new Object[]{"insertHiHealthData e = ", e2.getMessage()});
            iArr[0] = 1;
            objArr[0] = e2.getMessage();
            C2538c.c("HiH_HiHealthNativeAPI", new Object[]{"insertHiHealthData code = ", Integer.valueOf(iArr[0]), ",totalTime = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), ",message = ", objArr[0]});
            if (this.f16715b != null) {
                this.f16715b.onResult(iArr[0], objArr[0]);
            }
        } catch (Throwable th) {
            C2538c.c("HiH_HiHealthNativeAPI", new Object[]{"insertHiHealthData code = ", Integer.valueOf(iArr[0]), ",totalTime = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), ",message = ", objArr[0]});
            if (this.f16715b != null) {
                this.f16715b.onResult(iArr[0], objArr[0]);
            }
        }
    }
}
