package com.huawei.ui.device.p170a;

import android.content.Intent;
import com.huawei.datatype.DataDeviceInfo;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.p190v.C2538c;

/* compiled from: UpdateInteractors */
class aj implements IBaseResponseCallback {
    final /* synthetic */ ah f6885a;

    aj(ah ahVar) {
        this.f6885a = ahVar;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c("UpdateInteractors", "mFirmwareVersionCallback err_code = " + i + ",objData:" + obj);
        if (i == 0) {
            this.f6885a.f6870e = (DataDeviceInfo) obj;
            if (this.f6885a.f6870e != null) {
                this.f6885a.f6873h = this.f6885a.f6870e.getDevice_soft_version();
                C2538c.m12677c("UpdateInteractors", "doManualCheckDeviceNewVersion callback deviceSoftVersion = " + this.f6885a.f6873h);
                this.f6885a.f6879n.m4510a(this.f6885a.f6871f, this.f6885a.f6873h, this.f6885a.f6872g, Boolean.valueOf(false));
                return;
            }
            return;
        }
        C2538c.m12674b("UpdateInteractors", "failed to get soft version!");
        Intent intent = new Intent("action_app_check_new_version_state");
        intent.addFlags(1610612736);
        intent.putExtra("result", 3);
        intent.putExtra("state", 11);
        this.f6885a.f6878m.sendBroadcast(intent, C0976c.f1642a);
    }
}
