package com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d;

import android.os.Message;
import com.huawei.p190v.C2538c;

/* compiled from: DataTransferStateMachine */
class ah implements af {
    final /* synthetic */ C1719y f4446a;

    private ah(C1719y c1719y) {
        this.f4446a = c1719y;
    }

    public void mo2567a(Message message) {
        switch (message.what) {
            case 1:
                this.f4446a.m8186b(message);
                return;
            case 2:
                this.f4446a.f4606D.clear();
                this.f4446a.f4617i = this.f4446a.f4617i + 1;
                if (this.f4446a.f4617i <= this.f4446a.f4613e) {
                    C2538c.m12674b("DataTransferStateMachine", "command respond time out try resend.");
                    this.f4446a.m8185b(2);
                    synchronized (this.f4446a.f4621m) {
                        if (this.f4446a.f4621m.size() > 0 && this.f4446a.f4625q != null) {
                            this.f4446a.f4625q.sendEmptyMessage(0);
                        }
                    }
                    return;
                }
                this.f4446a.f4617i = 0;
                this.f4446a.f4618j = 0;
                C1719y.f4597a.m7886a(1);
                C2538c.m12680e("DataTransferStateMachine", "Slice send respond time out, drop this command.");
                this.f4446a.m8215l();
                return;
            default:
                return;
        }
    }
}
