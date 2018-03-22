package com.huawei.sim.esim.view;

import android.os.Message;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: EsimProfileBTFailActivity */
class ah implements IBaseResponseCallback {
    final /* synthetic */ EsimProfileBTFailActivity f20429a;

    ah(EsimProfileBTFailActivity esimProfileBTFailActivity) {
        this.f20429a = esimProfileBTFailActivity;
    }

    public void onResponse(int i, Object obj) {
        this.f20429a.f20386p.removeMessages(6);
        C2538c.b("EsimProfileBTFailActivity", new Object[]{"err_code " + i});
        Message obtain;
        if (1 == i) {
            obtain = Message.obtain();
            obtain.what = 4;
            this.f20429a.f20386p.sendMessage(obtain);
        } else if (2 == i) {
            obtain = Message.obtain();
            obtain.what = 2;
            this.f20429a.f20386p.sendMessage(obtain);
        } else {
            C2538c.b("EsimProfileBTFailActivity", new Object[]{"err_code other"});
            obtain = Message.obtain();
            obtain.what = 3;
            this.f20429a.f20386p.sendMessage(obtain);
        }
    }
}
