package com.huawei.ui.homewear21.p175a;

import android.os.Bundle;
import com.huawei.p190v.C2538c;
import com.huawei.up.b.a;

/* compiled from: LeftMenuFragment */
class cl implements a {
    final /* synthetic */ cf f8129a;

    cl(cf cfVar) {
        this.f8129a = cfVar;
    }

    public void m11596a(Bundle bundle) {
        C2538c.m12674b("LeftMenuFragment", "get new headImg and name from cloud success.");
        this.f8129a.f8121o.sendEmptyMessage(3);
    }

    public void m11595a(int i) {
        C2538c.m12679d("LeftMenuFragment", "get new headImg and name from cloud failure.");
        if (40 == i) {
            this.f8129a.f8121o.sendEmptyMessage(2);
        }
    }
}
