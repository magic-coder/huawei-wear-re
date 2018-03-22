package com.huawei.hwbtsdk.btmanager;

import android.bluetooth.BluetoothDevice;
import android.os.Message;
import com.huawei.hwbtsdk.p057b.p058a.C4622e;

/* compiled from: BLEAuthenticManager */
class C4643c implements C4622e {
    final /* synthetic */ C4633a f16980a;

    C4643c(C4633a c4633a) {
        this.f16980a = c4633a;
    }

    public void mo4547a(int i) {
    }

    public void mo4548a(BluetoothDevice bluetoothDevice) {
        this.f16980a.m22165a(2, false);
        Message obtainMessage = this.f16980a.f16921c.obtainMessage(3);
        obtainMessage.obj = bluetoothDevice;
        this.f16980a.f16921c.sendMessageDelayed(obtainMessage, 1000);
    }

    public void mo4549b(int i) {
        if (this.f16980a.f16924f) {
            this.f16980a.f16924f = false;
            this.f16980a.m22180a();
            return;
        }
        this.f16980a.m22181a(this.f16980a.f16926h, this.f16980a.f16930l);
        this.f16980a.f16924f = true;
    }
}
