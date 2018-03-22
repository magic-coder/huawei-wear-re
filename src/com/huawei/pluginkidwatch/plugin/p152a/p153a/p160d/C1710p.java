package com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d;

import com.huawei.p190v.C2538c;

/* compiled from: BluetoothLEConnectService */
class C1710p implements Runnable {
    final /* synthetic */ C1709o f4581a;

    C1710p(C1709o c1709o) {
        this.f4581a = c1709o;
    }

    public void run() {
        if (this.f4581a.f4580a.f4543J != null) {
            this.f4581a.f4580a.f4543J.m8152a();
        }
        this.f4581a.f4580a.f4572w = false;
        if (C1705k.f4534K != null) {
            this.f4581a.f4580a.f4561j = System.currentTimeMillis();
            this.f4581a.f4580a.f4569t = true;
            this.f4581a.f4580a.f4542I = new C1716v(this.f4581a.f4580a);
            this.f4581a.f4580a.f4542I.start();
            C2538c.m12674b("BluetoothLEConnectService", "开启发现服务超时");
            this.f4581a.f4580a.f4558Z = C1705k.f4534K.discoverServices();
            C2538c.m12674b("BluetoothLEConnectService", "Attempting to start service discovery:" + this.f4581a.f4580a.f4558Z);
        }
    }
}
