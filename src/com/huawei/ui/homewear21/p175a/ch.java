package com.huawei.ui.homewear21.p175a;

import com.huawei.ab.C0630m;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.p190v.C2538c;

/* compiled from: LeftMenuFragment */
class ch implements Runnable {
    final /* synthetic */ cf f8125a;

    ch(cf cfVar) {
        this.f8125a = cfVar;
    }

    public void run() {
        C2538c.m12677c("LeftMenuFragment", "==========Enter HWUserProfileMgr");
        C0630m.m2297a(BaseApplication.m2632b()).m2305a(this.f8125a.f8122p, new ci(this));
    }
}
