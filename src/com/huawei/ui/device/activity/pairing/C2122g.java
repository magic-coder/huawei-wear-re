package com.huawei.ui.device.activity.pairing;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: DevicePairGuideActivity */
class C2122g implements IBaseResponseCallback {
    final /* synthetic */ C2121f f7527a;

    C2122g(C2121f c2121f) {
        this.f7527a = c2121f;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c("DevicePairGuideActivity", "unbindDeviceList Enter callback err_code:" + i);
        this.f7527a.f7526a.runOnUiThread(new C2123h(this));
    }
}
