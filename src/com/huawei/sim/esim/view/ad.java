package com.huawei.sim.esim.view;

import android.os.Handler;
import android.os.Message;
import com.huawei.p190v.C2538c;

/* compiled from: EsimProfileAcitvity */
class ad extends Handler {
    final /* synthetic */ EsimProfileAcitvity f20425a;

    ad(EsimProfileAcitvity esimProfileAcitvity) {
        this.f20425a = esimProfileAcitvity;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        C2538c.b("EsimProfileAcitvity", new Object[]{"message " + message.what});
        switch (message.what) {
            case 2:
                this.f20425a.m27236b();
                return;
            case 3:
                this.f20425a.m27232a();
                return;
            case 4:
                this.f20425a.m27240c();
                return;
            case 5:
                this.f20425a.m27233a(message.arg1);
                return;
            case 6:
                this.f20425a.m27232a();
                return;
            default:
                return;
        }
    }
}
