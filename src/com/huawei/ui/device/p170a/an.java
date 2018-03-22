package com.huawei.ui.device.p170a;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.C1971j;
import java.util.List;

/* compiled from: UpdateInteractors */
class an implements IBaseResponseCallback {
    final /* synthetic */ C1971j f6889a;
    final /* synthetic */ int f6890b;
    final /* synthetic */ ah f6891c;

    an(ah ahVar, C1971j c1971j, int i) {
        this.f6891c = ahVar;
        this.f6889a = c1971j;
        this.f6890b = i;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0 && obj != null) {
            try {
                obj = (List) obj;
            } catch (ClassCastException e) {
                C2538c.m12677c("UpdateInteractors", "ClassCastException :" + e.getMessage());
                obj = null;
            }
            if (obj == null || obj.size() <= 0) {
                this.f6889a.m10247a("device", "device_ota", new ao(this));
                return;
            }
            C2538c.m12677c("UpdateInteractors", "has message donot makeMessage, ");
        }
    }
}
