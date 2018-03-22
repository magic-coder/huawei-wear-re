package com.huawei.hwbtsdk.btmanager.btdeviceservice;

import com.google.android.gms.common.api.C0385x;
import com.google.android.gms.wearable.C0548k;
import com.huawei.p190v.C2538c;

/* compiled from: BTDeviceAWService */
class C0962c implements C0385x<C0548k> {
    final /* synthetic */ C0960a f1594a;

    C0962c(C0960a c0960a) {
        this.f1594a = c0960a;
    }

    public void m3417a(C0548k c0548k) {
        boolean isSuccess = c0548k.getStatus().isSuccess();
        C2538c.m12661a("01", 1, "BTDeviceAWService", "syncDataItem() Sending image was successful: " + isSuccess);
    }
}
