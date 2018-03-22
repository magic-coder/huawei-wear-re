package com.huawei.pluginkidwatch.common.ui.view;

import android.graphics.Bitmap;
import android.os.Handler;
import com.huawei.p190v.C2538c;

/* compiled from: AsyncImageLoader */
class C1572g implements C1569i {
    final /* synthetic */ Handler f3876a;
    final /* synthetic */ C1565a f3877b;

    C1572g(C1565a c1565a, Handler handler) {
        this.f3877b = c1565a;
        this.f3876a = handler;
    }

    public void mo2545a(Bitmap bitmap) {
        this.f3876a.sendEmptyMessage(10002);
        C2538c.m12674b("AsyncImageLoader", "=========loadBitmapByServer --> 加载图片成功");
    }
}
