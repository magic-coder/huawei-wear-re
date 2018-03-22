package com.huawei.hwbtsdk.p399a;

import android.bluetooth.BluetoothAdapter;
import com.huawei.p190v.C2538c;

/* compiled from: BTDeviceMgrUtil */
class C4609l extends Thread {
    final /* synthetic */ C4600d f16860a;

    private C4609l(C4600d c4600d) {
        this.f16860a = c4600d;
    }

    public void run() {
        int i = 0;
        while (!this.f16860a.f16839n) {
            if (15 > i) {
                try {
                    Thread.sleep(1000);
                    i++;
                } catch (Exception e) {
                    C2538c.a("0xA0200006", "01", 1, "BTDeviceMgrUtil", new Object[]{"stop ble discover with sleep occur exception."});
                }
            } else {
                C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"Start to stop ble discover for time arrive."});
                m21960a(2);
            }
        }
    }

    public void m21960a(int i) {
        this.f16860a.f16836k = false;
        this.f16860a.f16839n = true;
        this.f16860a.f16838m = null;
        if (this.f16860a.f16833h == null) {
            this.f16860a.f16833h = new C4598b(this.f16860a.f16847x);
        }
        if (this.f16860a.f16829c == null) {
            this.f16860a.f16829c = BluetoothAdapter.getDefaultAdapter();
        }
        C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"Start to stopLeScan."});
        this.f16860a.f16829c.stopLeScan(this.f16860a.f16833h);
        synchronized (C4600d.f16825v) {
            if (this.f16860a.f16832g != null) {
                if (1 == i) {
                    C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"Start to report ble discover cancel."});
                    this.f16860a.f16832g.mo4541b();
                } else if (2 == i) {
                    C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"Start to report ble discover finish."});
                    this.f16860a.f16832g.mo4539a();
                } else {
                    C2538c.a("0xA0200006", "01", 1, "BTDeviceMgrUtil", new Object[]{"BLE scan handle type is incorrect."});
                }
                this.f16860a.f16832g = null;
            }
        }
    }
}
