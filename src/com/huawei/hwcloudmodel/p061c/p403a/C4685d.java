package com.huawei.hwcloudmodel.p061c.p403a;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: HealthDataHiCloudClient */
class C4685d implements IBaseResponseCallback {
    final /* synthetic */ C4683b f17101a;

    C4685d(C4683b c4683b) {
        this.f17101a = c4683b;
    }

    public void onResponse(int i, Object obj) {
        if (this.f17101a.m22436b(this.f17101a.f17094b)) {
            C2538c.c("HealthDataHiCloudClient", new Object[]{"logoutWhenStTimeout 1"});
            this.f17101a.m22434b();
            return;
        }
        C2538c.c("HealthDataHiCloudClient", new Object[]{"logoutWhenStTimeout 2"});
    }
}
