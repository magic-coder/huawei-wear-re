package com.huawei.sim.esim.view;

import android.os.Handler;
import android.os.Message;
import com.huawei.p190v.C2538c;

/* compiled from: EsimProfileBTFailActivity */
class ai extends Handler {
    final /* synthetic */ EsimProfileBTFailActivity f20430a;

    ai(EsimProfileBTFailActivity esimProfileBTFailActivity) {
        this.f20430a = esimProfileBTFailActivity;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 2:
                C2538c.b("EsimProfileBTFailActivity", new Object[]{"message MESSAGE_BT_CONNECTED "});
                this.f20430a.m27250b();
                return;
            case 3:
                C2538c.b("EsimProfileBTFailActivity", new Object[]{"message MESSAGE_BT_DISCONNECTED "});
                this.f20430a.m27249a();
                return;
            case 4:
                C2538c.b("EsimProfileBTFailActivity", new Object[]{"message MESSAGE_BT_CONNECTING "});
                this.f20430a.m27252c();
                return;
            case 6:
                C2538c.b("EsimProfileBTFailActivity", new Object[]{"message MESSAGE_BT_RECONNECT_TIMEOUT "});
                this.f20430a.m27249a();
                return;
            default:
                return;
        }
    }
}
