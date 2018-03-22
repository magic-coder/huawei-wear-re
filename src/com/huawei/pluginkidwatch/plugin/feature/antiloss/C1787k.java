package com.huawei.pluginkidwatch.plugin.feature.antiloss;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1620b;

/* compiled from: AntilossActivity */
class C1787k implements C1620b {
    final /* synthetic */ AntilossActivity f4936a;

    C1787k(AntilossActivity antilossActivity) {
        this.f4936a = antilossActivity;
    }

    public void mo2555a(Object obj) {
        C2538c.m12674b("AntilossActivity", "onClick setDeviceLinkLoss onSuccess o = " + obj.toString());
        this.f4936a.m8521l();
    }

    public void mo2554a(int i, String str) {
        C2538c.m12674b("AntilossActivity", "=====onClick setDeviceLinkLoss onFailure i = " + i + " s = " + str);
        this.f4936a.m8521l();
    }
}
