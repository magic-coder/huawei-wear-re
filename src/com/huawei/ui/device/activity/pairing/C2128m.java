package com.huawei.ui.device.activity.pairing;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: DevicePairGuideActivity */
class C2128m implements IBaseResponseCallback {
    final /* synthetic */ DevicePairGuideActivity f7534a;

    C2128m(DevicePairGuideActivity devicePairGuideActivity) {
        this.f7534a = devicePairGuideActivity;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c("DevicePairGuideActivity", "isSupportInHealth err_code:" + i + " objData:" + obj);
        this.f7534a.runOnUiThread(new C2129n(this, i, obj));
    }
}
