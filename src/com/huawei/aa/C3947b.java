package com.huawei.aa;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.p190v.C2538c;

/* compiled from: HWStressMgr */
class C3947b implements IBaseResponseCallback {
    final /* synthetic */ C0973a f15161a;

    C3947b(C0973a aVar) {
        this.f15161a = aVar;
    }

    public void onResponse(int i, Object obj) {
        if (i != 0 || obj == null) {
            C2538c.e("HWStressMgr", new Object[]{"onResponse receive stress data error_code = " + i + ", obj = null"});
            return;
        }
        byte[] bArr = (byte[]) obj;
        C2538c.c("HWStressMgr", new Object[]{"mStressDataCallBack receive data : " + C0973a.a(bArr)});
        switch (bArr[1]) {
            case (byte) 1:
                C0973a.a(this.f15161a, bArr);
                return;
            case (byte) 2:
                C0973a.b(this.f15161a, bArr);
                return;
            case (byte) 3:
                C0973a.c(this.f15161a, bArr);
                return;
            case (byte) 4:
                C0973a.d(this.f15161a, bArr);
                return;
            default:
                return;
        }
    }
}
