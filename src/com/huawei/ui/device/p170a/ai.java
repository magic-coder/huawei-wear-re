package com.huawei.ui.device.p170a;

import com.huawei.datatype.DataDeviceInfo;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p108n.C1204c;
import com.huawei.p190v.C2538c;

/* compiled from: UpdateInteractors */
class ai implements IBaseResponseCallback {
    final /* synthetic */ ah f6884a;

    ai(ah ahVar) {
        this.f6884a = ahVar;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c("UpdateInteractors", "mFirmwareVersionCallback err_code = " + i + ",objData:" + obj);
        if (i == 0) {
            this.f6884a.f6870e = (DataDeviceInfo) obj;
            if (this.f6884a.f6870e != null) {
                this.f6884a.f6871f = this.f6884a.f6870e.getDevice_type();
                this.f6884a.f6873h = this.f6884a.f6870e.getDevice_soft_version();
                C2538c.m12677c("UpdateInteractors", "mFirmwareVersionCallback deviceType = " + this.f6884a.f6871f);
                C2538c.m12677c("UpdateInteractors", "mFirmwareVersionCallback deviceSoftVersion = " + this.f6884a.f6873h);
                if (this.f6884a.f6880o == null) {
                    this.f6884a.f6880o = C1204c.m5370a(this.f6884a.f6878m);
                }
                this.f6884a.f6875j = this.f6884a.f6880o.m5447c();
                if (this.f6884a.f6875j == null) {
                    C2538c.m12677c("UpdateInteractors", "deviceInfo is null!");
                    return;
                }
                this.f6884a.f6872g = this.f6884a.f6875j.getDeviceIdentify();
                C2538c.m12677c("UpdateInteractors", "mFirmwareVersionCallback deviceBtMac = " + this.f6884a.f6872g);
                this.f6884a.m10336c(this.f6884a.f6873h);
                this.f6884a.f6879n.m4510a(this.f6884a.f6871f, this.f6884a.f6873h, this.f6884a.f6872g, Boolean.valueOf(true));
            }
        }
    }
}
