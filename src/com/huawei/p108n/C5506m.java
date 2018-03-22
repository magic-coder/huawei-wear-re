package com.huawei.p108n;

import android.os.RemoteException;
import com.huawei.e.b;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.n.c;
import com.huawei.p190v.C2538c;

/* compiled from: HWDeviceConfigManager */
class C5506m extends b {
    final /* synthetic */ IBaseResponseCallback f19406a;
    final /* synthetic */ int f19407b;
    final /* synthetic */ c f19408c;

    C5506m(c cVar, IBaseResponseCallback iBaseResponseCallback, int i) {
        this.f19408c = cVar;
        this.f19406a = iBaseResponseCallback;
        this.f19407b = i;
    }

    public void m26273a(int i, String str) throws RemoteException {
        if (this.f19406a != null) {
            C2538c.c("HWDeviceConfigManager", new Object[]{"Enter getCommonData IBaseCommonCallback commonType :" + this.f19407b + "error:" + i + "reason:" + str});
            this.f19406a.onResponse(i, str);
        }
    }
}
