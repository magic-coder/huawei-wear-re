package com.huawei.hwbtsdk.btmanager.btdeviceservice;

import com.google.android.gms.common.api.C0385x;
import com.google.android.gms.common.api.Status;
import com.huawei.p190v.C2538c;

/* compiled from: BTDeviceAWService */
class C0964e implements C0385x<Status> {
    final /* synthetic */ C0960a f1597a;

    C0964e(C0960a c0960a) {
        this.f1597a = c0960a;
    }

    public void m3420a(Status status) {
        C2538c.m12661a("01", 1, "BTDeviceAWService", "Wearable.NodeApi.removeListener onResult() = " + status);
    }
}
