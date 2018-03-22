package com.huawei.sim.esim.view;

import android.os.Message;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: EsimActivationActivity */
class C5936m implements IBaseResponseCallback {
    final /* synthetic */ EsimActivationActivity f20449a;

    C5936m(EsimActivationActivity esimActivationActivity) {
        this.f20449a = esimActivationActivity;
    }

    public void onResponse(int i, Object obj) {
        this.f20449a.f20320o.removeMessages(6);
        Message obtain;
        if (1 == i) {
            C2538c.b("EsimActivationActivity", new Object[]{"err_code DEVICE_CONNECTING"});
            obtain = Message.obtain();
            obtain.what = 4;
            this.f20449a.f20320o.sendMessage(obtain);
        } else if (2 == i) {
            C2538c.b("EsimActivationActivity", new Object[]{"err_code DEVICE_CONNECTED"});
            obtain = Message.obtain();
            obtain.what = 2;
            this.f20449a.f20320o.sendMessage(obtain);
        } else {
            obtain = Message.obtain();
            obtain.what = 3;
            this.f20449a.f20320o.sendMessage(obtain);
        }
    }
}
