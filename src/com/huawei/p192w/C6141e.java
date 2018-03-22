package com.huawei.p192w;

import android.os.RemoteException;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;
import com.huawei.w.c;

/* compiled from: HWMultiSimMgr */
class C6141e implements IBaseResponseCallback {
    final /* synthetic */ c f21191a;

    C6141e(c cVar) {
        this.f21191a = cVar;
    }

    public void onResponse(int i, Object obj) {
        C2538c.c("HWMultiSimMgr", new Object[]{"downloadESimProfile onResponse" + i + " objData:" + obj});
        if (c.a(this.f21191a) != null) {
            try {
                c.a(this.f21191a).a(i, null);
            } catch (RemoteException e) {
                C2538c.e("HWMultiSimMgr", new Object[]{"downloadESimProfile excption" + e});
            }
        }
    }
}
