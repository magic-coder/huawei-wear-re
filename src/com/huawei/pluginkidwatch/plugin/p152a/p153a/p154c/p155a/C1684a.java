package com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import com.huawei.p190v.C2538c;

@TargetApi(18)
/* compiled from: BLEScanCallback */
public class C1684a implements LeScanCallback {
    private C1686d f4428a;

    public C1684a(C1686d c1686d) {
        this.f4428a = c1686d;
    }

    public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        C2538c.m12674b("BLEScanCallback", "onLeScan called, BLE device found, device name:" + bluetoothDevice.getName());
        this.f4428a.mo2573a(bluetoothDevice);
    }
}
