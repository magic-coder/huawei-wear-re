package com.huawei.ui.homewear21.p175a;

import android.os.Bundle;
import com.huawei.p190v.C2538c;
import com.huawei.up.b.a;

/* compiled from: LeftMenuFragment */
class ci implements a {
    final /* synthetic */ ch f8126a;

    ci(ch chVar) {
        this.f8126a = chVar;
    }

    public void m11594a(Bundle bundle) {
        C2538c.m12677c("LeftMenuFragment", "get new headImg and name from cloud success.");
        this.f8126a.f8125a.f8121o.sendEmptyMessage(3);
    }

    public void m11593a(int i) {
        C2538c.m12679d("LeftMenuFragment", "get new headImg and name from cloud failure.");
    }
}
