package com.huawei.p192w;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.p190v.C2538c;
import com.huawei.w.c;

/* compiled from: HWMultiSimMgr */
class C6144h extends Handler {
    final /* synthetic */ c f21194a;

    C6144h(c cVar, Looper looper) {
        this.f21194a = cVar;
        super(looper);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        C2538c.b("HWMultiSimMgr", new Object[]{"msg.what " + message.what});
        switch (message.what) {
            case 0:
                c.a(this.f21194a, 1, 100001, null);
                c.a(this.f21194a, 2, -1, null);
                return;
            case 1:
                c.a(this.f21194a, 2, -1, null);
                return;
            case 2:
                c.a(this.f21194a, 3, 100001, null);
                c.a(this.f21194a, 4, -1, null);
                return;
            case 3:
                c.a(this.f21194a, 4, -1, null);
                return;
            case 4:
                this.f21194a.c();
                return;
            case 5:
                c.c(this.f21194a);
                return;
            default:
                return;
        }
    }
}
