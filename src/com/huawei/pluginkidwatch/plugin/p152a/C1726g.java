package com.huawei.pluginkidwatch.plugin.p152a;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1620b;

/* compiled from: KWBtDevice */
class C1726g implements C1620b {
    final /* synthetic */ C1723d f4667a;

    C1726g(C1723d c1723d) {
        this.f4667a = c1723d;
    }

    public void mo2555a(Object obj) {
        C2538c.m12674b("KWBtDevice", "antilossChangeBluetoothState onSuccess o = " + obj.toString());
        for (int i = 0; i < this.f4667a.f4653o.size(); i++) {
            C2538c.m12674b("KWBtDevice", "updateKidDeviceBtStatus callback = " + this.f4667a.f4653o.get(i));
            ((C1647c) this.f4667a.f4653o.get(i)).mo2560a(2);
        }
    }

    public void mo2554a(int i, String str) {
        C2538c.m12674b("KWBtDevice", "antilossChangeBluetoothState onFailure i = " + i + " s = " + str);
        if (this.f4667a.f4651m != null) {
            this.f4667a.f4651m.m7849b(5);
        }
    }
}
