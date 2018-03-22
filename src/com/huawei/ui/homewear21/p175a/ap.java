package com.huawei.ui.homewear21.p175a;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: HomeFragment */
class ap implements IBaseResponseCallback {
    final /* synthetic */ ao f8059a;

    ap(ao aoVar) {
        this.f8059a = aoVar;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c("HomeFragment", "Enter sendDataToHealth err_code:" + i);
    }
}
