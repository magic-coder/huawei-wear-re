package com.huawei.hwbtsdk.btmanager;

import android.bluetooth.BluetoothDevice;
import com.huawei.hwbtsdk.p057b.p058a.C4622e;
import com.huawei.hwbtsdk.p399a.C4600d;
import com.huawei.p190v.C2538c;

/* compiled from: BLEAuthenticManager */
class C4634b implements Runnable {
    final /* synthetic */ BluetoothDevice f16931a;
    final /* synthetic */ C4622e f16932b;
    final /* synthetic */ C4633a f16933c;

    C4634b(C4633a c4633a, BluetoothDevice bluetoothDevice, C4622e c4622e) {
        this.f16933c = c4633a;
        this.f16931a = bluetoothDevice;
        this.f16932b = c4622e;
    }

    public void run() {
        boolean a = C4600d.m21899a().m21936a(this.f16931a, this.f16932b);
        this.f16933c.f16924f = true;
        if (!a) {
            this.f16933c.f16924f = false;
            this.f16933c.m22180a();
        }
        C2538c.a("01", 1, "BLEAuthenticManager", new Object[]{"pairDevice() postDelayed, result = " + a + " pairDeviceFlag = " + this.f16933c.f16924f});
    }
}
