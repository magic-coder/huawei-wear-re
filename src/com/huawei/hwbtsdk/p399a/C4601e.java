package com.huawei.hwbtsdk.p399a;

import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothInputDevice;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile.ServiceListener;

/* compiled from: BTDeviceMgrUtil */
class C4601e implements ServiceListener {
    final /* synthetic */ C4600d f16850a;

    C4601e(C4600d c4600d) {
        this.f16850a = c4600d;
    }

    public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
        switch (i) {
            case 1:
                this.f16850a.f16830e = (BluetoothHeadset) bluetoothProfile;
                return;
            case 4:
                this.f16850a.f16827a = (BluetoothInputDevice) bluetoothProfile;
                return;
            default:
                return;
        }
    }

    public void onServiceDisconnected(int i) {
        switch (i) {
            case 1:
                this.f16850a.f16830e = null;
                return;
            case 4:
                this.f16850a.f16827a = null;
                return;
            default:
                return;
        }
    }
}
