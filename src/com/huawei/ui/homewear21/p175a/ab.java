package com.huawei.ui.homewear21.p175a;

import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.base.b;

/* compiled from: HomeFragment */
class ab implements b {
    final /* synthetic */ C2217a f8043a;

    ab(C2217a c2217a) {
        this.f8043a = c2217a;
    }

    public void m11565a(int i, Object obj) {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "dataSync refreshAllCardsDetailData onResponse err_code = " + i);
        C2538c.m12661a("MainUI", 0, "HomeFragment", "dataSync refreshAllCardsDetailData onResponse objData = " + obj);
        if (this.f8043a.bu == null) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "dataSync handler is null return!!!");
        } else if (i == 0) {
            this.f8043a.bu.sendEmptyMessage(1007);
        } else {
            this.f8043a.al();
            C2538c.m12661a("MainUI", 0, "HomeFragment", "refreshAllData -- error:" + i);
        }
    }
}
