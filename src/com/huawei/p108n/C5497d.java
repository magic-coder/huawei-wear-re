package com.huawei.p108n;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.n.c;
import com.huawei.p190v.C2538c;

/* compiled from: HWDeviceConfigManager */
class C5497d implements IBaseResponseCallback {
    final /* synthetic */ c f19390a;

    C5497d(c cVar) {
        this.f19390a = cVar;
    }

    public void onResponse(int i, Object obj) {
        byte[] bArr = (byte[]) obj;
        C2538c.c("HWDeviceConfigManager", new Object[]{"onResponse recv bt data" + C0973a.a(bArr)});
        switch (bArr[1]) {
            case (byte) 2:
                c.a(this.f19390a, bArr);
                return;
            default:
                return;
        }
    }
}
