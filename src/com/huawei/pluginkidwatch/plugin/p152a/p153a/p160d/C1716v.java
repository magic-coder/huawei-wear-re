package com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d;

import com.huawei.p190v.C2538c;

/* compiled from: BluetoothLEConnectService */
class C1716v extends Thread {
    final /* synthetic */ C1705k f4588a;

    private C1716v(C1705k c1705k) {
        this.f4588a = c1705k;
    }

    public void run() {
        super.run();
        C2538c.m12674b("BluetoothLEConnectService", "进入发现服务超时线程    ThreadId=" + Thread.currentThread().getId() + " discoverServicesFlag = " + this.f4588a.f4569t);
        while (this.f4588a.f4569t) {
            C2538c.m12674b("BluetoothLEConnectService", "进入发现服务超时线程循环 discoverServicesNum = " + this.f4588a.f4570u);
            try {
                if (20 != this.f4588a.f4570u) {
                    this.f4588a.f4570u = this.f4588a.f4570u + 1;
                    Thread.sleep(1000);
                } else if (this.f4588a.f4571v) {
                    this.f4588a.f4571v = false;
                    this.f4588a.f4570u = 0;
                    this.f4588a.m8106d(true);
                } else {
                    this.f4588a.f4571v = true;
                    m8153a();
                    this.f4588a.m8106d(false);
                }
            } catch (InterruptedException e) {
                C2538c.m12680e("BluetoothLEConnectService", "Exception e = " + e.getMessage());
                this.f4588a.f4569t = false;
                this.f4588a.f4570u = 0;
                this.f4588a.f4571v = true;
                this.f4588a.m8106d(true);
            }
        }
    }

    public void m8153a() {
        this.f4588a.f4569t = false;
        this.f4588a.f4542I = null;
        this.f4588a.f4570u = 0;
        this.f4588a.f4571v = true;
        C2538c.m12674b("BluetoothLEConnectService", "停止发现服务超时线程");
    }
}
