package com.huawei.hwservicesmgr.p076a.p078b;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwservicesmgr.a.b.d;
import com.huawei.p190v.C2538c;

/* compiled from: HWFileTransferTaskManager */
class C5338k implements IBaseResponseCallback {
    final /* synthetic */ d f19079a;

    C5338k(d dVar) {
        this.f19079a = dVar;
    }

    public void onResponse(int i, Object obj) {
        C2538c.c("HWFileTransferTaskManager", new Object[]{"addSleepDataFromAndroidWear MaintenanceUtil save2File onResponse."});
        d.a(this.f19079a).sendEmptyMessage(10);
    }
}
