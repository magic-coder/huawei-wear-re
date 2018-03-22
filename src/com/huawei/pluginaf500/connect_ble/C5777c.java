package com.huawei.pluginaf500.connect_ble;

import android.bluetooth.BluetoothDevice;

/* compiled from: AF500DeviceMgr */
class C5777c implements Runnable {
    final /* synthetic */ String f19612a;
    final /* synthetic */ BluetoothDevice f19613b;
    final /* synthetic */ C5775a f19614c;

    C5777c(C5775a c5775a, String str, BluetoothDevice bluetoothDevice) {
        this.f19614c = c5775a;
        this.f19612a = str;
        this.f19613b = bluetoothDevice;
    }

    public void run() {
        this.f19614c.f19604e = this.f19612a;
        this.f19614c.f19602c.mo4221a(this.f19613b);
    }
}
