package com.huawei.hms.support.api;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.transport.DatagramTransport.C0875a;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: PendingResultImpl */
class C0877c implements C0875a {
    final /* synthetic */ AtomicBoolean f1371a;
    final /* synthetic */ C0871a f1372b;

    C0877c(C0871a c0871a, AtomicBoolean atomicBoolean) {
        this.f1372b = c0871a;
        this.f1371a = atomicBoolean;
    }

    public void mo2254a(int i, IMessageEntity iMessageEntity) {
        if (!this.f1371a.get()) {
            this.f1372b.m3060a(i, iMessageEntity);
        }
        this.f1372b.f1363a.countDown();
    }
}
