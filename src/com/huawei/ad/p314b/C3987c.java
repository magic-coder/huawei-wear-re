package com.huawei.ad.p314b;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.p190v.C2538c;

/* compiled from: HWWeatherMgr */
class C3987c implements IBaseResponseCallback {
    final /* synthetic */ C3985a f15239a;

    C3987c(C3985a c3985a) {
        this.f15239a = c3985a;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0) {
            byte[] bArr = (byte[]) obj;
            C2538c.c("HWWeatherMgr", new Object[]{"onResponse BT data---------" + C0973a.a(bArr)});
            switch (bArr[1]) {
                case (byte) 2:
                    this.f15239a.m19736a(this.f15239a.m19734a(this.f15239a.f15236e, this.f15239a.m19728a(bArr[4])));
                    return;
                default:
                    return;
            }
        }
        C2538c.e("HWWeatherMgr", new Object[]{"onResponse BT data err_code=" + i});
    }
}
