package com.huawei.hwbtsdk.btmanager.btdeviceservice;

import com.google.android.gms.wearable.C0569x;
import com.huawei.p190v.C2538c;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: BTDeviceAWService */
class C0967h extends Thread {
    final /* synthetic */ C0960a f1599a;

    C0967h(C0960a c0960a) {
        this.f1599a = c0960a;
    }

    public void run() {
        while (1 == this.f1599a.f1582e.getDeviceConnectState()) {
            Collection a = this.f1599a.m3388i();
            Iterator it = a.iterator();
            C2538c.m12661a("01", 1, "BTDeviceAWService", "StateThread watch names.size() = " + a.size());
            if (a.size() != 0) {
                if (it.hasNext()) {
                    this.f1599a.f1585h = (C0569x) it.next();
                    C2538c.m12661a("01", 1, "BTDeviceAWService", "StateThread found watch：" + this.f1599a.f1585h.getDisplayName());
                    this.f1599a.m3386d(2);
                    break;
                }
            }
            C2538c.m12661a("01", 1, "BTDeviceAWService", "StateThread no watch in iterator");
            this.f1599a.m3386d(4);
            break;
        }
        C2538c.m12661a("01", 1, "BTDeviceAWService", "StateThread search iterator finish");
        this.f1599a.f1581d = null;
    }
}
