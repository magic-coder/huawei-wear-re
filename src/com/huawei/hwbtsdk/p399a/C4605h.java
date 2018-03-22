package com.huawei.hwbtsdk.p399a;

import android.bluetooth.BluetoothDevice;
import com.huawei.hwbtsdk.p057b.p058a.C4604c;

/* compiled from: BTDeviceMgrUtil */
class C4605h implements C4604c {
    final /* synthetic */ C4600d f16856a;

    C4605h(C4600d c4600d) {
        this.f16856a = c4600d;
    }

    public void mo4540a(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice != null) {
            this.f16856a.f16834i.add(bluetoothDevice);
            synchronized (C4600d.f16825v) {
                if (this.f16856a.f16832g != null) {
                    this.f16856a.f16832g.mo4540a(bluetoothDevice);
                }
            }
        }
    }

    public void mo4539a() {
    }

    public void mo4541b() {
    }
}
