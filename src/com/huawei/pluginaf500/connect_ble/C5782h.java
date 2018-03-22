package com.huawei.pluginaf500.connect_ble;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.os.Handler;
import java.util.HashSet;
import java.util.Set;

/* compiled from: BleDeviceScan */
public class C5782h {
    private int f19618a = -1000;
    private String f19619b = "";
    private BluetoothAdapter f19620c;
    private Handler f19621d;
    private Set<String> f19622e = new HashSet();
    private boolean f19623f = false;
    @SuppressLint({"NewApi"})
    private LeScanCallback f19624g = new C5784j(this);

    public C5782h(BluetoothAdapter bluetoothAdapter, Handler handler) {
        this.f19620c = bluetoothAdapter;
        this.f19621d = handler;
    }

    @SuppressLint({"NewApi"})
    public void m26579a(boolean z) {
        if (z) {
            this.f19621d.postDelayed(new C5783i(this), 8000);
            if (!this.f19623f) {
                this.f19618a = -1000;
                this.f19619b = "";
                this.f19620c.startLeScan(this.f19624g);
                this.f19623f = true;
                this.f19621d.obtainMessage(0).sendToTarget();
            }
        } else if (this.f19623f) {
            this.f19620c.stopLeScan(this.f19624g);
            this.f19621d.obtainMessage(1).sendToTarget();
            this.f19622e.clear();
            this.f19623f = false;
        }
    }
}
