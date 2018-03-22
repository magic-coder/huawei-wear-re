package com.huawei.hwbtsdk.btmanager;

import android.bluetooth.BluetoothDevice;
import android.os.Message;
import com.huawei.hwbtsdk.p057b.p058a.C4604c;
import com.huawei.p190v.C2538c;

/* compiled from: BLEReconnectManager */
class C4646f implements C4604c {
    final /* synthetic */ C4645e f16991a;

    C4646f(C4645e c4645e) {
        this.f16991a = c4645e;
    }

    public void mo4540a(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return;
        }
        if (this.f16991a.m22274b(bluetoothDevice.getAddress())) {
            C2538c.c("01", 0, "BLEReconnectManager", new Object[]{"onDeviceDiscovered with find device but need check."});
            this.f16991a.m22270a(this.f16991a.f16986e.getDeviceIdentify(), bluetoothDevice, bluetoothDevice.getAddress());
            return;
        }
        C2538c.a("01", 1, "BLEReconnectManager", new Object[]{"User disabled current device, so do not need  to connect wanted device."});
    }

    public void mo4539a() {
        C2538c.a("01", 1, "BLEReconnectManager", new Object[]{"BLE reconnect device discovery finished."});
        if (this.f16991a.f16986e == null) {
            return;
        }
        if (this.f16991a.m22274b(this.f16991a.f16986e.getDeviceIdentify())) {
            C2538c.c("01", 0, "BLEReconnectManager", new Object[]{"User do not disable current device, so start to connect wanted device."});
            this.f16991a.f16988g.removeMessages(1);
            long c = (long) this.f16991a.m22279e();
            Message obtainMessage = this.f16991a.f16988g.obtainMessage(1, this.f16991a.f16986e);
            c.a("01", 1, "BLEReconnectManager", new Object[]{"Do not find the wanted device so start a new reconnect process with delay Millis = " + c});
            this.f16991a.f16988g.sendMessageDelayed(obtainMessage, c);
            return;
        }
        C2538c.a("01", 1, "BLEReconnectManager", new Object[]{"User disabled current device, so do not need  to connect wanted device."});
    }

    public void mo4541b() {
        C2538c.a("01", 1, "BLEReconnectManager", new Object[]{"BLE discovery canceled."});
    }
}
