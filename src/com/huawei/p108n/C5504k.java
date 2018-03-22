package com.huawei.p108n;

import android.os.RemoteException;
import com.huawei.e.b;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.n.c;
import com.huawei.p190v.C2538c;

/* compiled from: HWDeviceConfigManager */
class C5504k extends b {
    final /* synthetic */ IBaseResponseCallback f19402a;
    final /* synthetic */ c f19403b;

    C5504k(c cVar, IBaseResponseCallback iBaseResponseCallback) {
        this.f19403b = cVar;
        this.f19402a = iBaseResponseCallback;
    }

    public void m26271a(int i, String str) throws RemoteException {
        if (this.f19402a != null) {
            C2538c.c("HWDeviceConfigManager", new Object[]{"Enter sendDataToHealth IBaseCommonCallback " + i});
            this.f19402a.onResponse(i, str);
        }
    }
}
