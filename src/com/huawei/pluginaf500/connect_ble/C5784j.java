package com.huawei.pluginaf500.connect_ble;

import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;

/* compiled from: BleDeviceScan */
class C5784j implements LeScanCallback {
    final /* synthetic */ C5782h f19626a;

    C5784j(C5782h c5782h) {
        this.f19626a = c5782h;
    }

    public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        String name = bluetoothDevice.getName();
        if (name == null) {
            C5788n.m26581a();
            name = C5788n.m26582a(bArr);
        }
        if ((name == null || name.equals("") || name.startsWith("AF") || name.startsWith("ColorBand")) && i > this.f19626a.f19618a) {
            this.f19626a.f19618a = i;
            if (!this.f19626a.f19619b.equals(bluetoothDevice.getAddress())) {
                this.f19626a.f19619b = bluetoothDevice.getAddress();
                this.f19626a.f19622e.add(bluetoothDevice.getAddress());
                if (name == null || name.equals("")) {
                    name = "ColorBand";
                }
                this.f19626a.f19621d.obtainMessage(3, new BleDeviceInfo(name, bluetoothDevice.getAddress(), 2, i)).sendToTarget();
            }
        }
    }
}
