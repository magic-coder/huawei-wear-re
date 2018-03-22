package com.huawei.pluginaf500.connect_ble;

import com.huawei.p032e.p264a.p265a.p266b.C4387c;
import com.huawei.p190v.C2538c;

/* compiled from: AF500DeviceMgr */
class C5776b implements C4387c {
    final /* synthetic */ C5775a f19611a;

    C5776b(C5775a c5775a) {
        this.f19611a = c5775a;
    }

    public void mo5110a(int i) {
        C2538c.c("AF500DeviceMgr", new Object[]{"AF500 Device connect state change with state = " + i});
        this.f19611a.m26546a(i);
    }

    public void mo5111a(int i, byte[] bArr) {
    }
}
