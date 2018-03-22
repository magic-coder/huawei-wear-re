package com.huawei.pluginaf500.p497a;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import com.huawei.pluginaf500.connect_ble.C5788n;

/* compiled from: BleScanner */
class C5772c implements LeScanCallback {
    final /* synthetic */ C5770a f19568a;

    C5772c(C5770a c5770a) {
        this.f19568a = c5770a;
    }

    @SuppressLint({"DefaultLocale"})
    public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        Object obj = null;
        if (bluetoothDevice != null) {
            obj = bluetoothDevice.getName();
        }
        if (obj == null) {
            C5788n.m26581a();
            obj = C5788n.m26582a(bArr);
        }
        if (obj != null) {
            obj = obj.toUpperCase();
        }
        if (this.f19568a.f19561g == C5773d.DFU_SCAN) {
            if (bluetoothDevice == null) {
                return;
            }
            if (this.f19568a.f19558d) {
                C5788n a = C5788n.m26581a();
                try {
                    a.m26587a(bArr, this.f19568a.f19562h);
                    if (a.m26588b() && "AF500DFU".equals(obj)) {
                        this.f19568a.m26493a(bluetoothDevice.getAddress());
                    }
                } catch (Exception e) {
                }
            } else if ("AF500DFU".equals(obj)) {
                this.f19568a.m26493a(bluetoothDevice.getAddress());
            }
        } else if (this.f19568a.f19561g == C5773d.ST_SCAN) {
            if (bluetoothDevice != null && this.f19568a.f19563i != null) {
                if (this.f19568a.f19563i.equals(bluetoothDevice.getAddress())) {
                    this.f19568a.f19564j = 101;
                    this.f19568a.m26490a();
                    this.f19568a.f19560f.obtainMessage(101).sendToTarget();
                }
            }
        } else if (this.f19568a.f19561g == C5773d.NORMAL_SCAN && bluetoothDevice != null) {
            if (this.f19568a.f19563i.equals(bluetoothDevice.getAddress())) {
                this.f19568a.f19564j = 101;
                this.f19568a.m26490a();
                this.f19568a.f19560f.obtainMessage(101).sendToTarget();
            }
        }
    }
}
