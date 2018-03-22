package com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d;

import android.bluetooth.BluetoothDevice;
import com.huawei.p190v.C2538c;

/* compiled from: BluetoothLEConnectService */
class C1706l implements Runnable {
    final /* synthetic */ BluetoothDevice f4576a;
    final /* synthetic */ C1705k f4577b;

    C1706l(C1705k c1705k, BluetoothDevice bluetoothDevice) {
        this.f4577b = c1705k;
        this.f4576a = bluetoothDevice;
    }

    public void run() {
        C1705k.f4534K = this.f4576a.connectGatt(this.f4577b.b, false, this.f4577b.aa);
        C2538c.m12674b("BluetoothLEConnectService", "connectGatt() mBluetoothGatt = " + C1705k.f4534K);
    }
}
