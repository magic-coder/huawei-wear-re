package com.huawei.hms.support.api;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.transport.DatagramTransport.C0875a;

/* compiled from: PendingResultImpl */
class C0876b implements C0875a {
    final /* synthetic */ C0871a f1370a;

    C0876b(C0871a c0871a) {
        this.f1370a = c0871a;
    }

    public void mo2254a(int i, IMessageEntity iMessageEntity) {
        this.f1370a.m3060a(i, iMessageEntity);
        this.f1370a.f1363a.countDown();
    }
}
