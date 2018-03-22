package com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d;

import com.huawei.p190v.C2538c;

/* compiled from: BluetoothLEConnectService */
class C1708n implements Runnable {
    final /* synthetic */ C1705k f4579a;

    C1708n(C1705k c1705k) {
        this.f4579a = c1705k;
    }

    public void run() {
        this.f4579a.f4564n = 0;
        this.f4579a.m8111e(-3);
        C2538c.m12680e("BluetoothLEConnectService", "断开GATT无响应");
    }
}
