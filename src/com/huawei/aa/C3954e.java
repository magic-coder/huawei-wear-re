package com.huawei.aa;

import android.os.Handler;
import android.os.Message;
import com.huawei.p190v.C2538c;
import java.lang.ref.WeakReference;

/* compiled from: HWStressMgr */
class C3954e extends Handler {
    WeakReference<a> f15164a;
    final /* synthetic */ a f15165b;

    C3954e(a aVar, a aVar2) {
        this.f15165b = aVar;
        this.f15164a = new WeakReference(aVar2);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (((a) this.f15164a.get()) != null) {
            C2538c.c("HWStressMgr", new Object[]{"msg.what = " + message.what});
            switch (message.what) {
                case 0:
                    if (a.a(this.f15165b) != null) {
                        a.a(this.f15165b).onResponse(400005, "time out.");
                        a.a(this.f15165b, false);
                        return;
                    }
                    C2538c.c("HWStressMgr", new Object[]{"mStressCallback is null."});
                    return;
                case 1:
                    a.b(this.f15165b);
                    return;
                default:
                    return;
            }
        }
    }
}
