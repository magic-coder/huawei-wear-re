package com.huawei.ui.homewear21.p175a;

import com.huawei.hwdevicedfxmanager.callback.IDeviceDFXBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: HomeFragment */
class aa implements IDeviceDFXBaseResponseCallback {
    final /* synthetic */ C2217a f8042a;

    aa(C2217a c2217a) {
        this.f8042a = c2217a;
    }

    public void onSuccess(int i, String str) {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "onSuccess suc_code = " + i + ",err_msg = " + str);
        this.f8042a.f8014Y.m10363a(true);
    }

    public void onFailure(int i, String str) {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "onFailure err_code = " + i + ",err_msg = " + str);
        this.f8042a.f8014Y.m10363a(true);
    }
}
