package com.huawei.pluginkidwatch.home;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.plugin.p152a.C1647c;

/* compiled from: MenuFragment */
class bq implements C1647c {
    final /* synthetic */ bo f4322a;

    bq(bo boVar) {
        this.f4322a = boVar;
    }

    public void mo2560a(int i) {
        if (this.f4322a.isAdded()) {
            C2538c.m12674b("KIDWATCH_MenuFragment", "==ww== onDataReceived state=" + i);
            this.f4322a.m7789a(i);
        }
    }
}
