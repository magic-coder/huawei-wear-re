package com.huawei.ui.homewear21.p175a;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: HomeFragment */
class ay implements IBaseResponseCallback {
    final /* synthetic */ C2217a f8068a;

    ay(C2217a c2217a) {
        this.f8068a = c2217a;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0 && (obj instanceof Boolean)) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter objData:" + ((Boolean) obj).booleanValue());
            if (((Boolean) obj).booleanValue()) {
                this.f8068a.be();
                return;
            }
            return;
        }
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter checkGoHealthForBind enter else");
    }
}
