package com.huawei.pluginaf500.connect_ble;

import com.huawei.pluginaf500.view.C5828b;

/* compiled from: ScanBleDeviceActivity */
class C5785k implements Runnable {
    final /* synthetic */ ScanBleDeviceActivity f19627a;

    C5785k(ScanBleDeviceActivity scanBleDeviceActivity) {
        this.f19627a = scanBleDeviceActivity;
    }

    public void run() {
        try {
            wait(1000);
        } catch (InterruptedException e) {
        }
        this.f19627a.f19593o = new C5828b(this.f19627a, this.f19627a.f19591m.getRight() - this.f19627a.f19591m.getLeft(), (-this.f19627a.f19591m.getTop()) + this.f19627a.f19591m.getBottom(), ((-this.f19627a.f19591m.getTop()) + this.f19627a.f19591m.getBottom()) / 2, this.f19627a.f19596r);
        if (this.f19627a.f19589k) {
            this.f19627a.f19593o.m26932c();
        }
    }
}
