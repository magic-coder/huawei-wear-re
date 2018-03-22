package com.huawei.ui.device.p170a;

import android.content.Intent;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.hwservicesmgr.q;
import com.huawei.p190v.C2538c;

/* compiled from: UpdateInteractors */
class am extends q {
    final /* synthetic */ ah f6888a;

    am(ah ahVar) {
        this.f6888a = ahVar;
    }

    public void m10361a(int i, String str) {
        C2538c.m12677c("UpdateInteractors", "errorcode = " + i);
        if (i == 100000 || i == 109002) {
            C2538c.m12677c("UpdateInteractors", "device support silence ota!");
            Intent intent = new Intent("action_band_auto_check_new_version_result");
            intent.addFlags(1610612736);
            intent.putExtra("result", 13);
            this.f6888a.f6878m.sendBroadcast(intent, C0976c.f1642a);
            return;
        }
        C2538c.m12677c("UpdateInteractors", "have new band version make toast!");
        intent = new Intent("action_band_auto_check_new_version_result");
        intent.addFlags(1610612736);
        intent.putExtra("result", 12);
        this.f6888a.f6878m.sendBroadcast(intent, C0976c.f1642a);
    }
}
