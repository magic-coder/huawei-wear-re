package com.huawei.pluginkidwatch.home;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.plugin.p152a.C1723d;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1620b;

/* compiled from: HomeActivity */
class ak implements C1620b {
    final /* synthetic */ C1723d f4174a;
    final /* synthetic */ HomeActivity f4175b;

    ak(HomeActivity homeActivity, C1723d c1723d) {
        this.f4175b = homeActivity;
        this.f4174a = c1723d;
    }

    public void mo2555a(Object obj) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "DEVICE_CHANGED onSuccess o = " + obj.toString());
        this.f4174a.m8301h();
    }

    public void mo2554a(int i, String str) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "DEVICE_CHANGED onSuccess i = " + i + " s = " + str);
        this.f4174a.m8301h();
    }
}
