package com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d;

import android.os.Message;
import com.huawei.p190v.C2538c;

/* compiled from: DataTransferStateMachine */
class ai implements af {
    final /* synthetic */ C1719y f4447a;

    private ai(C1719y c1719y) {
        this.f4447a = c1719y;
    }

    public void mo2567a(Message message) {
        C2538c.m12674b("DataTransferStateMachine", "ReceivingState msg.what: " + message.what);
        switch (message.what) {
            case 1:
                this.f4447a.m8170a(message);
                return;
            case 2:
                this.f4447a.m8208h();
                return;
            case 3:
                C2538c.m12680e("DataTransferStateMachine", "Wait dfu respond timeout");
                if (this.f4447a.f4622n.size() > 0) {
                    this.f4447a.f4622n.clear();
                }
                synchronized (this.f4447a.f4621m) {
                    this.f4447a.f4614f = false;
                    if (this.f4447a.f4621m.size() > 0) {
                        this.f4447a.f4621m.clear();
                    }
                }
                this.f4447a.m8185b(2);
                if (this.f4447a.f4607E != null) {
                    this.f4447a.f4607E = null;
                    return;
                }
                return;
            default:
                return;
        }
    }
}
