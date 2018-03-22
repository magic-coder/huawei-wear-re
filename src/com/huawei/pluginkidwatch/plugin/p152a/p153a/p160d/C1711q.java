package com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d;

import com.huawei.p190v.C2538c;

/* compiled from: BluetoothLEConnectService */
class C1711q implements Runnable {
    final /* synthetic */ C1709o f4582a;

    C1711q(C1709o c1709o) {
        this.f4582a = c1709o;
    }

    public void run() {
        this.f4582a.f4580a.m8106d(true);
        C2538c.m12674b("BluetoothLEConnectService", "重新连接  connect:" + this.f4582a.f4580a.f4558Z);
    }
}
