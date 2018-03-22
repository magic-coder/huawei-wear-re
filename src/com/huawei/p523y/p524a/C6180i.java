package com.huawei.p523y.p524a;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.p190v.C2538c;

/* compiled from: HWOTAV2Mgr */
class C6180i implements IBaseResponseCallback {
    final /* synthetic */ C6179h f21671a;

    C6180i(C6179h c6179h) {
        this.f21671a = c6179h;
    }

    public void onResponse(int i, Object obj) {
        byte[] bArr = (byte[]) obj;
        if (bArr == null || bArr.length < 2) {
            C2538c.e("HWOTAV2Mgr", new Object[]{"onResponse(), error data, return"});
            return;
        }
        C2538c.c("HWOTAV2Mgr", new Object[]{"Enter mOTAV2ResponseCallback onResponse(),data = " + C0973a.a(bArr)});
        C2538c.c("HWOTAV2Mgr", new Object[]{"当前的command id = " + bArr[1]});
        switch (bArr[1]) {
            case (byte) 1:
                try {
                    this.f21671a.m28604a((Object) this.f21671a.f21665d.m24010b(bArr));
                    return;
                } catch (Exception e) {
                    C2538c.e("HWOTAV2Mgr", new Object[]{"Exception e = " + e.getMessage()});
                }
            case (byte) 2:
                this.f21671a.m28611c(this.f21671a.f21665d.m24012c(bArr));
                return;
            case Byte.MAX_VALUE:
                this.f21671a.m28608b(this.f21671a.f21665d.m24008a(bArr));
                return;
            default:
                return;
        }
        C2538c.e("HWOTAV2Mgr", new Object[]{"Exception e = " + e.getMessage()});
    }
}
