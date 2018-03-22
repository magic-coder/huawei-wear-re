package com.huawei.ui.device.activity.adddevice;

import com.huawei.hwbasemgr.IBaseResponseCallback;

/* compiled from: AddDeviceActivity */
class C2001c implements IBaseResponseCallback {
    final /* synthetic */ C2000b f7039a;

    C2001c(C2000b c2000b) {
        this.f7039a = c2000b;
    }

    public void onResponse(int i, Object obj) {
        this.f7039a.f7037a.shutdownNow();
    }
}
