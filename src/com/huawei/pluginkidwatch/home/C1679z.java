package com.huawei.pluginkidwatch.home;

import com.amap.api.location.LocationProviderProxy;
import com.android.volley.DefaultRetryPolicy;

/* compiled from: HomeActivity */
class C1679z implements Runnable {
    final /* synthetic */ HomeActivity f4379a;

    C1679z(HomeActivity homeActivity) {
        this.f4379a = homeActivity;
    }

    public void run() {
        this.f4379a.f4107D.requestLocationData(LocationProviderProxy.AMapNetwork, 200, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, this.f4379a);
    }
}
