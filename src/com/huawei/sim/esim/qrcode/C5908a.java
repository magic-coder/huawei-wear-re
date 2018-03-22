package com.huawei.sim.esim.qrcode;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: QrCodeActivity */
class C5908a implements IBaseResponseCallback {
    final /* synthetic */ QrCodeActivity f20254a;

    C5908a(QrCodeActivity qrCodeActivity) {
        this.f20254a = qrCodeActivity;
    }

    public void onResponse(int i, Object obj) {
        C2538c.b(QrCodeActivity.f20205a, new Object[]{"iAuthResponseCallback the error " + i});
        this.f20254a.f20220p.post(new C5909b(this, i, obj));
    }
}
