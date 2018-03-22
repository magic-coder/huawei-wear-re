package com.huawei.hwfitnessmgr;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.p190v.C2538c;

import java.lang.ref.WeakReference;

/* compiled from: HWFitnessMgr */
class ap extends Handler {
    WeakReference<q> f18157a;

    ap(q qVar, Looper looper) {
        super(looper);
        this.f18157a = new WeakReference(qVar);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        q qVar = (q) this.f18157a.get();
        if (qVar != null) {
            C2538c.a("05", 1, "HWFitnessMgr", new Object[]{"handleMessage msg=", Integer.valueOf(message.what)});
            switch (message.what) {
                case 0:
                    C2538c.e("HWFitnessMgr", new Object[]{"sync detail time out"});
                    q.a(qVar, 300001);
                    return;
                case 1:
                    C2538c.e("HWFitnessMgr", new Object[]{"get frame count time out"});
                    return;
                case 2:
                    C2538c.e("HWFitnessMgr", new Object[]{"get frame time out"});
                    return;
                case 3:
                    C2538c.c("HWFitnessMgr", new Object[]{"Sync Complete msg"});
                    qVar.b(0);
                    return;
                case 4:
                    C2538c.c("HWFitnessMgr", new Object[]{"Sync today timeout msg"});
                    q.b(qVar, 300001);
                    return;
                case 5:
                    C2538c.c("HWFitnessMgr", new Object[]{"Save fitness data timeout msg"});
                    qVar.b(300001);
                    return;
                case 100:
                    qVar.b = 0;
                    return;
                default:
                    C2538c.e("HWFitnessMgr", new Object[]{"unknown msg type"});
                    return;
            }
        }
    }
}
