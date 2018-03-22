package com.huawei.hwbtsdk.p399a;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;

/* compiled from: BTDeviceMgrUtil */
class C4606i extends BroadcastReceiver {
    final /* synthetic */ C4600d f16857a;

    C4606i(C4600d c4600d) {
        this.f16857a = c4600d;
    }

    public void onReceive(Context context, Intent intent) {
        if ("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(intent.getAction())) {
            C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"Receive Headset connect state change msg."});
            int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if (bluetoothDevice == null) {
                C2538c.a("0xA0200006", "01", 1, "BTDeviceMgrUtil", new Object[]{"btDevice is null so return."});
            } else if (this.f16857a.f16842q != null && 2 == intExtra) {
                C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"HFP device connected."});
                this.f16857a.f16842q.mo4551a(bluetoothDevice);
            }
        }
    }
}
