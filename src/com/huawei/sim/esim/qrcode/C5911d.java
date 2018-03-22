package com.huawei.sim.esim.qrcode;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: QrCodeActivity */
class C5911d implements IBaseResponseCallback {
    final /* synthetic */ QrCodeActivity f20259a;

    C5911d(QrCodeActivity qrCodeActivity) {
        this.f20259a = qrCodeActivity;
    }

    public void onResponse(int i, Object obj) {
        C2538c.b(QrCodeActivity.f20205a, new Object[]{"err_code " + i});
    }
}
