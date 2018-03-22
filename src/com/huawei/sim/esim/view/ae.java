package com.huawei.sim.esim.view;

import android.os.Message;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: EsimProfileAcitvity */
class ae implements IBaseResponseCallback {
    final /* synthetic */ EsimProfileAcitvity f20426a;

    ae(EsimProfileAcitvity esimProfileAcitvity) {
        this.f20426a = esimProfileAcitvity;
    }

    public void onResponse(int i, Object obj) {
        C2538c.b("EsimProfileAcitvity", new Object[]{"err_code = " + i});
        this.f20426a.f20369w.removeMessages(6);
        Message obtain;
        if (1 == i) {
            obtain = Message.obtain();
            obtain.what = 4;
            this.f20426a.f20369w.sendMessage(obtain);
        } else if (2 == i) {
            obtain = Message.obtain();
            obtain.what = 2;
            this.f20426a.f20369w.sendMessage(obtain);
        } else {
            obtain = Message.obtain();
            obtain.what = 3;
            this.f20426a.f20369w.sendMessage(obtain);
        }
    }
}
