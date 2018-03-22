package com.huawei.p192w;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.p190v.C2538c;
import com.huawei.w.c;

/* compiled from: HWMultiSimMgr */
class C6140d implements IBaseResponseCallback {
    final /* synthetic */ c f21190a;

    C6140d(c cVar) {
        this.f21190a = cVar;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0 && obj != null) {
            byte[] bArr = (byte[]) obj;
            C2538c.c("HWMultiSimMgr", new Object[]{"onResponse recv bt data" + C0973a.a(bArr)});
            switch (bArr[1]) {
                case (byte) 1:
                    c.a(this.f21190a, bArr);
                    return;
                case (byte) 2:
                    c.c(this.f21190a, bArr);
                    return;
                case (byte) 3:
                    c.b(this.f21190a, bArr);
                    return;
                case (byte) 4:
                    c.d(this.f21190a, bArr);
                    return;
                case (byte) 6:
                    c.e(this.f21190a, bArr);
                    return;
                case (byte) 7:
                    c.a(this.f21190a, bArr, 7);
                    return;
                case (byte) 8:
                    c.a(this.f21190a, bArr, 8);
                    return;
                case (byte) 9:
                    c.f(this.f21190a, bArr);
                    return;
                default:
                    C2538c.e("HWMultiSimMgr", new Object[]{"unknow command id:" + bArr[1]});
                    return;
            }
        }
    }
}
