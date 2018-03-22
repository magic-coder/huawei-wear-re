package com.huawei.pluginkidwatch.common.ui.simplecropimage;

import android.graphics.Bitmap;
import java.util.concurrent.CountDownLatch;

/* compiled from: CropImage */
class C1550k implements Runnable {
    final /* synthetic */ Bitmap f3705a;
    final /* synthetic */ CountDownLatch f3706b;
    final /* synthetic */ CropImage f3707c;

    C1550k(CropImage cropImage, Bitmap bitmap, CountDownLatch countDownLatch) {
        this.f3707c = cropImage;
        this.f3705a = bitmap;
        this.f3706b = countDownLatch;
    }

    public void run() {
        this.f3707c.m7082a(this.f3705a, this.f3706b);
    }
}
