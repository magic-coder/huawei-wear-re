package com.huawei.hwbtsdk.p399a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import com.huawei.hwbtsdk.p057b.p058a.C4604c;

@TargetApi(18)
/* compiled from: BLEScanCallback */
public class C4598b implements LeScanCallback {
    private C4604c f16819a = null;

    public C4598b(C4604c c4604c) {
        this.f16819a = c4604c;
    }

    public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        if (this.f16819a != null) {
            this.f16819a.mo4540a(bluetoothDevice);
        }
    }
}
