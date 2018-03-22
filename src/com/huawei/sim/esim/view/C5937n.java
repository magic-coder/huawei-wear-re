package com.huawei.sim.esim.view;

import android.os.Handler;
import android.os.Message;
import com.huawei.p190v.C2538c;

/* compiled from: EsimActivationActivity */
class C5937n extends Handler {
    final /* synthetic */ EsimActivationActivity f20450a;

    C5937n(EsimActivationActivity esimActivationActivity) {
        this.f20450a = esimActivationActivity;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        C2538c.b("EsimActivationActivity", new Object[]{"message " + message.what});
        switch (message.what) {
            case 2:
                this.f20450a.m27213d();
                return;
            case 3:
                this.f20450a.m27211c();
                return;
            case 4:
                this.f20450a.m27215e();
                return;
            case 6:
                this.f20450a.m27211c();
                return;
            default:
                return;
        }
    }
}
