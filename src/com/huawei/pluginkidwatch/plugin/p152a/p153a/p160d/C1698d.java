package com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d;

import android.bluetooth.BluetoothDevice;
import com.huawei.p190v.C2538c;

/* compiled from: BTBLEDeviceManager */
class C1698d implements Runnable {
    final /* synthetic */ BluetoothDevice f4498a;
    final /* synthetic */ String f4499b;
    final /* synthetic */ C1697c f4500c;

    C1698d(C1697c c1697c, BluetoothDevice bluetoothDevice, String str) {
        this.f4500c = c1697c;
        this.f4498a = bluetoothDevice;
        this.f4499b = str;
    }

    public void run() {
        this.f4500c.f4495d = this.f4498a;
        C2538c.m12674b("BTBLEDeviceManager", "=======得到的绑定设备Mac为：" + this.f4500c.f4495d.getAddress());
        if (this.f4498a.getAddress().equals(this.f4500c.f4495d.getAddress())) {
            C2538c.m12674b("BTBLEDeviceManager", "======= Connect Device: " + this.f4498a.getAddress());
            this.f4500c.f4493b.m8006a(this.f4500c.f4495d, this.f4500c.f4497f);
        } else {
            C2538c.m12664a("BTBLEDeviceManager", "=======没有找到相应Mac的设备=====");
            if (this.f4500c.f4496e != null) {
                this.f4500c.mo2584b(this.f4500c.f4496e);
                try {
                    this.f4500c.f4496e.mo2593a(this.f4500c.f4497f, this.f4499b, 5, 14);
                } catch (Exception e) {
                    C2538c.m12680e("BTBLEDeviceManager", "Exception e = " + e.getMessage());
                }
            }
        }
        if (this.f4500c.f4495d == null) {
            C2538c.m12664a("BTBLEDeviceManager", "mDevice is null");
        }
    }
}
