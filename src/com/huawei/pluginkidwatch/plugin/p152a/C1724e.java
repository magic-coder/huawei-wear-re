package com.huawei.pluginkidwatch.plugin.p152a;

import android.bluetooth.BluetoothDevice;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1686d;

/* compiled from: KWBtDevice */
class C1724e implements C1686d {
    final /* synthetic */ C1723d f4665a;

    C1724e(C1723d c1723d) {
        this.f4665a = c1723d;
    }

    public void mo2572a(int i, String str) {
        C2538c.m12674b("KWBtDevice", "DeviceDiscovery onFailure !!!!");
    }

    public void mo2571a() {
        C2538c.m12674b("KWBtDevice", "onDeviceDiscoveryFinished !!!!");
        if (!this.f4665a.f4658t) {
            this.f4665a.f4663y = -1;
            this.f4665a.m8268o();
            if (this.f4665a.f4660v >= 3 || this.f4665a.f4649k) {
                this.f4665a.m8258h(-1);
            } else {
                this.f4665a.m8294d();
            }
        }
    }

    public void mo2573a(BluetoothDevice bluetoothDevice) {
        C2538c.m12674b("KWBtDevice", "current kidwatch strMacAddress = " + this.f4665a.f4646h);
        C2538c.m12674b("KWBtDevice", "search device Address = " + bluetoothDevice.getAddress());
        if (this.f4665a.f4646h.equals(bluetoothDevice.getAddress().trim())) {
            C2538c.m12674b("KWBtDevice", "====strMacAddress.equals(bleDevice.getAddress().trim())");
        }
        if (this.f4665a.f4646h.trim().equals(bluetoothDevice.getAddress())) {
            C2538c.m12674b("KWBtDevice", "====strMacAddress.trim().equals(bleDevice.getAddress())");
        }
        if (this.f4665a.f4646h.trim().equals(bluetoothDevice.getAddress().trim())) {
            C2538c.m12674b("KWBtDevice", "connecting search device Address = " + bluetoothDevice.getAddress());
            this.f4665a.m8268o();
            this.f4665a.f4642d = bluetoothDevice;
            this.f4665a.f4658t = true;
            this.f4665a.f4651m.m7841a();
            this.f4665a.m8269p();
            this.f4665a.m8258h(1);
            if (this.f4665a.f4664z != null) {
                this.f4665a.f4664z.postDelayed(new C1725f(this), 1000);
            } else {
                this.f4665a.m8258h(0);
            }
        }
    }

    public void mo2575b(BluetoothDevice bluetoothDevice) {
        C2538c.m12674b("KWBtDevice", "DeviceDiscovery onBraceletDeviceDiscovered !!!!");
    }

    public void mo2574b() {
    }
}
