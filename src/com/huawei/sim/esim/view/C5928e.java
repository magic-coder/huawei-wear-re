package com.huawei.sim.esim.view;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: ConformActivity */
class C5928e implements IBaseResponseCallback {
    final /* synthetic */ ConformActivity f20441a;

    C5928e(ConformActivity conformActivity) {
        this.f20441a = conformActivity;
    }

    public void onResponse(int i, Object obj) {
        C2538c.b("ConformActivity", new Object[]{"codeBaseResponseCallback err_code " + i});
    }
}
