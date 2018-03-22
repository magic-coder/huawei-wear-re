package com.huawei.hwbtsdk.btmanager.btdeviceservice;

import android.support.annotation.NonNull;
import com.google.android.gms.common.api.C0385x;
import com.google.android.gms.wearable.C0535v;
import com.google.android.gms.wearable.ab;
import com.huawei.p190v.C2538c;

/* compiled from: BTDeviceAWService */
class C0963d implements C0385x<C0535v> {
    final /* synthetic */ ab f1595a;
    final /* synthetic */ C0960a f1596b;

    C0963d(C0960a c0960a, ab abVar) {
        this.f1596b = c0960a;
        this.f1595a = abVar;
    }

    public void m3419a(@NonNull C0535v c0535v) {
        C2538c.m12661a("01", 1, "BTDeviceAWService", "Enter sendMessageAPI onResult");
        if (!c0535v.getStatus().isSuccess()) {
            C2538c.m12672b("01", 1, "BTDeviceAWService", "sendMessageResult is unSuccess so try to use syncDataItem");
            this.f1596b.m3396a(this.f1595a);
        }
    }
}
