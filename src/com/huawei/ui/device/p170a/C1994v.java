package com.huawei.ui.device.p170a;

import android.os.Handler;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: DeviceSettingsInteractors */
class C1994v implements IBaseResponseCallback {
    final /* synthetic */ Handler f6958a;
    final /* synthetic */ C1990r f6959b;

    C1994v(C1990r c1990r, Handler handler) {
        this.f6959b = c1990r;
        this.f6958a = handler;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c("DeviceSettingsInteractors", "getDeviceBattery,err_code=" + i + ",objData=" + obj);
        if (i != 0 || obj == null) {
            C2538c.m12677c("DeviceSettingsInteractors", "getDeviceBattery failed ,err_code = " + i);
            return;
        }
        this.f6959b.f6954l = ((Integer) obj).intValue();
        C2538c.m12677c("DeviceSettingsInteractors", "mCurrentBattery=" + this.f6959b.f6954l);
        if (this.f6959b.f6954l < 5) {
            this.f6958a.sendEmptyMessage(9);
        } else {
            this.f6958a.sendEmptyMessage(15);
        }
    }
}
