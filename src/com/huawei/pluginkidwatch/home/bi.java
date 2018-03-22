package com.huawei.pluginkidwatch.home;

import android.graphics.Bitmap;
import com.amap.api.maps.model.BitmapDescriptorFactory;

/* compiled from: HomeActivity */
class bi implements Runnable {
    final /* synthetic */ Bitmap f4273a;
    final /* synthetic */ HomeActivity f4274b;

    bi(HomeActivity homeActivity, Bitmap bitmap) {
        this.f4274b = homeActivity;
        this.f4273a = bitmap;
    }

    public void run() {
        this.f4274b.f4127X = this.f4274b.m7553b(this.f4273a);
        if (!(this.f4274b.f4128Y == null || this.f4274b.f4127X == null)) {
            this.f4274b.f4128Y.setIcon(BitmapDescriptorFactory.fromBitmap(this.f4274b.f4127X));
        }
        if (this.f4274b.f4127X != null && !this.f4274b.f4127X.isRecycled()) {
            this.f4274b.f4127X.recycle();
        }
    }
}
