package com.huawei.p108n;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.n.c;
import com.huawei.p190v.C2538c;

/* compiled from: HWDeviceConfigManager */
class C5501h implements IBaseResponseCallback {
    final /* synthetic */ c f19397a;

    C5501h(c cVar) {
        this.f19397a = cVar;
    }

    public void onResponse(int i, Object obj) {
        byte[] bArr = (byte[]) obj;
        C2538c.c("HWDeviceConfigManager", new Object[]{"FAQ onResponse recv bt data" + C0973a.a(bArr)});
        int c;
        switch (bArr[1]) {
            case (byte) 7:
                c = c.c(this.f19397a, bArr);
                C2538c.c("HWDeviceConfigManager", new Object[]{"FAQ onResponse resCode = " + c});
                if (c.i(this.f19397a) == null) {
                    return;
                }
                if (100000 == c) {
                    c.i(this.f19397a).onResponse(0, Integer.valueOf(c));
                    return;
                } else {
                    c.i(this.f19397a).onResponse(c, Integer.valueOf(c));
                    return;
                }
            case (byte) 8:
                c = c.c(this.f19397a, bArr);
                C2538c.c("HWDeviceConfigManager", new Object[]{"wearpush onResponse resCodeWear = " + c});
                C2538c.c("HWDeviceConfigManager", new Object[]{"wearpush onResponse mWearPushCommandCallBack = " + c.j(this.f19397a)});
                if (c.j(this.f19397a) == null) {
                    return;
                }
                if (100000 == c) {
                    c.j(this.f19397a).onResponse(0, Integer.valueOf(c));
                    return;
                } else {
                    c.j(this.f19397a).onResponse(c, Integer.valueOf(c));
                    return;
                }
            default:
                return;
        }
    }
}
