package com.huawei.ui.device.activity.pairing;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: DevicePairGuideActivity */
class C2131p implements IBaseResponseCallback {
    final /* synthetic */ DevicePairGuideActivity f7539a;

    C2131p(DevicePairGuideActivity devicePairGuideActivity) {
        this.f7539a = devicePairGuideActivity;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c("DevicePairGuideActivity", "isHuaweiHealthBinded err_code:" + i + " objData:" + obj);
        this.f7539a.runOnUiThread(new C2132q(this, i, obj));
    }
}
