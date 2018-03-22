package com.huawei.hms.support.api;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.C0871a.C0872a;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.transport.DatagramTransport.C0875a;

/* compiled from: PendingResultImpl */
class C0878d implements C0875a {
    final /* synthetic */ C0872a f1379a;
    final /* synthetic */ ResultCallback f1380b;
    final /* synthetic */ C0871a f1381c;

    C0878d(C0871a c0871a, C0872a c0872a, ResultCallback resultCallback) {
        this.f1381c = c0871a;
        this.f1379a = c0872a;
        this.f1380b = resultCallback;
    }

    public void mo2254a(int i, IMessageEntity iMessageEntity) {
        this.f1381c.m3060a(i, iMessageEntity);
        this.f1379a.m3064a(this.f1380b, this.f1381c.f1364b);
    }
}
