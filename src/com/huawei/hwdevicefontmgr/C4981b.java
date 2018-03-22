package com.huawei.hwdevicefontmgr;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: HWDeviceFontManager */
class C4981b implements IBaseResponseCallback {
    final /* synthetic */ a f18064a;

    C4981b(a aVar) {
        this.f18064a = aVar;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0) {
            C2538c.e("HWDeviceFontManager", new Object[]{"iBaseResponseCallback-> err_code = " + i + " value = " + obj});
            return;
        }
        C2538c.e("HWDeviceFontManager", new Object[]{"onResponse recv bt data ret=" + i});
    }
}
