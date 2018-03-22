package com.huawei.pluginaf500.p497a;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Handler;
import java.util.UUID;

/* compiled from: BleScanner */
public class C5770a {
    private static final String f19555a = "BleScanner".toString();
    private static String f19556b = "";
    private boolean f19557c = false;
    private boolean f19558d = false;
    private BluetoothAdapter f19559e;
    private Handler f19560f = new Handler();
    private C5773d f19561g;
    private UUID f19562h = new UUID(23296205844446L, 1523193452336828707L);
    private String f19563i;
    private int f19564j = 0;
    private boolean f19565k = true;
    @SuppressLint({"NewApi"})
    private LeScanCallback f19566l = new C5772c(this);

    @SuppressLint({"NewApi"})
    public C5770a(Context context, Handler handler, C5773d c5773d) {
        BluetoothManager bluetoothManager = (BluetoothManager) context.getSystemService("bluetooth");
        if (bluetoothManager != null) {
            this.f19559e = bluetoothManager.getAdapter();
            if (this.f19559e == null) {
                if (handler != null) {
                    this.f19560f = handler;
                }
                this.f19561g = c5773d;
            }
            if (handler != null) {
                this.f19560f = handler;
            }
            this.f19561g = c5773d;
        }
    }

    @SuppressLint({"NewApi"})
    public void m26499a(int i) {
        this.f19558d = true;
        if (this.f19559e != null && !this.f19557c) {
            this.f19559e.startLeScan(this.f19566l);
            this.f19557c = true;
            this.f19564j = 102;
            this.f19560f.postDelayed(new C5771b(this), (long) i);
        }
    }

    @SuppressLint({"NewApi"})
    private void m26490a() {
        if (this.f19557c) {
            this.f19559e.stopLeScan(this.f19566l);
            this.f19557c = false;
            if (this.f19564j != 101) {
                this.f19560f.obtainMessage(102).sendToTarget();
            }
        }
    }

    private void m26493a(String str) {
        f19556b = str;
        this.f19564j = 101;
        m26490a();
        if (!this.f19565k) {
            this.f19565k = true;
            this.f19560f.obtainMessage(101).sendToTarget();
        }
    }
}
