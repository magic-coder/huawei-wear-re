package com.huawei.hwbtsdk.p399a;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;

/* compiled from: BTDeviceMgrUtil */
class C4607j extends BroadcastReceiver {
    final /* synthetic */ C4600d f16858a;

    C4607j(C4600d c4600d) {
        this.f16858a = c4600d;
    }

    public void onReceive(Context context, Intent intent) {
        if ("android.bluetooth.device.action.BOND_STATE_CHANGED".equals(intent.getAction())) {
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if (bluetoothDevice == null) {
                C2538c.a("0xA0200006", "01", 1, "BTDeviceMgrUtil", new Object[]{"btDevice is null."});
            } else if (10 == bluetoothDevice.getBondState()) {
                C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"Device is unPaired."});
                if (this.f16858a.f16843s != null) {
                    this.f16858a.f16843s.mo4601a(bluetoothDevice.getAddress());
                    return;
                }
                C2538c.a("0xA0200008", "01", 1, "BTDeviceMgrUtil", new Object[]{"mBTDeviceBondStateCallback is null."});
            }
        }
    }
}
