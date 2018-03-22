package com.huawei.hwbtsdk.btmanager;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.hwbtsdk.p399a.C4600d;
import com.huawei.hwbtsdk.p399a.C4610m;
import com.huawei.p190v.C2538c;

/* compiled from: BLEAuthenticManager */
class C4644d extends Handler {
    final /* synthetic */ C4633a f16981a;

    public C4644d(C4633a c4633a, Looper looper) {
        this.f16981a = c4633a;
        super(looper);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        C2538c.a("01", 1, "BLEAuthenticManager", new Object[]{"received msg:" + message.what});
        switch (message.what) {
            case 1:
                this.f16981a.f16927i.m22360a(C4610m.m21965a(this.f16981a.f16919a, this.f16981a.f16926h, this.f16981a.f16929k));
                return;
            case 2:
                this.f16981a.f16927i.m22368c();
                return;
            case 3:
                BluetoothDevice bluetoothDevice = (BluetoothDevice) message.obj;
                if (C4600d.m21899a().f16827a != null) {
                    this.f16981a.m22169a(C4600d.m21899a().f16827a, bluetoothDevice);
                    return;
                }
                C2538c.a("0xA0200003", "01", 1, "BLEAuthenticManager", new Object[]{"hid service is null."});
                return;
            case 4:
                this.f16981a.m22181a(this.f16981a.f16926h, this.f16981a.f16930l);
                return;
            case 5:
                this.f16981a.f16927i.m22358a(20);
                if (this.f16981a.f16929k != null) {
                    this.f16981a.f16927i.m22360a(C4610m.m21962a(this.f16981a.f16929k.getDeviceProtocol()));
                    return;
                }
                C2538c.a("0xA0200006", "01", 1, "BLEAuthenticManager", new Object[]{"mBTDeviceInfo is null."});
                return;
            default:
                return;
        }
    }
}
