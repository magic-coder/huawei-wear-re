package com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d;

import com.huawei.p190v.C2538c;

/* compiled from: BluetoothLEConnectService */
class C1715u extends Thread {
    final /* synthetic */ C1705k f4587a;

    private C1715u(C1705k c1705k) {
        this.f4587a = c1705k;
    }

    public void run() {
        super.run();
        C2538c.m12674b("BluetoothLEConnectService", "进入链接超时线程    ThreadId=" + Thread.currentThread().getId() + " connectServicesFlag = " + this.f4587a.f4572w);
        while (this.f4587a.f4572w) {
            C2538c.m12674b("BluetoothLEConnectService", "进入链接超时线程循环 connectServicesNum = " + this.f4587a.f4573x);
            try {
                if (20 != this.f4587a.f4573x) {
                    this.f4587a.f4573x = this.f4587a.f4573x + 1;
                    Thread.sleep(1000);
                } else if (this.f4587a.f4574y) {
                    this.f4587a.f4574y = false;
                    this.f4587a.f4573x = 0;
                    this.f4587a.m8106d(true);
                } else {
                    this.f4587a.f4574y = true;
                    m8152a();
                    this.f4587a.m8106d(false);
                }
            } catch (InterruptedException e) {
                C2538c.m12680e("BluetoothLEConnectService", "Exception e = " + e.getMessage());
                this.f4587a.f4572w = false;
                this.f4587a.f4573x = 0;
                this.f4587a.f4574y = true;
                this.f4587a.m8106d(true);
            }
        }
    }

    public void m8152a() {
        this.f4587a.f4572w = false;
        this.f4587a.f4543J = null;
        this.f4587a.f4573x = 0;
        this.f4587a.f4574y = true;
        C2538c.m12674b("BluetoothLEConnectService", "停止连接超时线程");
    }
}
