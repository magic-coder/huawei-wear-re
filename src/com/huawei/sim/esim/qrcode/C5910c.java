package com.huawei.sim.esim.qrcode;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: QrCodeActivity */
class C5910c implements IBaseResponseCallback {
    final /* synthetic */ QrCodeActivity f20258a;

    C5910c(QrCodeActivity qrCodeActivity) {
        this.f20258a = qrCodeActivity;
    }

    public void onResponse(int i, Object obj) {
        C2538c.b(QrCodeActivity.f20205a, new Object[]{"iBaseResponseCallback the error " + i});
    }
}
