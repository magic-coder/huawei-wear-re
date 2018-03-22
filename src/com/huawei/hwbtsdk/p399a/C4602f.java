package com.huawei.hwbtsdk.p399a;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;

/* compiled from: BTDeviceMgrUtil */
class C4602f extends BroadcastReceiver {
    final /* synthetic */ C4600d f16851a;

    C4602f(C4600d c4600d) {
        this.f16851a = c4600d;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        BluetoothDevice bluetoothDevice;
        if ("android.bluetooth.device.action.FOUND".equals(action)) {
            bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if (bluetoothDevice != null && 12 != bluetoothDevice.getBondState() && 2 != bluetoothDevice.getType()) {
                this.f16851a.f16834i.add(bluetoothDevice);
                synchronized (C4600d.f16825v) {
                    if (this.f16851a.f16832g != null) {
                        this.f16851a.f16832g.mo4540a(bluetoothDevice);
                    }
                }
            }
        } else if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(action)) {
            C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"Enter ACTION_DISCOVERY_FINISHED."});
            synchronized (C4600d.f16825v) {
                if (this.f16851a.f16832g != null) {
                    this.f16851a.f16832g.mo4539a();
                }
            }
        } else if ("android.bluetooth.device.action.BOND_STATE_CHANGED".equals(action)) {
            bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if (bluetoothDevice == null) {
                return;
            }
            if (12 == bluetoothDevice.getBondState()) {
                if (this.f16851a.f16840o != null) {
                    this.f16851a.f16840o.mo4548a(bluetoothDevice);
                }
                this.f16851a.f16828b.unregisterReceiver(this.f16851a.f16846w);
            } else if (11 == bluetoothDevice.getBondState()) {
                if (this.f16851a.f16840o != null) {
                    this.f16851a.f16840o.mo4547a(11);
                }
            } else if (10 == bluetoothDevice.getBondState() && this.f16851a.f16840o != null) {
                this.f16851a.f16840o.mo4549b(10);
            }
        }
    }
}
