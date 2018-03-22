package com.huawei.hwfitnessmgr;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.p190v.C2538c;
import java.lang.ref.WeakReference;

/* compiled from: FitnessMgrStorage */
class C5047o extends Handler {
    WeakReference<C5039g> f18258a;

    C5047o(C5039g c5039g, Looper looper) {
        super(looper);
        this.f18258a = new WeakReference(c5039g);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        C5039g c5039g = (C5039g) this.f18258a.get();
        if (c5039g != null) {
            switch (message.what) {
                case 0:
                    C2538c.a("05", 1, "Fitness_MgrStorage", new Object[]{"save data success"});
                    c5039g.m24316a(0);
                    return;
                case 1:
                    C2538c.a("05", 1, "Fitness_MgrStorage", new Object[]{"save data fail"});
                    c5039g.m24316a(300006);
                    return;
                default:
                    C2538c.a("05", 1, "Fitness_MgrStorage", new Object[]{"unknown msg type"});
                    return;
            }
        }
    }
}
