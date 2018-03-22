package com.huawei.pluginkidwatch.common.ui.view;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* compiled from: AsyncImageLoader */
class C1570e implements C1569i {
    final /* synthetic */ ImageView f3873a;
    final /* synthetic */ C1565a f3874b;

    C1570e(C1565a c1565a, ImageView imageView) {
        this.f3874b = c1565a;
        this.f3873a = imageView;
    }

    public void mo2545a(Bitmap bitmap) {
        if (bitmap != null) {
            this.f3873a.setImageBitmap(C1565a.m7212a(bitmap));
        }
    }
}
