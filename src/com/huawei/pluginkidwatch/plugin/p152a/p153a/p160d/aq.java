package com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d;

import android.bluetooth.BluetoothAdapter;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1684a;

/* compiled from: HuaweiWearableDeviceImpl */
class aq extends Thread {
    final /* synthetic */ an f4471a;

    private aq(an anVar) {
        this.f4471a = anVar;
    }

    public void run() {
        while (this.f4471a.f4462n) {
            if (15 > this.f4471a.f4461m) {
                try {
                    Thread.sleep(1000);
                    this.f4471a.f4461m = this.f4471a.f4461m + 1;
                } catch (Exception e) {
                    C2538c.m12680e("HuaweiWearableDeviceImpl", "Exception e = " + e.getMessage());
                }
            } else {
                m7969a();
                if (this.f4471a.f4451c == null) {
                    this.f4471a.f4451c = BluetoothAdapter.getDefaultAdapter();
                }
                if (this.f4471a.f4457i == null) {
                    this.f4471a.f4457i = new C1684a(this.f4471a.f4468t);
                }
                this.f4471a.f4451c.stopLeScan(this.f4471a.f4457i);
                this.f4471a.m7951i();
            }
        }
    }

    public void m7969a() {
        this.f4471a.f4455g = false;
        this.f4471a.f4462n = false;
        this.f4471a.f4461m = 0;
        this.f4471a.f4463o = null;
    }
}
