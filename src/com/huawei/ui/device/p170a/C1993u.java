package com.huawei.ui.device.p170a;

import com.huawei.hwcloudmodel.c.c;
import com.huawei.hwcloudmodel.callback.a;
import com.huawei.p190v.C2538c;

/* compiled from: DeviceSettingsInteractors */
class C1993u implements a<c> {
    final /* synthetic */ C1990r f6957a;

    C1993u(C1990r c1990r) {
        this.f6957a = c1990r;
    }

    public void m10453a(c cVar, String str, boolean z) {
        if (z) {
            C2538c.m12677c("DeviceSettingsInteractors", "pushWeather2Device() hwCloudMgr.getWeatherInfo Success, dataWeather=" + cVar);
            com.huawei.ad.b.a.a(this.f6957a.f6951h).a(cVar);
            return;
        }
        C2538c.m12680e("DeviceSettingsInteractors", "pushWeather2Device() hwCloudMgr.getWeatherInfo ERROR!");
    }
}
