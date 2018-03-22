package com.huawei.sim.esim.view;

import android.os.Handler;
import android.os.Message;
import com.huawei.p190v.C2538c;

/* compiled from: EsimConformBTFailActivity */
class C5944u extends Handler {
    final /* synthetic */ EsimConformBTFailActivity f20459a;

    C5944u(EsimConformBTFailActivity esimConformBTFailActivity) {
        this.f20459a = esimConformBTFailActivity;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        C2538c.b("ConformReportActivity", new Object[]{"message " + message.what});
        switch (message.what) {
            case 2:
                this.f20459a.f20336p = null;
                this.f20459a.m27226c();
                return;
            case 3:
                this.f20459a.m27224b();
                return;
            case 4:
                this.f20459a.m27228d();
                return;
            case 6:
                this.f20459a.m27224b();
                return;
            default:
                return;
        }
    }
}
