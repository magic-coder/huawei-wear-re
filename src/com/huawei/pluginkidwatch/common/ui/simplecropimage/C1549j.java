package com.huawei.pluginkidwatch.common.ui.simplecropimage;

import java.util.concurrent.CountDownLatch;

/* compiled from: CropImage */
class C1549j implements Runnable {
    final /* synthetic */ CropImage f3704a;

    C1549j(CropImage cropImage) {
        this.f3704a = cropImage;
    }

    public void run() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f3704a.f3658i.post(this.f3704a.m7076a(countDownLatch, this.f3704a.f3666q));
        try {
            countDownLatch.await();
            this.f3704a.f3653d.run();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
