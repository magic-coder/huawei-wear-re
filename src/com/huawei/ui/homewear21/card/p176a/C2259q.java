package com.huawei.ui.homewear21.card.p176a;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: NotificationCardInteractors */
class C2259q implements IBaseResponseCallback {
    final /* synthetic */ String f8207a;
    final /* synthetic */ C2254l f8208b;

    C2259q(C2254l c2254l, String str) {
        this.f8208b = c2254l;
        this.f8207a = str;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c("FAQ", "pushMessageToDevice onResponse err_code = " + i + "  msgID = " + this.f8207a);
        if (i == 0) {
            this.f8208b.f8194c.m10248a(this.f8207a);
        }
        if (this.f8208b.f8195d != null) {
            this.f8208b.f8195d.removeCallbacks(this.f8208b.f8202l);
            this.f8208b.f8195d.postDelayed(this.f8208b.f8202l, 5000);
        }
    }
}
