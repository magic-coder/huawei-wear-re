package com.huawei.hwservicesmgr.p076a.p078b;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwservicesmgr.a.b.d;
import com.huawei.p190v.C2538c;

/* compiled from: HWFileTransferTaskManager */
class C5337j implements IBaseResponseCallback {
    final /* synthetic */ d f19078a;

    C5337j(d dVar) {
        this.f19078a = dVar;
    }

    public void onResponse(int i, Object obj) {
        C2538c.c("HWFileTransferTaskManager", new Object[]{"addSleepDataFromAndroidWear DetailSleepUtil save2File onResponse."});
        d.a(this.f19078a).sendEmptyMessage(10);
    }
}
