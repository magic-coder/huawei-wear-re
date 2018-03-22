package com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d;

import android.bluetooth.BluetoothDevice;

/* compiled from: DataTransferStateMachine */
class C1720z implements Runnable {
    final /* synthetic */ BluetoothDevice f4631a;
    final /* synthetic */ int f4632b;
    final /* synthetic */ C1719y f4633c;

    C1720z(C1719y c1719y, BluetoothDevice bluetoothDevice, int i) {
        this.f4633c = c1719y;
        this.f4631a = bluetoothDevice;
        this.f4632b = i;
    }

    public void run() {
        this.f4633c.f4626r.mo2588a(this.f4631a, true, this.f4632b, this.f4633c.f4611b);
    }
}
