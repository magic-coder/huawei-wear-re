package com.huawei.ui.device.p170a;

import android.os.Handler;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: CompatibilityInteractor */
class C1976d implements IBaseResponseCallback {
    final /* synthetic */ Handler f6903a;
    final /* synthetic */ IBaseResponseCallback f6904b;
    final /* synthetic */ long f6905c;
    final /* synthetic */ long f6906d;
    final /* synthetic */ C1975c f6907e;

    C1976d(C1975c c1975c, Handler handler, IBaseResponseCallback iBaseResponseCallback, long j, long j2) {
        this.f6907e = c1975c;
        this.f6903a = handler;
        this.f6904b = iBaseResponseCallback;
        this.f6905c = j;
        this.f6906d = j2;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c("CompatibilityInteractor", "getDeviceListFromWear onResponse err_code:" + i);
        if (this.f6903a != null) {
            this.f6903a.removeMessages(100, this.f6904b);
        }
        if (Math.abs(System.currentTimeMillis() - this.f6905c) > this.f6906d) {
            C2538c.m12677c("CompatibilityInteractor", "getDeviceListFromWear outtime:" + Math.abs(System.currentTimeMillis() - this.f6905c));
            return;
        }
        this.f6904b.onResponse(i, obj);
    }
}
