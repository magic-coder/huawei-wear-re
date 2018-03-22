package com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d;

import android.bluetooth.BluetoothDevice;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1686d;

/* compiled from: HuaweiWearableDeviceImpl */
class ap implements C1686d {
    final /* synthetic */ an f4470a;

    ap(an anVar) {
        this.f4470a = anVar;
    }

    public void mo2575b(BluetoothDevice bluetoothDevice) {
        this.f4470a.m7942d(bluetoothDevice);
    }

    public void mo2571a() {
    }

    public void mo2573a(BluetoothDevice bluetoothDevice) {
        C2538c.m12674b("HuaweiWearableDeviceImpl", "Found BLE BluetoothDevice - " + bluetoothDevice.getName());
        this.f4470a.m7937c(bluetoothDevice);
    }

    public void mo2572a(int i, String str) {
    }

    public void mo2574b() {
    }
}
