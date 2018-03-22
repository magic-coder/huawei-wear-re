package com.huawei.pluginkidwatch.plugin.p152a;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1620b;

/* compiled from: KWBtDevice */
class C1739t implements C1620b {
    final /* synthetic */ C1723d f4684a;

    C1739t(C1723d c1723d) {
        this.f4684a = c1723d;
    }

    public void mo2555a(Object obj) {
        this.f4684a.m8241a((byte[]) obj);
    }

    public void mo2554a(int i, String str) {
        C2538c.m12674b("KWBtDevice", "writeAuthenticationCharacteristic Failure !");
        this.f4684a.m8279v();
    }
}
