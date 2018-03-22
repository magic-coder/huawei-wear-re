package com.huawei.ai;

import android.os.RemoteException;

/* compiled from: AuthenticationManager */
class C4014c extends C4013h {
    final /* synthetic */ C4010a f15302a;

    C4014c(C4010a c4010a) {
        this.f15302a = c4010a;
    }

    public void mo4334a(int i, int i2, int i3, byte[] bArr) throws RemoteException {
        this.f15302a.f15296c.sendMessage(this.f15302a.f15296c.obtainMessage(i, i2, i3, bArr));
    }
}
