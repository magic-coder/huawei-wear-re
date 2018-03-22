package com.huawei.pluginkidwatch.common.ui.simplecropimage;

import android.graphics.Bitmap;

/* compiled from: CropImage */
class C1551l implements Runnable {
    final /* synthetic */ Bitmap f3708a;
    final /* synthetic */ CropImage f3709b;

    C1551l(CropImage cropImage, Bitmap bitmap) {
        this.f3709b = cropImage;
        this.f3708a = bitmap;
    }

    public void run() {
        this.f3709b.m7092c(this.f3708a);
    }
}
