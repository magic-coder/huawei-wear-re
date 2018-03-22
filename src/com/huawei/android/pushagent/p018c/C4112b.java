package com.huawei.android.pushagent.p018c;

import android.content.Context;
import com.huawei.android.pushagent.PushService;
import com.huawei.android.pushagent.b.b.a;
import com.huawei.android.pushagent.b.b.c;
import com.huawei.android.pushagent.c.a.e;

final class C4112b implements Runnable {
    final /* synthetic */ Context f15505a;

    C4112b(Context context) {
        this.f15505a = context;
    }

    public void run() {
        try {
            Thread.sleep(a.a(this.f15505a).O() * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        e.a("PushLogAC2712", "start to handle clone event");
        com.huawei.android.pushagent.c.a.t(this.f15505a);
        com.huawei.android.pushagent.c.a.u(this.f15505a);
        com.huawei.android.pushagent.c.a.e(this.f15505a, "pushConfig");
        c.a(this.f15505a).a();
        com.huawei.android.pushagent.c.a.v(this.f15505a);
        if (PushService.a() != null) {
            PushService.a().stopService();
        }
    }
}
