package com.huawei.sim.esim.view;

import android.os.Message;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: EsimProfileAcitvity */
class ac implements IBaseResponseCallback {
    final /* synthetic */ EsimProfileAcitvity f20424a;

    ac(EsimProfileAcitvity esimProfileAcitvity) {
        this.f20424a = esimProfileAcitvity;
    }

    public void onResponse(int i, Object obj) {
        C2538c.b("EsimProfileAcitvity", new Object[]{"error_code " + i});
        Message obtain = Message.obtain();
        obtain.what = 5;
        obtain.arg1 = i;
        this.f20424a.f20369w.sendMessage(obtain);
    }
}
