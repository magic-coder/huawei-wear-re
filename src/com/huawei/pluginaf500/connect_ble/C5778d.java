package com.huawei.pluginaf500.connect_ble;

import android.bluetooth.BluetoothDevice;

/* compiled from: AF500DeviceMgr */
class C5778d implements Runnable {
    final /* synthetic */ BluetoothDevice f19615a;
    final /* synthetic */ C5775a f19616b;

    C5778d(C5775a c5775a, BluetoothDevice bluetoothDevice) {
        this.f19616b = c5775a;
        this.f19615a = bluetoothDevice;
    }

    public void run() {
        this.f19616b.f19602c.mo4221a(this.f19615a);
    }
}
