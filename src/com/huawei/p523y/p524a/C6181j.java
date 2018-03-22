package com.huawei.p523y.p524a;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.p190v.C2538c;

/* compiled from: HWOTAV2Mgr */
class C6181j implements IBaseResponseCallback {
    final /* synthetic */ C6179h f21672a;

    C6181j(C6179h c6179h) {
        this.f21672a = c6179h;
    }

    public void onResponse(int i, Object obj) {
        byte[] bArr = (byte[]) obj;
        if (bArr == null || bArr.length < 2) {
            if (this.f21672a.f21664c != null) {
                try {
                    this.f21672a.f21664c.m25849a(109005, "设备不允许升级");
                } catch (Exception e) {
                    C2538c.e("HWOTAV2Mgr", new Object[]{"Exception e = " + e.getMessage()});
                }
            }
            C6172a.m28560b();
            C2538c.e("HWOTAV2Mgr", new Object[]{"onResponse(), error data, return"});
            return;
        }
        C2538c.b("HWOTAV2Mgr", new Object[]{"Enter mOTAV2ResponseCallback onResponse(),data = " + C0973a.a(bArr)});
        C2538c.c("HWOTAV2Mgr", new Object[]{"当前的command id = " + bArr[1]});
        switch (bArr[1]) {
            case (byte) 1:
                try {
                    this.f21672a.m28613d(this.f21672a.f21665d.m24010b(bArr));
                    return;
                } catch (Exception e2) {
                    C2538c.e("HWOTAV2Mgr", new Object[]{"Exception e = " + e2.getMessage()});
                    return;
                }
            default:
                return;
        }
    }
}
