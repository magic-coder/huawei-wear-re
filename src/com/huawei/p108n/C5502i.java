package com.huawei.p108n;

import android.os.RemoteException;
import com.huawei.e.k;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.n.c;

/* compiled from: HWDeviceConfigManager */
class C5502i extends k {
    final /* synthetic */ IBaseResponseCallback f19398a;
    final /* synthetic */ c f19399b;

    C5502i(c cVar, IBaseResponseCallback iBaseResponseCallback) {
        this.f19399b = cVar;
        this.f19398a = iBaseResponseCallback;
    }

    public void m26269a(int i, int i2) throws RemoteException {
        if (this.f19398a != null) {
            this.f19398a.onResponse(i, "" + i2);
        }
    }
}
