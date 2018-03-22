package com.huawei.bone.service;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: MessageCenterIntentService */
class C6692b implements IBaseResponseCallback {
    final /* synthetic */ a f22916a;

    C6692b(a aVar) {
        this.f22916a = aVar;
    }

    public void onResponse(int i, Object obj) {
        C2538c.c("MessageCenterIntentService", new Object[]{"Enter sendDataToHealth err_code:" + i});
    }
}
