package com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d;

import android.bluetooth.BluetoothGatt;

/* compiled from: BluetoothLEConnectService */
class C1714t implements Runnable {
    final /* synthetic */ BluetoothGatt f4585a;
    final /* synthetic */ C1705k f4586b;

    C1714t(C1705k c1705k, BluetoothGatt bluetoothGatt) {
        this.f4586b = c1705k;
        this.f4585a = bluetoothGatt;
    }

    public void run() {
        this.f4585a.discoverServices();
    }
}
