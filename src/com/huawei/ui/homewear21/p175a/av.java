package com.huawei.ui.homewear21.p175a;

import com.huawei.datatype.WearableOpenAppInfo;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: HomeFragment */
class av implements IBaseResponseCallback {
    final /* synthetic */ C2217a f8065a;

    av(C2217a c2217a) {
        this.f8065a = c2217a;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "registerOpenAppIBaseResponseCallback() err_code = " + i);
        if (i == 0 && obj != null) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "registerOpenAppIBaseResponseCallback() objData = " + obj);
            WearableOpenAppInfo wearableOpenAppInfo = (WearableOpenAppInfo) obj;
            String className = wearableOpenAppInfo.getClassName();
            this.f8065a.m11471a(wearableOpenAppInfo.getPackageName(), className);
        }
    }
}
