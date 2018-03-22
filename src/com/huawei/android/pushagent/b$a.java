package com.huawei.android.pushagent;

import android.content.Intent;
import com.huawei.android.pushagent.b.a;
import com.huawei.android.pushagent.c.a.e;

final class b$a implements Runnable {
    final /* synthetic */ b f15395a;
    private a f15396b;
    private Intent f15397c;

    public b$a(b bVar, a aVar, Intent intent) {
        this.f15395a = bVar;
        this.f15396b = aVar;
        this.f15397c = intent;
    }

    public void run() {
        try {
            this.f15396b.a(b.b(this.f15395a), this.f15397c);
        } catch (Throwable e) {
            e.c("PushLogAC2712", "ReceiverDispatcher: call Receiver:" + this.f15396b.getClass().getSimpleName() + ", intent:" + this.f15397c + " failed:" + e.toString(), e);
        }
    }
}
