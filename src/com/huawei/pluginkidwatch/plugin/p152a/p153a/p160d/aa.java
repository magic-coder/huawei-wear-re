package com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d;

import android.bluetooth.BluetoothGatt;
import com.huawei.p190v.C2538c;

/* compiled from: DataTransferStateMachine */
class aa implements Runnable {
    final /* synthetic */ BluetoothGatt f4441a;
    final /* synthetic */ C1719y f4442b;

    aa(C1719y c1719y, BluetoothGatt bluetoothGatt) {
        this.f4442b = c1719y;
        this.f4441a = bluetoothGatt;
    }

    public void run() {
        boolean discoverServices = this.f4441a.discoverServices();
        C2538c.m12674b("DataTransferStateMachine", "Attempting to start service discovery:" + discoverServices);
        synchronized (this.f4442b.f4621m) {
            this.f4442b.f4621m.clear();
        }
    }
}
