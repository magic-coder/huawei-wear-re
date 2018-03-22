package com.huawei.hwservicesmgr.p076a.p078b;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwservicesmgr.a.b.d;
import com.huawei.p190v.C2538c;

/* compiled from: HWFileTransferTaskManager */
class C5335h implements IBaseResponseCallback {
    final /* synthetic */ d f19076a;

    C5335h(d dVar) {
        this.f19076a = dVar;
    }

    public void onResponse(int i, Object obj) {
        C2538c.c("HWFileTransferTaskManager", new Object[]{"save2File onResponse."});
        d.a(this.f19076a).sendEmptyMessage(10);
    }
}
