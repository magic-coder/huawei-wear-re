package com.huawei.hwservicesmgr.p076a.p078b;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwservicesmgr.a.b.d;
import com.huawei.p190v.C2538c;

/* compiled from: HWFileTransferTaskManager */
class C5336i implements IBaseResponseCallback {
    final /* synthetic */ d f19077a;

    C5336i(d dVar) {
        this.f19077a = dVar;
    }

    public void onResponse(int i, Object obj) {
        C2538c.c("HWFileTransferTaskManager", new Object[]{"save2File onResponse."});
        this.f19077a.c();
    }
}