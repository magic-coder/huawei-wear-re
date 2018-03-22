package com.huawei.pluginkidwatch.plugin.p152a;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1685c;

/* compiled from: KWBtDevice */
class C1732m implements C1685c {
    final /* synthetic */ C1723d f4677a;

    C1732m(C1723d c1723d) {
        this.f4677a = c1723d;
    }

    public void mo2593a(int i, String str, int i2, int i3) {
        this.f4677a.f4663y = i2;
        C2538c.m12674b("KWBtDevice", "connectStatusCallBack onConnectStatusChange connect state = " + i2);
        if (i2 == 2) {
            C2538c.m12674b("KWBtDevice", "onConnectStatusChange connect state = " + i2 + "     deviceConnectAuthentication");
            this.f4677a.m8271q();
            if (this.f4677a.f4664z != null) {
                this.f4677a.f4664z.postDelayed(new C1733n(this), 800);
            }
        } else if (i2 == 3) {
            this.f4677a.m8271q();
            this.f4677a.m8280w();
            C2538c.m12674b("KWBtDevice", "connectStatusCallBack onConnectStatusChange DEVICE_DISCONNECTED !!!!!!");
            if (this.f4677a.f4659u >= 3 || this.f4677a.f4649k || this.f4677a.f4661w) {
                this.f4677a.f4659u = 0;
                this.f4677a.m8258h(i2);
            } else if (this.f4677a.f4664z == null) {
            } else {
                if (1 == this.f4677a.f4659u) {
                    this.f4677a.f4664z.postDelayed(new C1734o(this), 3000);
                } else {
                    this.f4677a.f4664z.postDelayed(new C1735p(this), 3000);
                }
            }
        }
    }
}
