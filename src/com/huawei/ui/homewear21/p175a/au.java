package com.huawei.ui.homewear21.p175a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;

/* compiled from: HomeFragment */
class au extends BroadcastReceiver {
    final /* synthetic */ C2217a f8064a;

    au(C2217a c2217a) {
        this.f8064a = c2217a;
    }

    public void onReceive(Context context, Intent intent) {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "HomeFragment mGetWeatherInfoReceiver(): intent = " + intent.getAction());
        this.f8064a.aW();
    }
}
