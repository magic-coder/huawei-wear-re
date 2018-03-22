package com.huawei.hwbtsdk.btmanager.btdeviceservice;

import android.bluetooth.BluetoothDevice;
import com.huawei.hwbtsdk.p057b.p058a.C4622e;
import com.huawei.p190v.C2538c;

/* compiled from: BTDeviceBRService */
class C4640n implements C4622e {
    final /* synthetic */ C4639m f16972a;

    C4640n(C4639m c4639m) {
        this.f16972a = c4639m;
    }

    public void mo4547a(int i) {
    }

    public void mo4548a(BluetoothDevice bluetoothDevice) {
        C2538c.a("01", 1, "BTDeviceBRService", new Object[]{"btDevice paired."});
        this.f16972a.f16967h = false;
        if (!this.f16972a.f16969j.m21942b(bluetoothDevice)) {
            C2538c.a("01", 1, "BTDeviceBRService", new Object[]{"Need to connect hfp profile."});
            this.f16972a.f16967h = true;
            this.f16972a.f16969j.m21948c(bluetoothDevice);
        }
        C2538c.a("01", 1, "BTDeviceBRService", new Object[]{"Start to connect btDevice."});
        this.f16972a.m22234b(bluetoothDevice);
    }

    public void mo4549b(int i) {
        C2538c.a("01", 1, "BTDeviceBRService", new Object[]{"btDevice pair fail, so connect btDevice fail."});
        this.f16972a.m22245a(4);
    }
}
