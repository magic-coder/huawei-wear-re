package com.huawei.bone.p552b;

import android.os.Handler;
import android.os.Message;
import com.huawei.p190v.C2538c;

/* compiled from: MainInterators */
class C6772q extends Handler {
    final /* synthetic */ C6756a f23196a;

    C6772q(C6756a c6756a) {
        this.f23196a = c6756a;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 100:
                C2538c.c("MainInterators", new Object[]{"Enter loginHwid 4"});
                this.f23196a.m30070w();
                return;
            case 101:
                this.f23196a.m30066s();
                return;
            default:
                C2538c.b("MainInterators", new Object[]{"enter default"});
                return;
        }
    }
}
