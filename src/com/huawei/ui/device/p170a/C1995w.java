package com.huawei.ui.device.p170a;

import android.os.Handler;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: DeviceSettingsInteractors */
class C1995w implements IBaseResponseCallback {
    final /* synthetic */ Handler f6960a;
    final /* synthetic */ C1990r f6961b;

    C1995w(C1990r c1990r, Handler handler) {
        this.f6961b = c1990r;
        this.f6960a = handler;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c("DeviceSettingsInteractors", "mRestoreFactoryCallback,err_code=" + i);
        if (i == 0) {
            this.f6960a.sendEmptyMessage(8);
            return;
        }
        this.f6960a.sendEmptyMessage(11);
        C2538c.m12677c("DeviceSettingsInteractors", "mRestoreFactory failed.");
    }
}
