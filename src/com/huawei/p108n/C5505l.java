package com.huawei.p108n;

import android.os.RemoteException;
import com.huawei.e.b;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.n.c;
import com.huawei.p190v.C2538c;

/* compiled from: HWDeviceConfigManager */
class C5505l extends b {
    final /* synthetic */ IBaseResponseCallback f19404a;
    final /* synthetic */ c f19405b;

    C5505l(c cVar, IBaseResponseCallback iBaseResponseCallback) {
        this.f19405b = cVar;
        this.f19404a = iBaseResponseCallback;
    }

    public void m26272a(int i, String str) throws RemoteException {
        if (this.f19404a != null) {
            C2538c.c("HWDeviceConfigManager", new Object[]{"Enter sendLeoSuppoptInHealthFlag IBaseCommonCallback " + i});
            this.f19404a.onResponse(i, str);
        }
    }
}
