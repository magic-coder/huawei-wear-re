package com.huawei.p108n;

import android.os.RemoteException;
import com.huawei.e.b;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.n.c;

/* compiled from: HWDeviceConfigManager */
class C5503j extends b {
    final /* synthetic */ IBaseResponseCallback f19400a;
    final /* synthetic */ c f19401b;

    C5503j(c cVar, IBaseResponseCallback iBaseResponseCallback) {
        this.f19401b = cVar;
        this.f19400a = iBaseResponseCallback;
    }

    public void m26270a(int i, String str) throws RemoteException {
        if (this.f19400a != null) {
            this.f19400a.onResponse(i, str);
        }
    }
}
