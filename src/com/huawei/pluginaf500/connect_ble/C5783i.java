package com.huawei.pluginaf500.connect_ble;

import android.annotation.SuppressLint;

/* compiled from: BleDeviceScan */
class C5783i implements Runnable {
    final /* synthetic */ C5782h f19625a;

    C5783i(C5782h c5782h) {
        this.f19625a = c5782h;
    }

    @SuppressLint({"NewApi"})
    public void run() {
        if (this.f19625a.f19623f) {
            this.f19625a.f19621d.obtainMessage(1).sendToTarget();
            this.f19625a.f19620c.stopLeScan(this.f19625a.f19624g);
            this.f19625a.f19622e.clear();
            this.f19625a.f19623f = false;
        }
    }
}
